package com.example.demo.Repository;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarDAO;

import java.util.List;

public interface IMemoryRepository {
    List<CarDAO> getStorageValues();

    boolean setStorageValues(CarDAO car);

    boolean editStorageValues(CarDAO car);
}
