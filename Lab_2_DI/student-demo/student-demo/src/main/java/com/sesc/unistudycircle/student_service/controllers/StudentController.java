package com.sesc.unistudycircle.student_service.controllers;

import com.sesc.unistudycircle.student_service.entities.Student;
import com.sesc.unistudycircle.student_service.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")


public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}

@PostMapping("/create")
public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    Student createdStudent = studentService.saveStudent(student);
    return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
}