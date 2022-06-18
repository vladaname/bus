package com.example.bus.impl;

import com.example.bus.DTO.VoznjaDTO;
import com.example.bus.model.Autobus;
import com.example.bus.model.Osoba;
import com.example.bus.model.RedVoznje;
import com.example.bus.model.Voznja;
import com.example.bus.repository.AutobusRepository;
import com.example.bus.repository.OsobaRepository;
import com.example.bus.repository.RedVoznjeRepository;
import com.example.bus.repository.VoznjaRepository;
import com.example.bus.service.VoznjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VoznjaServiceImpl implements VoznjaService {
    @Autowired
    VoznjaRepository voznjaRepository;
    @Autowired
    AutobusRepository autobusRepository;
    @Autowired
    RedVoznjeRepository redVoznjeRepository;
    @Autowired
    OsobaRepository osobaRepository;


    @Override
    public boolean createVoznja(VoznjaDTO voznjaDTO, int idOsoba) {

        Voznja v = new Voznja();

        Optional<RedVoznje> rv = redVoznjeRepository.findById(voznjaDTO.getIdRedVoznje());
        Optional<Autobus> a = autobusRepository.findById(voznjaDTO.getIdAutobus());
        Optional<Osoba> o = osobaRepository.findById(idOsoba);

        if(rv.isPresent() && a.isPresent() && o.isPresent()){
            RedVoznje redVoznje= rv.get();
            Autobus autobus = a.get();
            Osoba osoba = o.get();
            v.setRedVoznje(redVoznje);
            v.setAutobus(autobus);
            v.setOsoba(osoba);

            voznjaRepository.saveAndFlush(v);
            return true;

        }
        return false;
    }

    @Override
    public List<Voznja> listVoznja() {
        List<Voznja> voznjaList = voznjaRepository.findAll();
        return voznjaList;
    }

    @Override
    public boolean createVoznjaRest(VoznjaDTO voznjaDTO) {
        Voznja v = new Voznja();

        Optional<RedVoznje> rv = redVoznjeRepository.findById(voznjaDTO.getIdRedVoznje());
        Optional<Autobus> a = autobusRepository.findById(voznjaDTO.getIdAutobus());

        if(rv.isPresent() && a.isPresent()){
            RedVoznje redVoznje= rv.get();
            Autobus autobus = a.get();
            v.setRedVoznje(redVoznje);
            v.setAutobus(autobus);

            voznjaRepository.saveAndFlush(v);
            return true;

        }
        return false;
    }

}
