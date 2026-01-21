package com.ryvas.project_web_services.adapters.out.repository;

import com.ryvas.project_web_services.adapters.out.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
