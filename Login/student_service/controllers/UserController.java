package com.sesc.unistudycircle.student_service.controllers;

import ch.qos.logback.core.model.Model;
import com.sesc.unistudycircle.student_service.entities.User;
import com.sesc.unistudycircle.student_service.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
    public class UserController {

        @Autowired
        public UserRepo usrrepo;

        @GetMapping ( "/" )
        public String login ( Model model ) {
            model.addText ( "users" );
            return "login";
        }

        @PostMapping ( "/userLogin" )
        public String loginUsers ( @ModelAttribute ( "users" ) User user ) {
            Optional<User> userData = usrrepo.findById ( user.getUserID () );
            if (userData.isPresent ()) {
                if (userData.get ().getPassword ().equals ( user.getPassword () )) {
                    return "homepage";
                } else {
                    return "error";
                }
            } else {
                return "error";
            }
        }
    }
