package com.foodservice.payment.domain.event;

import com.foodservice.payment.domain.model.PaymentUpdate;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class PaymentUpdateEvent extends ApplicationEvent {

    private final PaymentUpdate paymentUpdate;

    public PaymentUpdateEvent(Object source, PaymentUpdate paymentUpdate) {
        super(source);
        this.paymentUpdate = paymentUpdate;
    }
    public PaymentUpdate getPaymentUpdate() {
        return paymentUpdate;
    }

}

