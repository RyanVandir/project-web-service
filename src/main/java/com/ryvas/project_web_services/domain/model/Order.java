package com.ryvas.project_web_services.domain.model;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
public class Order {

    private Integer id;
    private Instant moment;

    private User client;

    public Order(Integer id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

}
