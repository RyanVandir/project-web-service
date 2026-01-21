package com.ryvas.project_web_services.usecase;

import com.ryvas.project_web_services.domain.exception.UserNotFoundException;
import com.ryvas.project_web_services.domain.model.User;
import com.ryvas.project_web_services.port.in.UserUseCasePort;
import com.ryvas.project_web_services.port.out.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserUseCase implements UserUseCasePort {

    private final UserServicePort userServicePort;

    @Override
    public List<User> findAll() {
        List<User> users = userServicePort.findAll();
        if (users.isEmpty()) {
            throw new UserNotFoundException("Nenhum usuário encontrado");
        }
        return users;
    }

}
