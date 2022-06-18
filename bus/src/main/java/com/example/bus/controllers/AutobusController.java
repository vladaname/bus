package com.example.bus.controllers;

import com.example.bus.DTO.AutobusDTO;
import com.example.bus.model.Autobus;
import com.example.bus.service.AutobusService;
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
public class AutobusController {

    @Autowired
    AutobusService autobusService;

    @GetMapping("/createAutobus")
    public ModelAndView createAutobus(){
        return new ModelAndView("createAutobus", "autobusDTO", new AutobusDTO());
    }

    @PostMapping("/createAutobus")
    public String createAutobusPOST(Model model, @ModelAttribute("autobusDTO")AutobusDTO autobusDTO, HttpServletRequest request){
     //   Osoba o = (Osoba) request.getSession().getAttribute("admin");

        boolean b = autobusService.createAutobus(autobusDTO);
        if(b){

            return "listaAutobusa";
        }
        else{
            model.addAttribute("poruka", "Greska");
            return "createAutobus";
        }

    }
    @GetMapping("/listAutobus")
    public String listaAutobus(Model model){
        List<Autobus> listAutobus = autobusService.listaAutobus();
        if(listAutobus != null) {
            return "listaAutobus";
        }
        else{
            model.addAttribute("poruka", "NEma podataka");
            return "listaAutobus";
        }
    }

}
