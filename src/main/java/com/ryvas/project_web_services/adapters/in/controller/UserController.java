package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        return ResponseEntity.ok()
                .body(new User(1,
                        "Ryan",
                        "bdhefrejwn@dhhs",
                        "179992055559",
                        "35277gbcdh"));
    }
}
