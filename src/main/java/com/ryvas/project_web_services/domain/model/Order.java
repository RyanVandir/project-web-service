package com.ryvas.project_web_services.domain.model;

import com.ryvas.project_web_services.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
public class Order {

    private Integer id;
    private Instant moment;

    private User client;
    private OrderStatus orderStatus;

    public Order(Integer id, Instant moment, User client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.orderStatus = orderStatus;
    }

}
