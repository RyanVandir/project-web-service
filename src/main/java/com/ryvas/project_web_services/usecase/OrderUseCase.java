package com.ryvas.project_web_services.usecase;

import com.ryvas.project_web_services.domain.exception.OrderNotFoundException;
import com.ryvas.project_web_services.domain.model.Order;
import com.ryvas.project_web_services.port.in.OrderUseCasePort;
import com.ryvas.project_web_services.port.out.OrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderUseCase implements OrderUseCasePort {

    private final OrderServicePort orderServicePort;

    @Override
    public List<Order> findAll() {
        List<Order> orders = orderServicePort.findAll();
        if (orders.isEmpty()) {
            throw new OrderNotFoundException("Nenhum pedido encontrado!");
        }
        return orders;
    }

    @Override
    public Order deleteById(Integer id) {
        if (orderServicePort.findById(id) == null) {
            throw new OrderNotFoundException("Pedido não encontrado!");
        }
        return orderServicePort.deleteById(id);
    }

    @Override
    public Order findById(Integer id) {
        if (orderServicePort.findById(id) == null) {
            throw new OrderNotFoundException("Pedido não encontrado!");
        }
        return orderServicePort.findById(id);
    }
}
