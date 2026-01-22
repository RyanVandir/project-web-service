package com.ryvas.project_web_services.adapters.out.entity.pk;

import com.ryvas.project_web_services.adapters.out.entity.OrderEntity;
import com.ryvas.project_web_services.adapters.out.entity.ProductEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class OrderItemPK {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
