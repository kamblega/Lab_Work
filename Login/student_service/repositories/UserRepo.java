package com.sesc.unistudycircle.student_service.repositories;

import com.sesc.unistudycircle.student_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

    User findByUserID(String userID);
}