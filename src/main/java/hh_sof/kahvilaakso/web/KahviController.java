package hh_sof.kahvilaakso.web;

import hh_sof.kahvilaakso.domain.Kahvi;
import hh_sof.kahvilaakso.domain.KahviRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;


@Controller
public class KahviController {

    @Autowired
    private KahviRepository kahviRepository;

    @RequestMapping(value = "/kaikkikahvit", method = RequestMethod.GET)
    public String kaikkiKahvit(Model model) {
        model.addAttribute("kahvit", kahviRepository.findAll());
        return "kaikkikahvit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String lisaaKahvi(Model model) {
        model.addAttribute("kahvi", new Kahvi());
        return "lisaaKahvi";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveKahvi(Kahvi kahvi) {
        kahviRepository.save(kahvi);
        return "redirect:/kaikkikahvit";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public String cancelSave() {
        return "redirect:/kaikkikahvit";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteKahvi(@PathVariable("id") Long kahviId, Model model) {
		kahviRepository.deleteById(kahviId);
		return "redirect:../kaikkikahvit";
	}
	
	@RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editKahvi(@PathVariable("id") Long kahviId, Model model) {
        Kahvi kahvi = kahviRepository.findById(kahviId).get();
        model.addAttribute("kahvi", kahvi);

        return "editKahvi";
    }


	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}