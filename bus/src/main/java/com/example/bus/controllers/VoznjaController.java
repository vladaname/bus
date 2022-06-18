package com.example.bus.controllers;

import com.example.bus.DTO.VoznjaDTO;
import com.example.bus.model.Autobus;
import com.example.bus.model.Osoba;
import com.example.bus.model.RedVoznje;
import com.example.bus.service.AutobusService;
import com.example.bus.service.RedVoznjeService;
import com.example.bus.service.VoznjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class VoznjaController {
    @Autowired
    VoznjaService voznjaService;
    @Autowired
    AutobusService autobusService;
    @Autowired
    RedVoznjeService redVoznjeService;


    @GetMapping("/createVoznja")
    public String createVoznjaGET(Model model){
        List<Autobus> listaAutobusa = autobusService.listaAutobus();
        List<RedVoznje> listaRedViznje = redVoznjeService.getSveVoznje();

        model.addAttribute("listaAutobusa", listaAutobusa);
        model.addAttribute("listaRedVoznje", listaRedViznje);
        model.addAttribute("voznjaDTO", new VoznjaDTO());
        return "createVoznja";
    }

    @PostMapping("/createVoznja")
    public String createVoznjaPOST(Model model, @PathVariable("voanjDTO")VoznjaDTO voznjaDTO, HttpServletRequest request){
        Osoba o = (Osoba) request.getSession().getAttribute("korisnik");
        boolean b = voznjaService.createVoznja(voznjaDTO, o.getIdOsoba());
        if(b){
            model.addAttribute("poruka", "Uspesno");
            return "redirect:/createVoznja";
        }
        else{
            model.addAttribute("poruka", "Desila se greska.");
            return "redirect:/createVoznja";
        }

    }


}
