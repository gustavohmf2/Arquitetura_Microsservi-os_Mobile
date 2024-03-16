package com.foodservice.payment.infrastructure.integration.dto;

import com.foodservice.payment.domain.model.enums.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;
import java.util.UUID;

public class PaymentStatusDTO implements Serializable {

    private UUID id;

    private UUID orderId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    public PaymentStatusDTO(UUID id, UUID orderId, PaymentStatus paymentStatus) {
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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
