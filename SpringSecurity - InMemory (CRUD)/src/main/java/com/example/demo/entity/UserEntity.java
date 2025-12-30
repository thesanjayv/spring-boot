package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer salary;
    private String name;
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UserEntity(Integer salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public UserEntity() {}
    
}
