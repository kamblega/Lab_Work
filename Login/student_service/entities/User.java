package com.sesc.unistudycircle.student_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userID;
    private String password;
}