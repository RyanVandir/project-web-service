package com.ryvas.project_web_services.adapters.out.repository;

import com.ryvas.project_web_services.adapters.out.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
}
