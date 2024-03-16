package com.foodservice.payment.domain.service;

import com.foodservice.payment.domain.model.Payment;

import java.util.UUID;

public interface PaymentService {
    UUID requestPayment(final Payment payment);

    Payment findOne(UUID id);
}
