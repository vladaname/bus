package com.example.bus.service;

import com.example.bus.DTO.OsobaDTO;
import com.example.bus.model.Osoba;

public interface OsobaService  {
    boolean registration(OsobaDTO osobaDTO);

    Osoba login(OsobaDTO osobaDTO);
}
