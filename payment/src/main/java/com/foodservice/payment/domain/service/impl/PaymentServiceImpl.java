package com.foodservice.payment.domain.service.impl;

import com.foodservice.payment.domain.event.PaymentRequestEvent;
import com.foodservice.payment.domain.model.Payment;
import com.foodservice.payment.domain.model.enums.PaymentStatus;
import com.foodservice.payment.domain.repository.PaymentRepository;
import com.foodservice.payment.domain.service.PaymentService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record PaymentServiceImpl(PaymentRepository paymentRepository, ApplicationEventPublisher applicationEventPublisher) implements PaymentService {
    @Override
    public UUID requestPayment(final Payment payment) {
        payment.setPaymentStatus(PaymentStatus.PROCESSING);
        UUID paymentRequested = paymentRepository.save(payment);
        applicationEventPublisher.publishEvent(new PaymentRequestEvent(this, paymentRequested));
        return paymentRequested;
    }

    @Override
    public Payment findOne(UUID id) {
        return paymentRepository.findOne(id);
    }
}
