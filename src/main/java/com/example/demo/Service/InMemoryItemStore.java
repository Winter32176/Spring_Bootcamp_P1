package com.example.demo.Service;

import com.example.demo.Model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryItemStore {

    private final Map<Long, Item> storage = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Item> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Item save(String name) {
        long id = seq.getAndIncrement();
        Item item = new Item(id, name);
        storage.put(id, item);
        return item;
    }
}
