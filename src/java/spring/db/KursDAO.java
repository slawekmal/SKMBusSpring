package spring.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import spring.model.Kurs;

@Repository
public class KursDAO {
    @PersistenceContext
    EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void createKurs(Kurs kurs) {
        em.persist(kurs);
        em.flush();
    }

    public void updateKurs(Kurs kurs) {
        if (kurs.getId() != 0) {
            em.merge(kurs);
            em.flush();
        }
    }
    
        public void deleteKurs(Kurs kurs) {
        em.remove(em.contains(kurs) ? kurs : em.merge(kurs));
        em.flush();
    }

    public List<Kurs> listKurs() {
        Query query = em.createQuery("SELECT k FROM Kurs k");
        return (List<Kurs>) query.getResultList();
    }

    public List<Kurs> findKursByKierunek(String kierunek){
        Query query = em.createQuery("SELECT k FROM Kurs k WHERE k.kierunek = :kierunek");
        query.setParameter("kierunek", kierunek);
        return (List<Kurs>) query.getResultList();
    }
    
     public Kurs findKursById(long id){
        Query query = em.createQuery("SELECT k FROM Kurs k WHERE k.id = :id");
        query.setParameter("id", id);
        return (Kurs)query.getResultList().get(0);
    }
    
}
