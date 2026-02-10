package com.example.demo.Repository;

import com.example.demo.Model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryItemRepository implements IMemoryRepository {

    private final Map<Long, Item> storage = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public List<Item> getStorageValues() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public boolean setStorageValues(Item item) {
        var id =seq.getAndIncrement();
        item.setId(id);
        storage.put(id, item);
        return true;
    }
}
