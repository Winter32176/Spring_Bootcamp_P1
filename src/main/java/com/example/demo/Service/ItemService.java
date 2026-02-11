package com.example.demo.Service;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarCategory;
import com.example.demo.Repository.IMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    IMemoryRepository memory;

    public ItemService(IMemoryRepository mem) {
        this.memory = mem;
    }

    public boolean saveObject(String name, String color, String details, String model, CarCategory category) {
        return memory.setStorageValues(new Car(name, color, details, model, category));
    }

    public boolean updateObject(Car car) {
        return true;
    }

    public List<Car> findAll() {
        return memory.getStorageValues();
    }

    public Car getById(long id) {
        return memory.getStorageValues().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }


}
