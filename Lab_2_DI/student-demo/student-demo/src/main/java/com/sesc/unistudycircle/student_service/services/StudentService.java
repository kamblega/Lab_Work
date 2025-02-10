package com.sesc.unistudycircle.student_service.services;

import com.sesc.unistudycircle.student_service.entities.Student;
import com.sesc.unistudycircle.student_service.services.StudentService;

import java.util.List;

public interface StudentService {
    Student saveStudent ( Student student );

    Student getStudentById ( long studentId );

    List<Student> getAllStudents ( );
}
