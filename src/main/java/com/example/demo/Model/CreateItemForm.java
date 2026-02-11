package com.example.demo.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateItemForm {

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be 50 characters or less")
    private String name;

    @NotBlank(message = "model is required")
    @Size(max = 50, message = "model must be 50 characters or less")
    private String model;

    @NotBlank(message = "color is required")
    @Size(max = 50, message = "color must be 50 characters or less")
    private String color;

    @NotBlank(message = "details is required")
    @Size(max = 50, message = "details must be 50 characters or less")
    private String details;

    @NotNull(message = "category is required")
    private CarCategory category;

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCategory(CarCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getDetails() {
        return details;
    }

    public CarCategory getCategory() {
        return category;
    }
}
