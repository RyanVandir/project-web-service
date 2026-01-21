package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.domain.model.User;
import com.ryvas.project_web_services.port.in.UserUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCasePort userUseCasePort;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userUseCasePort.findAll());
    }
}
