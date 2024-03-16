package com.foodservice.payment.domain.service.impl;

import com.foodservice.payment.domain.event.PaymentRequestEvent;
import com.foodservice.payment.domain.event.PaymentUpdateEvent;
import com.foodservice.payment.domain.model.Payment;
import com.foodservice.payment.domain.model.PaymentUpdate;
import com.foodservice.payment.domain.model.enums.PaymentStatus;
import com.foodservice.payment.domain.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentEngineProcessor {

    private final Logger logger = LoggerFactory.getLogger(PaymentEngineProcessor.class);
    private final PaymentRepository paymentRepository;
    private final ApplicationEventPublisher publisher;

    public PaymentEngineProcessor(PaymentRepository paymentRepository, ApplicationEventPublisher publisher) {
        this.paymentRepository = paymentRepository;
        this.publisher = publisher;
    }

    @Scheduled(fixedRate=60000)
    void process() {
        logger.info("m=process, satatus=start, process pending payments");
        List<Payment> pendingPayments = paymentRepository.findAllPaymentPending();
        if(pendingPayments.isEmpty()) {
            logger.info("m=process, satatus=start, dont have payments to proccess");
        }
            pendingPayments.stream().forEach(payment -> {
                payment.setPaymentStatus(PaymentStatus.APPROVED);
                paymentRepository.save(payment);
                publisher.publishEvent(new PaymentUpdateEvent(this, new PaymentUpdate(payment.getId(), payment.getOrderId(), payment.getPaymentStatus())));
            });

        logger.info("m=process, satatus=finish, process pending payments");
    }
}
