package com.foodservice.order.domain.events;

import com.foodservice.order.domain.model.OrderPaymentStatus;
import org.springframework.context.ApplicationEvent;

public class OrderPaymentEvent extends ApplicationEvent {

    private final OrderPaymentStatus orderPaymentStatus;
    public OrderPaymentEvent(Object source, OrderPaymentStatus orderPaymentStatus) {
        super(source);
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

}
