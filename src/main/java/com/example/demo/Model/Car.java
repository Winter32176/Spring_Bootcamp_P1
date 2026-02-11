package com.example.demo.Model;

public class Car {

    private long id;
    private String name;
    private String color;
    private String details;
    private String model;
    CarCategory category;


    public Car(long id, String name, String color, String details, String model, CarCategory c) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.details = details;
        this.model = model;
        this.category = c;
    }

    public Car(String name, String color, String details, String model, CarCategory category) {
        this.name = name;
        this.color = color;
        this.details = details;
        this.model = model;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public CarCategory getCategory() {
        return category;
    }

    public void setCategory(CarCategory c) {
        this.category = c;
    }
}
