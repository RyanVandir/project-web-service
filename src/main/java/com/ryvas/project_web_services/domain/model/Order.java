package com.ryvas.project_web_services.domain.model;

import com.ryvas.project_web_services.domain.enums.OrderStatus;
import com.ryvas.project_web_services.domain.exception.InvalidOrderException;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class Order {

    private Integer id;
    private Instant moment;

    private User client;
    private OrderStatus orderStatus;

    private Set<OrderItem> orderItems = new HashSet<>();

    private Payment payment;

    public Order(Integer id, Instant moment, OrderStatus orderStatus, User client) {
        validate(moment, client, orderStatus);
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    private void validate(Instant moment, User client, OrderStatus orderStatus) {
        if (moment == null){
            throw new InvalidOrderException("Data do pedido obrigatória");
        }
        if (client == null){
            throw new InvalidOrderException("Pedido precisa ter um cliente");
        }
        if (orderStatus == null){
            throw new InvalidOrderException("Status de pedido é obrigatório");
        }
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus == null){
            throw new InvalidOrderException("Status inválido");
        }
        this.orderStatus = orderStatus;
    }

    public void addOrderItem(OrderItem orderItem) {
        if (orderItem == null) {
            throw new InvalidOrderException("Item inválido");
        }
        orderItems.add(orderItem);
    }

    public Double getTotal(){
        return orderItems.stream()
                .mapToDouble(OrderItem::getSubTotal)
                .sum();
    }

    public void setPayment(Payment payment) {
        if (payment == null){
            throw new RuntimeException("Pagamento inválido!");
        }
        this.payment = payment;
    }
}