package com.example.bus.impl;

import com.example.bus.DTO.RedVoznjeDTO;
import com.example.bus.model.RedVoznje;
import com.example.bus.repository.RedVoznjeRepository;
import com.example.bus.service.RedVoznjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RedVoznjeServiceImpl implements RedVoznjeService {

    @Autowired
    RedVoznjeRepository redVoznjeRepository;

    @Override
    public boolean createRedVoznje(RedVoznjeDTO redVoznjeDTO) {
        RedVoznje rv = new RedVoznje();
        rv.setCilj(redVoznjeDTO.getCilj());
        rv.setStart(redVoznjeDTO.getStart());
        rv.setDistanca(Integer.parseInt(redVoznjeDTO.getDistanca()));
        rv.setUkupnaCena(Integer.parseInt(redVoznjeDTO.getUkupnaCena()));
        rv.setDistanca(Integer.parseInt(redVoznjeDTO.getDistanca()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        try {
            rv.setVremePolaska(sdf.parse(redVoznjeDTO.getVremePolaska()));
            rv.setVremeDolaska(sdf.parse(redVoznjeDTO.getVremeDolaska()));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        redVoznjeRepository.saveAndFlush(rv);
        return true;
    }

    @Override
    public List<RedVoznje> getSveVoznje() {
        List<RedVoznje> listaRedVoznje = redVoznjeRepository.findAll();
        return listaRedVoznje;
    }
}
