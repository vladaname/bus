package com.example.bus.controllers;

import com.example.bus.DTO.OsobaDTO;
import com.example.bus.model.Osoba;
import com.example.bus.service.OsobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OsobaController {
    @Autowired
    OsobaService osobaService;

    @GetMapping("/registration")
    public ModelAndView registrationGET(){
        return new ModelAndView("registration", "osobaDTO", new OsobaDTO());
    }

    @PostMapping("/registration")
    public String registrationPOST(Model model, @ModelAttribute("osobaDTO")OsobaDTO osobaDTO, HttpServletRequest request) {
        boolean b = osobaService.registration(osobaDTO);
        if (b) {
            model.addAttribute("poruka", "Uspesna registracija");
            return "login";
        } else {
            model.addAttribute("poruka", "Greska");
            return "registration";
        }
    }
        @GetMapping("/login")
        public ModelAndView loginGET(){
            return new ModelAndView("login", "osobaDTO", new OsobaDTO());

        }
        @PostMapping("/login")
    public String loginPOST(Model model, @ModelAttribute("osobaDTO")OsobaDTO osobaDTO, HttpServletRequest request){
        Osoba login = osobaService.login(osobaDTO);
        if(login == null){
            model.addAttribute("poruka", "Greska");
            return "login";
        }
        else{
            request.getSession().setAttribute("korisnik", login);
            return "listaPolazaka";
        }

        }

    }


