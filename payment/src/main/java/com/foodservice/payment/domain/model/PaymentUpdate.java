package com.foodservice.payment.domain.model;

import com.foodservice.payment.domain.model.enums.PaymentStatus;

import java.util.UUID;

public class PaymentUpdate {

    private UUID paymentId;
    private UUID orderId;
    private PaymentStatus paymentStatus;

    public PaymentUpdate(UUID paymentId, UUID orderId, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
    }

    public PaymentUpdate() {
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
