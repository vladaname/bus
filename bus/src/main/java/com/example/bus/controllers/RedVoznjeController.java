package com.example.bus.controllers;

import com.example.bus.DTO.RedVoznjeDTO;
import com.example.bus.model.RedVoznje;
import com.example.bus.service.RedVoznjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RedVoznjeController {
    @Autowired
    RedVoznjeService redVoznjeService;

    @GetMapping("/createRedVoznje")
    public ModelAndView createREdVoznjeGET(){
        return new ModelAndView("createRedVoznje", "redVoznjeDTO", new RedVoznjeDTO());
    }

    @PostMapping("/createRedVoznje")
    public String createRedVoznjePOST(Model model, @ModelAttribute("redVoznjeDTO")RedVoznjeDTO redVoznjeDTO, HttpServletRequest request){
       // Osoba o = (Osoba) request.getSession().getAttribute("admin");
        System.out.println(redVoznjeDTO.getVremePolaska());
        boolean b = redVoznjeService.createRedVoznje(redVoznjeDTO);
        if(b){
            return "listaRedVoznje";
        }
        else{
            model.addAttribute("poruka", "Greska");
            return "createRedVoznje";
        }
    }
    @GetMapping("/listRedVoznje")
    public String listaRedVoznje(Model model){
        List<RedVoznje> listRedVoznje = redVoznjeService.getSveVoznje();
        if(listRedVoznje != null){
            return "listaRedVoznje";
        }
        else{
            model.addAttribute("poruka", "Lista je prazna");
            return "listaRedVoznje";
        }

    }
}
