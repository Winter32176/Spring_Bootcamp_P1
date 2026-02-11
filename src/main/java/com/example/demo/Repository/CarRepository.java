package com.example.demo.Repository;

import com.example.demo.Model.CarDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarDAO, Long> {
    List<CarDAO> findByNameContainingIgnoreCase(String name);
}
