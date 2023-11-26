package com.twincode.demo.rest;

import com.twincode.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    // define @PostConstruct to load students only once
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        Student s1 = new Student("twincode","vn");
        Student s2 = new Student("tuan","nd");
        students.add(s1);
        students.add(s2);
    }
    // define endpoint "/students" - return a list student
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    // define endpoint "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId > students.size() - 1 || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }




}
