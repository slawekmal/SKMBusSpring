package spring.db;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.model.Klient;

@Service
public class KlientService {

    @Autowired
    KlientDAO klientDAO;

    public void setKlientDAO(KlientDAO klientDAO) {
        this.klientDAO = klientDAO;
    }

    @Transactional
    public void createKlient(Klient klient) {
        klientDAO.createKlient(klient);
    }

    @Transactional
    public void updateKlient(Klient klient) {
        klientDAO.updateKlient(klient);
    }

    @Transactional
    public void deleteKlient(Klient klient) {
        klientDAO.deleteKlient(klient);
    }

    @Transactional
    public List<Klient> listKlient() {
        return klientDAO.listKlient();
    }

    @Transactional
    public Klient findKlientByEmail(String email) {
        return klientDAO.findKlientByEmail(email);
    }

    @Transactional
    public Klient findKlientById(long id) {
        return klientDAO.findKlientById(id);
    }

    @Transactional
    public Klient isValidUser(String email, String haslo) throws SQLException {
        return klientDAO.isValidUser(email, haslo);
    }

}
