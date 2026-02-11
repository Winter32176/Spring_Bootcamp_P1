package com.example.demo.Repository;

import com.example.demo.Model.Car;

import java.util.List;

public interface IMemoryRepository {
    List<Car> getStorageValues();

    boolean setStorageValues(Car car);
}
