package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int addressId;
    private String city;
    private String country;
    public Address(){}
    public Address(String city, String country) {
        this.city = city;
        this.country = country;
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
}
