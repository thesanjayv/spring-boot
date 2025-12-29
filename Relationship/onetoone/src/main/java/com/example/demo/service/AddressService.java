package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.StudentRepo;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private StudentRepo studentRepo;

    public Address createMethod(Address address) {
        //addressRepo.save(address);
        // Student student = address.getStudent();
        // student.setAddress(address);
        // studentRepo.save(student);
        // return address; 
        address.getStudent().setAddress(address);
        Student s=studentRepo.save(address.getStudent());
        return s.getAddress();
    }

    //reading
    public List<Address> getMethodService() {
        return addressRepo.findAll();
    }

    //updating
    public Address updatemethod(Integer id, Address address) {
        Optional<Address> op = addressRepo.findById(id);
        if (op.isPresent()) {
            // Address oldAddress = op.get();
            // oldAddress.setCity(address.getCity());
            // oldAddress.setCountry(address.getCountry());
            // oldAddress.getStudent().setName(address.getStudent().getName());
            // oldAddress.getStudent().setSalary(address.getStudent().getSalary());
            address.setAddressId(id);
            //address.getStudent().setAddress(address);

            return addressRepo.save(address);
        }
        return null;
    }

    //deleteById
    public String deleteId(Integer id) {
        Optional<Address> op = addressRepo.findById(id);
        if (op.isPresent()) {
            // addressRepo.deleteById(id);
            // return "Deleted by ID";

            Address address = op.get();
            Student student = address.getStudent();
            if (student != null) {
                student.setAddress(null);
                studentRepo.save(student);
            }
            addressRepo.deleteById(id);
            return "Deleted by ID";
        }
        return "Not Found";

    //deletingTotalEntity
    public String deleteMethod() {
        addressRepo.deleteAll();
        return "Deleted completely!!";
    }
}
