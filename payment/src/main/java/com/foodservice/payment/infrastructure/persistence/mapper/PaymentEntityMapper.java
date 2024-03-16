package com.foodservice.payment.infrastructure.persistence.mapper;

import com.foodservice.payment.domain.model.Payment;
import com.foodservice.payment.infrastructure.persistence.entity.PaymentEntity;

public class PaymentEntityMapper {

    public static Payment mapToPayment(PaymentEntity payment) {
        return new Payment(payment.getId(),payment.getOrderId(),payment.getCustomerId(),payment.getMerchantId(),payment.getAmount(),payment.getPaymentMethod(), payment.getPaymentStatus());
    }

    public static PaymentEntity mapToPaymentEntity(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setOrderId(payment.getOrderId());
        paymentEntity.setCustomerId(payment.getCustomerId());
        paymentEntity.setMerchantId(payment.getMerchantId());
        paymentEntity.setAmount(payment.getAmount());
        paymentEntity.setPaymentMethod(payment.getPaymentMethod());
        paymentEntity.setPaymentStatus(payment.getPaymentStatus());
        return paymentEntity;
    }
}
