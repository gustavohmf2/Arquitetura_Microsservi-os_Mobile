package com.foodservice.order.infrastructure.integration.payment.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;
import java.util.UUID;

public class PaymentStatusDTO implements Serializable {

    private UUID id;
    private UUID orderId;
    @Enumerated(EnumType.STRING)
    private String paymentStatus;
    public PaymentStatusDTO(UUID id, UUID orderId, String paymentStatus) {
        this.id = id;
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatusDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
