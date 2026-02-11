package com.example.demo.Model;

import jakarta.persistence.*;
import org.apache.catalina.Engine;

@Entity
@Table(name = "Cars")
public class CarDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String color;
    private String details;
    private String model;
    private CarCategory category;
    private String additionalInfo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "engine_id", unique = true)
    private MotorDAO engine;

    public CarDAO() {
    }

    public CarDAO(long id, String name, String color, String details, String model, CarCategory category, String additionalInfo, MotorDAO engine) {
        this.id=id;
        this.name = name;
        this.color = color;
        this.details = details;
        this.model = model;
        this.category = category;
        this.additionalInfo = additionalInfo;
        this.engine = engine;
    }

    public CarDAO(String name, String color, String details, String model, CarCategory category, String additionalInfo, MotorDAO engine) {
        this.name = name;
        this.color = color;
        this.details = details;
        this.model = model;
        this.category = category;
        this.additionalInfo = additionalInfo;
        this.engine = engine;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public MotorDAO getEngine() {
        return engine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(MotorDAO engine) {
        this.engine = engine;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CarCategory getCategory() {
        return category;
    }

    public void setCategory(CarCategory category) {
        this.category = category;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}