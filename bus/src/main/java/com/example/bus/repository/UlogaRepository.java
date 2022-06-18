package com.example.bus.repository;

import com.example.bus.model.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UlogaRepository extends JpaRepository<Uloga, Integer> {

}
