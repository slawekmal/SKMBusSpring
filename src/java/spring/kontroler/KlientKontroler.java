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
@RequestMapping(value = "/", method = RequestMethod.GET)
public class KlientKontroler {

    @Autowired
    private KlientService klientService;
    @Autowired
    private KursService kursService;

    @RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
    public String rejestracja(Model model) {
        model.addAttribute("klient", new Klient());
        return "rejestracja";
    }

    //For add and update Klient both
    @RequestMapping(value = "/rejestracja/go", method = RequestMethod.POST)
    public String zarejestruj(@ModelAttribute("klient") Klient k) {

        klientService.createKlient(k);

        return "redirect:/rejestracja";

    }

    @RequestMapping(value = "/konto", method = RequestMethod.GET)
    public String konto(Model model) {
        model.addAttribute("kursy", Logowanie.zalogowany.getKursy());
        return "konto";
    }

    @RequestMapping("/konto/usun/{id}")
    public String rezerwacja(@PathVariable("id") long id, Model model) {
       if(Logowanie.zalogowany != null){
            Logowanie.zalogowany.getKursy().remove(kursService.findKursById(id));
            klientService.updateKlient(Logowanie.zalogowany);
        }
       return "redirect:/konto";
    }

}
