package com.example.demo.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Student{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int student_id;
    private String name;
    private String salary;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id1")
    private Address address;

    public Student(){}
    
    public Student(String name, String salary, Address address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student [student_id=" + student_id + ", name=" + name + ", salary=" + salary + ", address=" + address
                + "]";
    }

    

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}