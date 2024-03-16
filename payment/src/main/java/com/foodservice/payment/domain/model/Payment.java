package com.foodservice.payment.domain.model;

import com.foodservice.payment.domain.model.enums.PaymentMethod;
import com.foodservice.payment.domain.model.enums.PaymentStatus;

import java.util.UUID;

public class Payment {
    private UUID id;
    private UUID orderId;
    private UUID customerId;
    private UUID merchantId;
    private Double amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;

    public Payment(UUID id,UUID orderId, UUID customerId, UUID merchantId, Double amount, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        this.id= id;
        this.orderId = orderId;
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Payment() {
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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(UUID merchantId) {
        this.merchantId = merchantId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
