package com.example.bus.impl;

import com.example.bus.DTO.OsobaDTO;
import com.example.bus.model.Osoba;
import com.example.bus.model.Uloga;
import com.example.bus.repository.OsobaRepository;
import com.example.bus.repository.UlogaRepository;
import com.example.bus.service.OsobaService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OsobaServiceImpl implements OsobaService {
    @Autowired
    UlogaRepository ulogaRepository;

    @Autowired
    OsobaRepository osobaRepository;


    @Override
    public boolean registration(OsobaDTO osobaDTO) {

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        Osoba o = new Osoba();
        o.setEmail(osobaDTO.getEmail());
        o.setIme(osobaDTO.getIme());
        o.setPrezime(osobaDTO.getPrezime());
        o.setUsername(osobaDTO.getUsername());
        o.setPass(passwordEncryptor.encryptPassword(osobaDTO.getPass()));

        Optional<Uloga> getUloga = ulogaRepository.findById(1);
        if(getUloga.isPresent()){
            Uloga g = getUloga.get();
            o.setUloga(g);
        }
        else {
            return false;
        }
        osobaRepository.saveAndFlush(o);
        return true;
    }

    @Override
    public Osoba login(OsobaDTO osobaDTO) {
        try {
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

            Osoba o = osobaRepository.findByUsername(osobaDTO.getUsername());
            String encryptedPass = o.getPass();
            if (osobaDTO.getPass().equals(o.getPass()) || passwordEncryptor.checkPassword(osobaDTO.getPass(), encryptedPass)){
                return o;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
