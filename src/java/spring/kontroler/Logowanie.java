package spring.kontroler;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.db.KlientService;
import spring.model.Klient;

@Controller
@RequestMapping(value = "/login", method = RequestMethod.GET)
public class Logowanie {
    
    @Autowired
    private KlientService klientService;
    
    public static Klient zalogowany;
    
   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginForm(Model model) {
        if(!model.containsAttribute("klient"))
            model.addAttribute("klient", new Klient());       
        return "logowanie";
    }

    @RequestMapping(value = "/go", method = RequestMethod.POST)
    public String zaloguj(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("klient") Klient klient) throws SQLException {
        try {
            Logowanie.zalogowany = klientService.isValidUser(klient.getEmail(), klient.getHaslo());
            if (Logowanie.zalogowany != null) {
                System.out.println("User Login Successful: " + Logowanie.zalogowany);
                request.setAttribute("loggedInUser", Logowanie.zalogowany);
            } else {
                request.setAttribute("message", "Błędne dane. Upewnij się czy podałeś poprawny email i hasło");
                return "logowanie";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
    
    @RequestMapping(value = "/wyloguj", method = RequestMethod.GET)
    public String wyloguj(){
        zalogowany = null;
        System.out.println("User LogOut Successful: " + this.zalogowany);
        return "redirect:/";
    }

}
