package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    private String contactNumber;


//    @ManyToOne
//    @JoinColumn(name = "broadband_id")
//    private Broadband broadbandConnection;
    @OneToOne
    @JoinTable(
            name = "customer_broadband",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "broadband_id")
    )
    private Broadband broadband;

    public Customer() {
    }

    public Customer(String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
//    public Broadband getBroadbandConnection(){
//        return broadbandConnection;
//    }
//
//    public void setBroadbandConnection(Broadband broadbandConnection) {
//        this.broadbandConnection = broadbandConnection;
//    }

    public Broadband getBroadband() {
        return broadband;
    }

    public void setBroadband(Broadband broadband) {
        this.broadband = broadband;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

}