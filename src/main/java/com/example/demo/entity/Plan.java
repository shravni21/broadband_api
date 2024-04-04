package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;

import com.example.demo.entity.Broadband;

@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    private BigDecimal amount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "broadband_id") // Name of the column in the Plan table that references Broadband
    private Broadband broadband;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", amount=" + amount +
                '}';
    }

    public Broadband getBroadband() {
        return broadband;
    }

    public void setBroadband(Broadband broadband) {
        this.broadband = broadband;
    }
}