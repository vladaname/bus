package com.example.bus.service;

import com.example.bus.DTO.RedVoznjeDTO;
import com.example.bus.model.RedVoznje;

import java.util.List;

public interface RedVoznjeService {
    boolean createRedVoznje(RedVoznjeDTO redVoznjeDTO);

    List<RedVoznje> getSveVoznje();
}
