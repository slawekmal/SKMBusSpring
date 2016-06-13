package spring.kontroler;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.db.KlientService;
import spring.db.KursService;
import spring.model.Klient;
import spring.model.Kurs;
import spring.model.Pomocnik;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class KlientKontroler {

    @Autowired
    private KlientService klientService;
    @Autowired
    private KursService kursService;
    Pomocnik pomocnik;

    @RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
    public String rejestracja(Model model) {
        if(!model.containsAttribute("klient"))
            model.addAttribute("klient", new Klient());
        model.addAttribute("pomocnik", pomocnik);
        return "rejestracja";
    }

    //For add and update Klient both
    @RequestMapping(value = "/rejestracja/go", method = RequestMethod.POST)
    public String zarejestruj(@Valid @ModelAttribute("klient") Klient klient, BindingResult bindingResult, HttpServletRequest request,
            HttpServletResponse response, RedirectAttributes attr) {
        if (bindingResult.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.klient", bindingResult);
            attr.addFlashAttribute("klient", klient);
        } else {
            request.setAttribute("regSuccess", "Rejstracja przebiegła pomyślnie");
            klientService.createKlient(klient);
            return "redirect:/login/";
        }

        return "redirect:/rejestracja";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        pomocnik = new Pomocnik();
        if (Logowanie.zalogowany != null) {
            pomocnik.setZalogowany(true);
        }
        else
            pomocnik.setZalogowany(false);
        model.addAttribute("pomocnik", pomocnik);
        return "index";
    }

    @RequestMapping(value = "/konto", method = RequestMethod.GET)
    public String konto(Model model) {
        List<Kurs> kursy = null;
        if (Logowanie.zalogowany != null) {
            kursy = Logowanie.zalogowany.getKursy();
            kursy.sort(new KursComparator());
            model.addAttribute("koszt", kursy.size()*17 + " zł");
            model.addAttribute("kursy", kursy);
        }
        model.addAttribute("pomocnik", pomocnik);
        
        return "konto";
    }

    @RequestMapping("/konto/usun/{id}")
    public String rezerwacja(@PathVariable("id") long id, Model model) {
        if (Logowanie.zalogowany != null) {
            Logowanie.zalogowany.getKursy().remove(kursService.findKursById(id));
            klientService.updateKlient(Logowanie.zalogowany);
        }
        return "redirect:/konto";
    }

    @RequestMapping("/konto/usunkonto")
    public String usunKonto() {
        if (Logowanie.zalogowany != null) {
            this.klientService.deleteKlient(Logowanie.zalogowany);
            Logowanie.zalogowany = null;
            System.out.println("Delete succesful: " + Logowanie.zalogowany);
        }
        return "redirect:/";
    }

}
