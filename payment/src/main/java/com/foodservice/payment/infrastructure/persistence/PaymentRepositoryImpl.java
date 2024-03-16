package com.foodservice.payment.infrastructure.persistence;

import com.foodservice.payment.domain.model.Payment;
import com.foodservice.payment.domain.model.enums.PaymentStatus;
import com.foodservice.payment.domain.repository.PaymentRepository;
import com.foodservice.payment.infrastructure.persistence.entity.PaymentEntity;
import com.foodservice.payment.infrastructure.persistence.mapper.PaymentEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.foodservice.payment.infrastructure.persistence.mapper.PaymentEntityMapper.mapToPayment;
import static com.foodservice.payment.infrastructure.persistence.mapper.PaymentEntityMapper.mapToPaymentEntity;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentRepositoryH2 paymentRepositoryH2;

    public PaymentRepositoryImpl(PaymentRepositoryH2 paymentRepositoryH2) {
        this.paymentRepositoryH2 = paymentRepositoryH2;
    }

    @Override
    public UUID save(Payment payment) {
        PaymentEntity savedPayment = paymentRepositoryH2.save(mapToPaymentEntity(payment));
        return savedPayment.getId();
    }

    @Override
    public Payment findOne(UUID id) {
        PaymentEntity payment = paymentRepositoryH2.getReferenceById(id);
        return mapToPayment(payment);
    }

    @Override
    public List<Payment> findAllPaymentPending() {
        return paymentRepositoryH2.findAllByPaymentStatus(PaymentStatus.PROCESSING)
                .stream().map(PaymentEntityMapper::mapToPayment).toList();
    }
}
