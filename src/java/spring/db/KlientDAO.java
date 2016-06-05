package spring.db;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import spring.model.Klient;

@Repository
public class KlientDAO {

    @PersistenceContext
    EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void createKlient(Klient klient) {
        em.persist(klient);
        em.flush();
    }

    public void updateKlient(Klient klient) {
        if (klient.getId() != 0) {
            em.merge(klient);
            em.flush();
        }
    }

    public void deleteKlient(Klient klient) {
        em.remove(em.contains(klient) ? klient : em.merge(klient));
        em.flush();
    }

    public List<Klient> listKlient() {
        Query query = em.createQuery("SELECT k FROM Klient k");
        return (List<Klient>) query.getResultList();
    }

    public Klient findKlientByEmail(String email) {
        Query query = em.createQuery("SELECT k FROM Klient k WHERE k.email = :email");
        query.setParameter("email", email);
        return (Klient) query.getResultList().get(0);
    }

    public Klient findKlientById(long id) {
        Query query = em.createQuery("SELECT k FROM Klient k WHERE k.id = :id");
        query.setParameter("id", id);
        return (Klient) query.getResultList().get(0);
    }

    public Klient isValidUser(String email, String haslo) throws SQLException {
        Query query = em.createQuery("SELECT k FROM Klient k WHERE k.email = :email AND k.haslo = :haslo");
        query.setParameter("email", email);
        query.setParameter("haslo", haslo);
        List list = query.getResultList();
        if ((list != null) && (list.size() > 0)) {
            return (Klient) list.get(0);
        } else {
            return null;
        }
    }
}
