package com.sesc.unistudycircle.student_service.entities;

import lombok.Data;


@Data
public class Student {
    private long studentId;
    private String firstName, lastname, email, qualification, university;
}
