package spring.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.db.KlientService;
import spring.model.Klient;

@Controller
@RequestMapping(value = "/klient", method = RequestMethod.GET)
public class KlientKontroler {
    
    @Autowired
    private KlientService klientService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rejestracja(Model model) {
        model.addAttribute("klient", new Klient());
        return "rejestracja";
    }

    //For add and update Klient both
    @RequestMapping(value = "/zarejestruj", method = RequestMethod.POST)
    public String zarejestruj(@ModelAttribute("klient") Klient k) {

        klientService.createKlient(k);

        return "redirect:/klient/";

    }

}
