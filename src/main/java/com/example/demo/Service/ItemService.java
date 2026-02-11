package com.example.demo.Service;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarCategory;
import com.example.demo.Repository.IMemoryRepository;
import com.example.demo.Util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    IMemoryRepository memory;

    public ItemService(IMemoryRepository mem) {
        this.memory = mem;
    }

    public boolean saveObject(String name, String color, String details, String model, CarCategory category, String add) {

        return memory.setStorageValues(ObjectMapper.getCarDao(new Car(name, color, details, model, category, add), add));
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
        return ObjectMapper.getCar(memory.getStorageValues().stream().filter(x -> x.getId() == id).findFirst().orElse(null));

    }


}
