package com.example.bus.service;

import com.example.bus.DTO.AutobusDTO;
import com.example.bus.model.Autobus;

import java.util.List;

public interface AutobusService {
    boolean createAutobus(AutobusDTO autobusDTO);

    List<Autobus> listaAutobus();
}
