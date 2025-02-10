package com.sesc.unistudycircle.student_service.controllers;

import com.sesc.unistudycircle.student_service.entities.Student;
import com.sesc.unistudycircle.student_service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ( "/students" ) // Base path for student-related endpoints
public class StudentController {

    //@Autowired
    private StudentService studentService; // Injecting the service

    @PostMapping ( "/create" )
    public ResponseEntity<Student> createStudent ( @RequestBody Student student ) {
        Student createdStudent = studentService.saveStudent ( student );
        return new ResponseEntity<> ( createdStudent , HttpStatus.CREATED );
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents ( ) {
        List<Student> studentList = studentService.getAllStudents ();
        return new ResponseEntity<> ( studentList , HttpStatus.OK );
    }

    @GetMapping ( "/{studentId}" )
    public ResponseEntity<Student> getStudentById ( @PathVariable long studentId ) {
        Student student = studentService.getStudentById ( studentId );
        return new ResponseEntity<> ( student , HttpStatus.OK );
    }
}