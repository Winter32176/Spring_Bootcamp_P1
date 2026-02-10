package com.example.demo.Service;

import com.example.demo.Model.Item;
import com.example.demo.Repository.IMemoryRepository;
import com.example.demo.Repository.InMemoryItemRepository;
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

    public boolean save(String name) {
        return memory.setStorageValues(new Item(-1, name));
    }

    public List<Item> findAll() {
        return memory.getStorageValues();
    }
}
