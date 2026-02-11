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
    private String model;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "engine_id", unique = true)
    private Engine engine;

    public CarDAO() {
    }

    public CarDAO(String name, String model, Engine engine) {
        this.name = name;
        this.model = model;
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

    public Engine getEngine() {
        return engine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}