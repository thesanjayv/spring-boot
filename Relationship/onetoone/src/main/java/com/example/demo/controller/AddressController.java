package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AddressService;
import com.example.demo.service.addressService;


@RestController
@RequestMapping("/address")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    //create
    @PostMapping
    public Address doPost(@RequestBody Address address){
        return AddressService.createMethod(address);
    }

    //read
    @GetMapping
    public List<Address> doGet(){
        return AddressService.getMethod();
    }

    //update
    @PutMapping("/{id}")
    public Address doUpdate(@PathVariable int id, @RequestBody Address address){
        return addressService.updatemethod(id, address);
    }

    //delete
    @DeleteMapping("/{id}")
    public String doDelete(@PathVariable Integer id){
        String message = addressService.deleteId(id);
        return message;
    }

    //delete
    @DeleteMapping
    public String doDeleteAll(){
        return addressService.deleteMethod();

    }
}
