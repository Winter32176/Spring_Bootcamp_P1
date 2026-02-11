package com.example.demo.Repository;

import com.example.demo.Model.Car;
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
    public List<Car> getStorageValues() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public boolean setStorageValues(Car car) {
        var id =seq.getAndIncrement();
        car.setId(id);
        storage.put(id, car);
        return true;
    }
}
