package com.ryvas.project_web_services.adapters.out.repository;

import com.ryvas.project_web_services.adapters.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
