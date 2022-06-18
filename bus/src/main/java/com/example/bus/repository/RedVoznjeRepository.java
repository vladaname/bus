package com.example.bus.repository;

import com.example.bus.model.RedVoznje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RedVoznjeRepository extends JpaRepository<RedVoznje, Integer> {
}
