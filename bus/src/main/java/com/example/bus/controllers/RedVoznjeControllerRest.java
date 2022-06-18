package com.example.bus.controllers;

import com.example.bus.DTO.RedVoznjeDTO;
import com.example.bus.model.RedVoznje;
import com.example.bus.service.RedVoznjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("redVoznjeRest")
public class RedVoznjeControllerRest {

    @Autowired
    RedVoznjeService redVoznjeService;

    @GetMapping("/getRedVoznje")
    public List<RedVoznje> getListRedVoznje(){
        return redVoznjeService.getSveVoznje();
    }

    @PostMapping("/createRedVoznjeRest")
    public String createRedVoznje(@RequestBody RedVoznjeDTO redVoznjeDTO){
        boolean b = redVoznjeService.createRedVoznje(redVoznjeDTO);
        if(b){
            return "Red voznje je kreiran";
        }
        else{
            return "Greska.";
        }
    }
}
