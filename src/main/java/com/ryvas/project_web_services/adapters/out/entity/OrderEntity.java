package com.ryvas.project_web_services.adapters.out.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ryvas.project_web_services.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;

    @OneToOne(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private PaymentEntity paymentEntity;

    @OneToMany(mappedBy = "id.orderEntity")
    private Set<OrderItemEntity> orderItems = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderEntity(Integer id, Instant moment, OrderStatus orderStatus, UserEntity client ) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }
}