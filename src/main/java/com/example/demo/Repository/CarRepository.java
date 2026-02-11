package com.example.demo.Repository;

import com.example.demo.Model.CarDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarDAO, Long> {
}
