package com.example.bus.impl;

import com.example.bus.DTO.AutobusDTO;
import com.example.bus.model.Autobus;
import com.example.bus.repository.AutobusRepository;
import com.example.bus.service.AutobusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutobusServiceImpl implements AutobusService {

    @Autowired
    AutobusRepository autobusRepository;

    @Override
    public boolean createAutobus(AutobusDTO autobusDTO) {

        Autobus a = new Autobus();
        a.setNaziv(autobusDTO.getNaziv());
        a.setBrojSedista(Integer.parseInt(autobusDTO.getBrojSedista()));
        autobusRepository.saveAndFlush(a);
        return true;
    }

    @Override
    public List<Autobus> listaAutobus() {
        List<Autobus> listaAutobus = autobusRepository.findAll();
        return listaAutobus;
    }
}
