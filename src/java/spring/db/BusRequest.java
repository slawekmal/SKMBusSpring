package spring.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.model.Klient;
import spring.model.Kurs;

/**
 *
 * @author SKM
 */
@Component
@Transactional
public class BusRequest {

//    @PersistenceContext
    EntityManager em;

    public void createKurs(Kurs kurs) {
        em.persist(kurs);
        em.flush();
    }

    public void updateKlient(Klient klient) {
        if (klient.getId() != 0) {
            em.merge(klient);
            em.flush();
        }
    }

    public Klient findKlientByEmail(String email) {
        Query query = em.createQuery("SELECT k FROM Klient k WHERE k.email = :email");
        query.setParameter("email", email);
        return (Klient) query.getResultList().get(0);
    }

    public void updateKurs(Kurs kurs) {
        if (kurs.getId() != 0) {
            em.merge(kurs);
            em.flush();
        }
    }
    public void createKlient(Klient klient) {
        em.persist(klient);
        em.flush();
    }

    public void deleteKurs(Kurs kurs) {
        em.remove(kurs);
        em.flush();
    }

    public void deleteKlient(Klient klient) {
        em.remove(em.contains(klient) ? klient : em.merge(klient));
        em.flush();
    }

    public List<Klient> getAllKlient() {
        Query query = em.createQuery("SELECT k FROM Klient k");
        return (List<Klient>) query.getResultList();
    }

    public List<Kurs> getAllKurs() {
        Query query = em.createQuery("SELECT k FROM Kurs k");
        return (List<Kurs>) query.getResultList();
    }
    
    public List<Kurs> findKursByKierunek(String kierunek){
        Query query = em.createQuery("SELECT k FROM Kurs k WHERE k.kierunek = :kierunek");
        query.setParameter("kierunek", kierunek);
        return (List<Kurs>) query.getResultList();
    }
}
