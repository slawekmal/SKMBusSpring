package spring.kontroler;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.db.KlientService;
import spring.model.Klient;

@Controller
@RequestMapping(value = "/login", method = RequestMethod.GET)
public class Logowanie {
    
    @Autowired
    private KlientService klientService;
    
    public static Klient zalogowany;
    
   @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("logowanie");
        Klient klient = new Klient();
        model.addObject("klient", klient);
        return model;
    }

    @RequestMapping(value = "/go", method = RequestMethod.POST)
    public String zaloguj(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("klient") Klient klient) throws SQLException {
        ModelAndView model = null;
        try {
            this.zalogowany = klientService.isValidUser(klient.getEmail(), klient.getHaslo());
            if (this.zalogowany != null) {
                System.out.println("User Login Successful: " + this.zalogowany);
                request.setAttribute("loggedInUser", this.zalogowany);
                model = new ModelAndView("index");
            } else {
                model = new ModelAndView("logowanie");
                model.addObject("klient", klient);
                request.setAttribute("message", "Błędne dane");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
    
    public boolean jestZalogowany(){
        return zalogowany != null;
    }
    
    @RequestMapping(value = "/wyloguj", method = RequestMethod.GET)
    public String wyloguj(){
        zalogowany = null;
        System.out.println("User LogOut Successful: " + this.zalogowany);
        return "redirect:/";
    }

}
