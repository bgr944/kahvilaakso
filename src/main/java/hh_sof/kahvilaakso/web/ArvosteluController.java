package hh_sof.kahvilaakso.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;

import hh_sof.kahvilaakso.domain.Arvostelu;
import hh_sof.kahvilaakso.domain.ArvosteluRepository;
import hh_sof.kahvilaakso.domain.KahviRepository;
import hh_sof.kahvilaakso.domain.Kahvi;
import hh_sof.kahvilaakso.domain.UserRepository;
import hh_sof.kahvilaakso.domain.User;

@Controller
public class ArvosteluController {

    @Autowired
    private ArvosteluRepository arvosteluRepository;
    @Autowired
    private KahviRepository kahviRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/saveArvostelu", method = RequestMethod.POST)
    public String saveArvostelu(Arvostelu arvostelu, @RequestParam("kahviId") Long kahviId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        
        Kahvi kahvi = kahviRepository.findById(kahviId).get();
        
        arvostelu.setUser(user);
        arvostelu.setKahvi(kahvi);
        
        arvosteluRepository.save(arvostelu);
        return "redirect:/kaikkikahvit";
    }

    @RequestMapping(value = "/arvostele/{id}", method=RequestMethod.GET)
    public String arvosteleKahvi(@PathVariable("id") Long kahviId, Model model) {
        Kahvi kahvi = kahviRepository.findById(kahviId).get();
        Arvostelu arvostelu = new Arvostelu();
        arvostelu.setKahvi(kahvi);
        model.addAttribute("kahvi", kahvi);
        model.addAttribute("arvostelu", arvostelu);
    
        return "arvosteleKahvi";
    }

    @RequestMapping("/arvostelut/{id}")
    public String getArvostelutForKahvi(@PathVariable("id") Long kahviId, Model model) {
        Kahvi kahvi = kahviRepository.findByKahviId(kahviId);
        List<Arvostelu> arvostelut = arvosteluRepository.findKahviByKahviId(kahviId);
        model.addAttribute("kahvi", kahvi);
        model.addAttribute("arvostelut", arvostelut);
        return "arvostelut";
    }
}