package com.example.demo.Service;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarCategory;
import com.example.demo.Model.CarDAO;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Util.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final CarRepository repo;

    public ItemService(CarRepository repo) {
        this.repo = repo;
    }

    public boolean setStorageValues(String name, String color, String details, String model, CarCategory category, String add) {
        CarDAO saved = repo.save(ObjectMapper.toEntity(new Car(name, color, details, model, category, add)));
        return saved != null;
    }

    public List<Car> getStorageValues() {
        return repo.findAll().stream().map(ObjectMapper::toModel).toList();
    }

    public Car getById(long id) {
        return repo.findById(id).map(ObjectMapper::toModel).orElse(null);
    }

    public List<Car> findAllByName(String name) {
        return repo.findByNameContainingIgnoreCase(name)
                .stream()
                .map(ObjectMapper::toModel)
                .toList();
    }

    @Transactional
    public boolean editStorageValues(Car car) {
        if (car.getId() <= 0) return false;

        CarDAO entity = repo.findById(car.getId()).orElse(null);
        if (entity == null) return false;

        entity.setName(car.getName());
        entity.setColor(car.getColor());
        entity.setDetails(car.getDetails());
        entity.setModel(car.getModel());
        entity.setCategory(car.getCategory());

        // update additional + engine safely
        ObjectMapper.applyAdditional(entity, car.getAdditionalInfo());

        return true; // entity will be flushed by @Transactional
    }
}
