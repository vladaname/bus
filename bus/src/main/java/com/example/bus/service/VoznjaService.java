package com.example.bus.service;

import com.example.bus.DTO.VoznjaDTO;
import com.example.bus.model.Voznja;

import java.util.List;

public interface VoznjaService {

    boolean createVoznja(VoznjaDTO voznjaDTO, int idOsoba);

    List<Voznja> listVoznja();

    boolean createVoznjaRest(VoznjaDTO voznjaDTO);
}
