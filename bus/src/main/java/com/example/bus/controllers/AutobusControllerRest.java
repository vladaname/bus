package com.example.bus.controllers;

import com.example.bus.model.Autobus;
import com.example.bus.service.AutobusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("autobusRest")
public class AutobusControllerRest {

    @Autowired
    AutobusService autobusService;

    @GetMapping("/getAutobus")
    public List<Autobus> getAutobus(){
        return autobusService.listaAutobus();
    }
}
