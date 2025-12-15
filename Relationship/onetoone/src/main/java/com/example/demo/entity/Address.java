package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int addressId;
    private String city;
    private String country;

    @OneToOne(mappedBy="address", cascade=CascadeType.PERSIST)
    private Student student;
    public Address(){}
    public Address(String city, String country, Student student) {
        this.city = city;
        this.country = country;
        this.student = student;
    }

    
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "Address [addressId=" + addressId + ", city=" + city + ", country=" + country + "]";
    }
    public int getAddressId() {
        return addressId;
    }
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
}
