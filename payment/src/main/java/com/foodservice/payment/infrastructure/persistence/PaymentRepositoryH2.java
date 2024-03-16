package com.foodservice.payment.infrastructure.persistence;

import com.foodservice.payment.domain.model.Payment;
import com.foodservice.payment.domain.model.enums.PaymentStatus;
import com.foodservice.payment.infrastructure.persistence.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentRepositoryH2 extends JpaRepository<PaymentEntity, UUID> {
    List<PaymentEntity> findAllByPaymentStatus(PaymentStatus paymentStatus);
}
