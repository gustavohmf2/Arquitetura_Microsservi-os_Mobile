package com.foodservice.order.domain.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

public class OrderPaymentStatus {
    private UUID paymentId;
    private UUID orderId;
    @Enumerated(EnumType.STRING)
    private String paymentStatus;
    public OrderPaymentStatus(UUID paymentId, UUID orderId, String paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
    }

    public OrderPaymentStatus() {
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

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
