package spring.db;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.model.Kurs;

@Service
public class KursService {

    @Autowired
    KursDAO kursDAO;

    public void setKursDAO(KursDAO kursDAO) {
        this.kursDAO = kursDAO;
    }

    @Transactional
    public void createKurs(Kurs kurs) {
        kursDAO.createKurs(kurs);
    }

    @Transactional
    public void updateKurs(Kurs kurs) {
        kursDAO.updateKurs(kurs);
    }

    @Transactional
    public void deleteKurs(Kurs kurs) {
        kursDAO.deleteKurs(kurs);
    }

    @Transactional
    public List<Kurs> listKurs() {
        return kursDAO.listKurs();
    }

    @Transactional
    public List<Kurs> findKursByKierunek(String kierunek) {
        return kursDAO.findKursByKierunek(kierunek);
    }

    @Transactional
    public Kurs findKursById(long id) {
        return kursDAO.findKursById(id);
    }

}
