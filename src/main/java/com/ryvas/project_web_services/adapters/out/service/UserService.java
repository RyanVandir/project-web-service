package com.ryvas.project_web_services.adapters.out.service;

import com.ryvas.project_web_services.adapters.mapper.UserMapper;
import com.ryvas.project_web_services.adapters.out.entity.UserEntity;
import com.ryvas.project_web_services.adapters.out.repository.UserRepository;
import com.ryvas.project_web_services.domain.exception.UserNotFoundException;
import com.ryvas.project_web_services.domain.model.User;
import com.ryvas.project_web_services.port.out.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserServicePort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.toModel(userRepository.findAll());
    }

    @Override
    public User deleteById(Integer id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
        userRepository.delete(userEntity);
        return userMapper.toModel(userEntity);
    }
}
