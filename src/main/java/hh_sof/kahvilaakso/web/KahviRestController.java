package hh_sof.kahvilaakso.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh_sof.kahvilaakso.domain.KahviRepository;
import hh_sof.kahvilaakso.domain.Kahvi;



@CrossOrigin
@Controller
public class KahviRestController {

    @Autowired
    private KahviRepository kahviRepository;

    @RequestMapping(value = "/kahvit", method = RequestMethod.GET)
    public @ResponseBody List<Kahvi> getKahvit() {
        return (List<Kahvi>) kahviRepository.findAll();
    }

    @RequestMapping(value = "/kahvit/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Kahvi> getYksiKahviById(@PathVariable("id") Long kahviId) {
        return kahviRepository.findById(kahviId);
    }

    }

