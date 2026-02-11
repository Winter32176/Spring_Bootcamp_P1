package com.example.demo.Service;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarCategory;
import com.example.demo.Model.CarDAO;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Repository.IMemoryRepository;
import com.example.demo.Util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ItemService {
    @Autowired
    //IMemoryRepository memory;
    // public ItemService(IMemoryRepository mem) {
    //        this.memory = mem;
    //    }

    private final CarRepository repo;
    public ItemService(CarRepository repo) {
        this.repo = repo;
    }

    public List<CarDAO> getStorageValues() {
        return repo.findAll();
    }

    public CarDAO setStorageValues(CarDAO car) {
        return repo.save(car);
    }

    public CarDAO editStorageValues(CarDAO car) {
        return repo.save(car);
    }

/*
    public boolean saveObject(String name, String color, String details, String model, CarCategory category, String add) {

        return memory.setStorageValues(ObjectMapper.getCarDao(new Car(name, color, details, model, category, add)));
    }

    public boolean updateObject(Car car) {
        return true;
    }

    public List<Car> findAll() {
        var dao = memory.getStorageValues();
        List<Car> cars = new ArrayList<>();
        for (var d : dao) {
            cars.add(ObjectMapper.getCar(d));
        }
        return cars;
    }

    public Car getById(long id) {
        return ObjectMapper.getCar(Objects.requireNonNull(memory.getStorageValues().stream().filter(x -> x.getId() == id).findFirst().orElse(null)));

    }
*/

}
