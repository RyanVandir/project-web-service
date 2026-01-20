package com.ryvas.project_web_services.testconfig;

import com.ryvas.project_web_services.adapters.out.entity.UserEntity;
import com.ryvas.project_web_services.adapters.out.repository.UserRepository;
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


    @Override
    public void run(String... args) throws Exception {
        UserEntity u1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserEntity u2 = new UserEntity(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        repository.saveAll(Arrays.asList(u1, u2));
    }
}
