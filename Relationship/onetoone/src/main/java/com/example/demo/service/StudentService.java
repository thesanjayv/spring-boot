package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    //Student
    //creating
    public Student createMethod(Student student) {
        return studentRepo.save(student);
    }

    //reading
    public List<Student> getMethod() {
        return studentRepo.findAll();
    }

    //updating
    public Student updatemethod(Integer id, Student student) {
        Optional<Student> op = studentRepo.findById(id);
        if (op.isPresent()) {
            Student toUpdate = op.get();
            toUpdate.setName(student.getName());
            toUpdate.setSalary(student.getSalary());

            if (toUpdate.getAddress() != null && toUpdate.getAddress() != null) {
                Address existing = toUpdate.getAddress();
                Address newData = toUpdate.getAddress();

                existing.setCity(newData.getCity());
                existing.setCountry(newData.getCountry());
                return studentRepo.save(student);
            }
        }
        return null;
    }

    //deleteById
    public void deleteId(Integer id) {
        studentRepo.deleteById(id);
    }

    //deletingTotalEntity
    public void deleteMethod(Student student) {
        studentRepo.delete(student);
    }
}
