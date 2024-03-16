package com.foodservice.order.domain.events;

import com.foodservice.order.domain.service.impl.OrderServiceImpl;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class CreateOrderEvent extends ApplicationEvent {

    private UUID orderId;
    public CreateOrderEvent(Object source, UUID orderId) {
        super(source);
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }
}
