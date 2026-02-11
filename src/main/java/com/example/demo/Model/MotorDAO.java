package com.example.demo.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "Engines")
public class MotorDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String type;
}
