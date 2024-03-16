package com.foodservice.payment.domain.event;

import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class PaymentRequestEvent extends ApplicationEvent {

    private final UUID paymentRequestId;
    public PaymentRequestEvent(Object source, UUID paymentRequestId) {
        super(source);
        this.paymentRequestId = paymentRequestId;
    }

    public UUID getPaymentRequestId() {
        return paymentRequestId;
    }
}
