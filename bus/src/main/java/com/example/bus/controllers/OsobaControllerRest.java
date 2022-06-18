package com.example.bus.controllers;

import com.example.bus.DTO.OsobaDTO;
import com.example.bus.service.OsobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registracijaRest")
public class OsobaControllerRest {

    @Autowired
    OsobaService osobaService;

    @PostMapping("/registrujOsobu")
    public String registrujOsobu(@RequestBody OsobaDTO osobaDTO){
        boolean b = osobaService.registration(osobaDTO);

        if(b){
            return "Uspesno ste se registrovali";
        }
        else{
            return "Greska pri registraciji";
        }
    }
}
