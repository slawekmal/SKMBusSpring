package spring.kontroler;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.db.KlientService;
import spring.db.KursService;
import spring.model.Kurs;
import spring.model.Pomocnik;

@Controller
@RequestMapping(value = "/rozklad", method = RequestMethod.GET)
public class Rezerwacja {

    @Autowired
    private KursService kursService;
    @Autowired
    private KlientService klientService;
    private Kurs kurs;
    private List<Kurs> rozklad;
    private Pomocnik pomocnik;

    @PostConstruct
    public void init() {
        this.pomocnik = new Pomocnik();
        this.rozklad = kursService.listKurs();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rozklad(Model model) {
        if(Logowanie.zalogowany != null)
            this.pomocnik.setZalogowany(true);
        else
            this.pomocnik.setZalogowany(false);
        model.addAttribute("pomocnik", pomocnik);
        model.addAttribute("klient", Logowanie.zalogowany);
        rozklad.sort(new KursComparator());
        model.addAttribute("kursy", rozklad);
        return "rozklad";
    }

    @RequestMapping(value = "/filtruj", method = RequestMethod.POST)
    public String filtruj(@ModelAttribute("pomocnik") Pomocnik pomocnik2, Model model) {
        if (pomocnik2 != null) {
            pomocnik = pomocnik2;
        }
        wybierzRozklad();
        return "redirect:/rozklad/";
    }

    public void wybierzRozklad() {
        if (this.pomocnik != null) {
            if (this.pomocnik.getKierunek() != null) {
                if (!this.pomocnik.getKierunek().equalsIgnoreCase("Wszystkie")) {
                    rozklad = kursService.findKursByKierunek(pomocnik.getKierunek());
                } else {
                    rozklad = kursService.listKurs();
                }
            }
        }
    }

    @RequestMapping("/rezerwuj/{id}")
    public String rezerwacja(@PathVariable("id") long id, Model model) {
        kurs = kursService.findKursById(id);
        if(pomocnik == null)
            pomocnik = new Pomocnik();
        if (kurs != null) {
            model.addAttribute("kurs", kurs);
            model.addAttribute("pomocnik", pomocnik);
        }
        return "rezerwacja";
    }

    @RequestMapping(value = "/rezerwuj/{id}/go", method = RequestMethod.POST)
    public String zarezerwuj(@ModelAttribute("pomocnik") Pomocnik pomocnik, Model model) {
        if (kurs != null) {
            if (Logowanie.zalogowany != null && kurs.getMiejsca() >= pomocnik.getMiejsca()) {
                kurs.setMiejsca(kurs.getMiejsca() - pomocnik.getMiejsca());
                kursService.updateKurs(kurs);
                for (int i = 0; i < pomocnik.getMiejsca(); i++) {
                    Logowanie.zalogowany.getKursy().add(kurs);
                }
                klientService.updateKlient(Logowanie.zalogowany);
                model.addAttribute("klient", Logowanie.zalogowany);
                return "redirect:../../../konto";
            }
        }
        return "rezerwacja";
    }

    public class KursComparator implements Comparator<Kurs> {

        @Override
        public int compare(Kurs k1, Kurs k2) {
            return k1.getId().compareTo(k2.getId());
        }
    }

}
