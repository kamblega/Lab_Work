package com.sesc.unistudycircle.student_service.services;

import com.sesc.unistudycircle.student_service.entities.Student;
import com.sesc.unistudycircle.student_service.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {


    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    Student student;

    @BeforeEach
    void setUp() {
        student = new Student(111L, "Satish", "Kumar",
                "s.kumar@leedsbeckett.ac.uk", "MSc Computer Science",
                "Leeds Beckett University");
    }


    @Test
    void test_Create_Student() {

        //given - student object is already created in the setUp method


        // mock the call to the repository
        when(studentRepository.save(student)).thenReturn(student);

        // when
        Student savedStudent = studentServiceImpl.createStudent(student);

        //then
        assertEquals(student.getStudentId(), savedStudent.getStudentId());
        assertEquals(student.getFirstName(), savedStudent.getFirstName());
        assertEquals(student.getLastName(), savedStudent.getLastName());
        assertEquals(student.getEmail(), savedStudent.getEmail());
        assertEquals(student.getQualification(), savedStudent.getQualification());
        assertEquals(student.getUniversity(), savedStudent.getUniversity());

    }

    @Test
    void test_Get_Student_By_Id() {

        //given - student object is already created in the setUp method

        // mock the call to the repository
        when(studentRepository.findById(111l)).thenReturn(Optional.of(student));

        // when
        Student foundStudent = studentServiceImpl.getStudentById(111l);

        //then
        assertNotNull(foundStudent);
        assertEquals(student.getStudentId(), foundStudent.getStudentId());
        assertEquals(student.getFirstName(), foundStudent.getFirstName());
    }

    @Test
    void test_Update_Student_By_Id() {

        //given - student object is already created in the setUp method

        Student updatedStudent = new Student(111L, "Satish", "Malik",
                "s.malik@leedsbeckett.ac.uk", "MSc Computer Science",
                "Leeds Beckett University");

        // mock the call to the repository
        when(studentRepository.existsById(111l)).thenReturn(true);
        when(studentRepository.save(updatedStudent)).thenReturn(updatedStudent);

        // when
        Student updatedStudentResponse = studentServiceImpl.updateStudentById(111l, updatedStudent);

        //then
        assertNotNull(updatedStudentResponse);
        assertEquals(updatedStudent.getStudentId(), updatedStudentResponse.getStudentId());
        assertEquals(updatedStudent.getLastName(), updatedStudentResponse.getLastName());
        assertEquals(updatedStudent.getEmail(), updatedStudentResponse.getEmail());
    }

    @Test
    void test_Delete_Student_By_Id() {

        //given - student object is already created in the setUp method


        // mock the call to the repository
        when(studentRepository.existsById(student.getStudentId())).thenReturn(true);

        doNothing().when(studentRepository).deleteById(student.getStudentId());

        // when
        studentServiceImpl.deleteStudentById(student.getStudentId());

        //then
        when(studentRepository.existsById(student.getStudentId())).thenReturn(false);
        assertFalse(studentRepository.existsById(student.getStudentId()));
    }
}