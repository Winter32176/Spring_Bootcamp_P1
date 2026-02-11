package com.example.demo.Repository;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryItemRepository implements IMemoryRepository {

    private final Map<Long, Car> storage = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public List<CarDAO> getStorageValues() {
        return new ArrayList<>();
    }

    @Override
    public boolean setStorageValues(CarDAO car) {

        return true;
    }

    @Override
    public boolean editStorageValues(CarDAO car) {
        return false;
    }
}
