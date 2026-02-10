package com.example.demo.Repository;

import com.example.demo.Model.Item;

import java.util.List;

public interface IMemoryRepository {
    List<Item> getStorageValues();

    boolean setStorageValues(Item item);
}
