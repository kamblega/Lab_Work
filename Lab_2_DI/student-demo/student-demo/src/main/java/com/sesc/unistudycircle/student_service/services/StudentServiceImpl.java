package com.sesc.unistudycircle.student_service.services;

import com.sesc.unistudycircle.student_service.entities.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {
    private List<Student> studentList = new ArrayList<>();
    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student getStudentById(long studentId) {
        return students.stream().filter(student -> student.getStudentId().equals(studentId)).findFirst().get();
            }
//        }
 //       return null;
 //   }

   // @Override
    public List<Student> getAllStudents() {
        return students;
    }
}