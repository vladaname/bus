package com.example.bus.controllers;

import com.example.bus.DTO.VoznjaDTO;
import com.example.bus.model.Voznja;
import com.example.bus.service.VoznjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("voznjaRest")

public class VoznjaControllerRest {
    @Autowired
    VoznjaService voznjaService;

    @GetMapping("/voznjaList")
    public List<Voznja> voznjaList(){
        return voznjaService.listVoznja();
    }

    @PostMapping("/createVoznja")
    public String createVoznja(@RequestBody VoznjaDTO voznjaDTO){
        boolean b = voznjaService.createVoznjaRest(voznjaDTO);
        if(b) {
            return "Uspesno kreiranje voznje";
        }
        else{
            return "Greska";
        }
    }
}
