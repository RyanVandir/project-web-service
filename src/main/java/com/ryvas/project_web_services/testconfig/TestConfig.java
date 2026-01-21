package com.ryvas.project_web_services.testconfig;

import com.ryvas.project_web_services.adapters.mapper.UserMapper;
import com.ryvas.project_web_services.adapters.out.repository.UserRepository;
import com.ryvas.project_web_services.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner {

    private final UserRepository repository;
    private final UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Ryan Brass", "ryan@gmail.com", "966666666", "123456");
        User u4 = new User(null, "Liva Gran", "livia@gmail.com", "955555555", "123456");

        repository.saveAll(userMapper.toEntity(Arrays.asList(u1, u2, u3, u4)));
    }
}
