package com.ryvas.project_web_services.adapters.out.service;

import com.ryvas.project_web_services.adapters.mapper.OrderMapper;
import com.ryvas.project_web_services.adapters.out.entity.OrderEntity;
import com.ryvas.project_web_services.adapters.out.repository.OrderRepository;
import com.ryvas.project_web_services.domain.exception.OrderNotFoundException;
import com.ryvas.project_web_services.domain.model.Order;
import com.ryvas.project_web_services.port.out.OrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService implements OrderServicePort {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        return orderMapper.toModel(orderRepository.findAll());
    }

    @Override
    public Order deleteById(Integer id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado"));
        orderRepository.delete(orderEntity);
        return orderMapper.toModel(orderEntity);
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.toModel(orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado")));
    }
}
