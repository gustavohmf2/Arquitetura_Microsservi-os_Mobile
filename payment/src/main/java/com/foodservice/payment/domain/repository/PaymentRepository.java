package com.foodservice.payment.domain.repository;

import com.foodservice.payment.domain.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository {
    UUID save(final Payment payment);
    Payment findOne(UUID id);
    List<Payment> findAllPaymentPending();
}
