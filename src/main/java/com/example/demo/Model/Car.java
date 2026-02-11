package com.example.demo.Model;

public class Car {

    private long id;
    private String name;
    private String color;
    private String details;
    private String model;
    private CarCategory category;
    private String additionalInfo;


    public Car(long id, String name, String color, String details, String model, CarCategory c, String additionalInfo) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.details = details;
        this.model = model;
        this.category = c;
        this.additionalInfo = additionalInfo;
    }

    public Car(String name, String color, String details, String model, CarCategory category, String additionalInfo) {
        this.name = name;
        this.color = color;
        this.details = details;
        this.model = model;
        this.category = category;
        this.additionalInfo = additionalInfo;
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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
