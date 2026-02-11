package com.example.demo.Service;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarCategory;
import com.example.demo.Model.CarDAO;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Repository.IMemoryRepository;
import com.example.demo.Util.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ItemService {
    @Autowired
    private final CarRepository repo;

    public ItemService(CarRepository repo) {
        this.repo = repo;
    }

    public boolean setStorageValues(String name, String color, String details, String model, CarCategory category, String add) {

        return repo.save(ObjectMapper.getCarDao(new Car(name, color, details, model, category, add))) != null;
    }

    @Transactional
    public boolean editStorageValues(Car car) {
        Long id = car.getId();

        if (id == 0 || !repo.existsById(id)) {
            return false;
        }

        CarDAO entity = ObjectMapper.getCarDao(
                new Car(car.getName(), car.getColor(), car.getDetails(),
                        car.getModel(), car.getCategory(), car.getAdditionalInfo())
        );

        entity.setId(id);

        repo.save(entity);
        return true;
    }

    public List<Car> getStorageValues() {
        var dao = repo.findAll();
        List<Car> cars = new ArrayList<>();
        for (var d : dao) {
            cars.add(ObjectMapper.getCar(d));
        }
        return cars;
    }

    public Car getById(long id) {
        return ObjectMapper.getCar(Objects.requireNonNull(repo.findAll().stream().filter(x -> x.getId() == id).findFirst().orElse(null)));

    }

    public boolean deleteById(long id) {
        repo.deleteById(id);
        return true;
    }

    public Car findAllByName(String name) {
        return null;
    }

}
