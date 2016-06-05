package spring.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.db.KlientService;
import spring.db.KursService;
import spring.model.Klient;
import spring.model.Kurs;

@Controller
@RequestMapping(value = "/rozklad", method = RequestMethod.GET)
public class Rezerwacja {

    @Autowired
    private KursService kursService;
    @Autowired
    private KlientService klientService;
    private Kurs kurs;
    private Kurs kurs2;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rozklad(Model model) {
        model.addAttribute("kursy", kursService.listKurs());
        return "rozklad";
    }

    @RequestMapping("/rezerwuj/{id}")
    public String rezerwacja(@PathVariable("id") long id, Model model) {
        kurs = kursService.findKursById(id);
        kurs2 = new Kurs();
        if (kurs != null) {
            model.addAttribute("kurs", kurs);
            model.addAttribute("kurs2", kurs2);
        }
        return "rezerwacja";
    }

    @RequestMapping(value = "/rezerwuj/{id}/go", method = RequestMethod.POST)
    public String zarezerwuj(@ModelAttribute("kurs2") Kurs kurs2, Model model) {
        if (kurs != null) {
            if (Logowanie.zalogowany != null && kurs.getMiejsca() >= kurs2.getMiejsca()) {
                kurs.setMiejsca(kurs.getMiejsca() - kurs2.getMiejsca());
                kursService.updateKurs(kurs);
                for (int i = 0; i < kurs2.getMiejsca(); i++) {
                    Logowanie.zalogowany.getKursy().add(kurs);
                }
                klientService.updateKlient(Logowanie.zalogowany);
                model.addAttribute("klient", Logowanie.zalogowany);
                return "konto";
            }
        }
        return "rezerwacja";
    }

}
