package com.example.bus.repository;

import com.example.bus.model.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OsobaRepository extends JpaRepository<Osoba, Integer> {

    Osoba findByUsername(String username);
}
