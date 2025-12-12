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

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    //create
    @PostMapping
    public Student doPost(@RequestBody Student student){
        return studentService.createMethod(student);
    }

    //read
    @GetMapping
    public List<Student> doGet(){
        return studentService.getMethod();
    }

    //update
    @PutMapping("/{id}")
    public Student doUpdate(@PathVariable int id, @RequestBody Student student){
        return studentService.updatemethod(id, student);
    }

    //delete
    @DeleteMapping("/{id}")
    public String doDelete(@PathVariable Integer id){
        String message = studentService.deleteId(id);
        return message;
    }

    //delete
    @DeleteMapping
    public String doDeleteAll(){
        return studentService.deleteMethod();

    }
}
