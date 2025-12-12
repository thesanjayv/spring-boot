package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(op.isPresent()){
            Student toUpdate = op.get();
            toUpdate.setName(student.getName());
            toUpdate.setSalary(student.getSalary());
            toUpdate.getAddress().setCity(student.getAddress().getCity());
            toUpdate.getAddress().setCountry(student.getAddress().getCountry());

            return studentRepo.save(toUpdate);
        }
        return null;
    }

    //deleteById
    public String deleteId(Integer id) {
        Optional<Student> op = studentRepo.findById(id);
        if(op.isPresent()){
            studentRepo.deleteById(id);
            return "Id Deleted successfully";
        }
        return "Id not present";
    }

    //deletingAll
    public String deleteMethod() {
        studentRepo.deleteAll();
        return "Deleted Completely!";
    }
}
