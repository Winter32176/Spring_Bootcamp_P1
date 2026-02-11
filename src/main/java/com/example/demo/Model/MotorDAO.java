package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Engines")
public class MotorDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String type;

    public MotorDAO(String type) {
        this.type = type;
    }

    public MotorDAO(long id, String type) {
        this.type = type;
        this.id = id;
    }

    public MotorDAO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
