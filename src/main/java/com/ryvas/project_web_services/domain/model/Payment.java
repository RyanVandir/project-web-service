package com.ryvas.project_web_services.domain.model;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
public class Payment {

    private Integer id;
    private Instant moment;

    private Order order;

    public Payment(Integer id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }


}
