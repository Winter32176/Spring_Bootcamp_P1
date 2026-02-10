package com.example.demo.items;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateItemForm {

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be 50 characters or less")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
