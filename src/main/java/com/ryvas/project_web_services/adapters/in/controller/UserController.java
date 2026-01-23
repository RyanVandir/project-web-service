package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.adapters.in.dto.UserDto;
import com.ryvas.project_web_services.adapters.in.dto.UserResponse;
import com.ryvas.project_web_services.adapters.mapper.UserMapper;
import com.ryvas.project_web_services.port.in.UserUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCasePort userUseCasePort;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(
                userMapper.toResponse(
                        userUseCasePort.insert(
                                userMapper.toModel(userDto))
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok().body(userMapper.toResponse(userUseCasePort.findAll()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserResponse> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userMapper.toResponse(userUseCasePort.deleteById(id)));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userMapper.toResponse(userUseCasePort.findById(id)));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userMapper.toResponse(userUseCasePort.update(id, userMapper.toModel(userDto))));
    }
}
