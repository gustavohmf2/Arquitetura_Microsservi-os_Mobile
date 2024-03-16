package com.foodservice.payment.infrastructure.integration;

import com.foodservice.payment.domain.event.PaymentRequestEvent;
import com.foodservice.payment.domain.event.PaymentUpdateEvent;
import com.foodservice.payment.domain.model.PaymentUpdate;
import com.foodservice.payment.infrastructure.integration.dto.PaymentStatusDTO;
import com.foodservice.payment.infrastructure.persistence.PaymentRepositoryH2;
import com.foodservice.payment.infrastructure.persistence.entity.PaymentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentQueueServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(PaymentQueueServiceImpl.class);
    private final PaymentRepositoryH2 paymentRepositoryH2;
    private final JmsTemplate jmsTemplate;

    public PaymentQueueServiceImpl(PaymentRepositoryH2 paymentRepositoryH2, JmsTemplate jmsTemplate) {
        this.paymentRepositoryH2 = paymentRepositoryH2;
        this.jmsTemplate = jmsTemplate;
    }

    @EventListener
    void processRequest(PaymentRequestEvent paymentRequestEvent) {
        logger.info("m=processRequest, status=start, payment request={}",paymentRequestEvent.getPaymentRequestId());
        PaymentEntity payment = paymentRepositoryH2.getReferenceById(paymentRequestEvent.getPaymentRequestId());
        PaymentStatusDTO paymentStatusDTO = new PaymentStatusDTO(payment.getId(),payment.getOrderId(), payment.getPaymentStatus());
        jmsTemplate.convertAndSend("foodservice-payment", paymentStatusDTO);
        logger.info("m=processRequest, status=finish, payment request={}",paymentRequestEvent.getPaymentRequestId());
    }


    @EventListener
    void processUpdate(PaymentUpdateEvent paymentUpdateEvent) {
        PaymentUpdate payment = paymentUpdateEvent.getPaymentUpdate();
        logger.info("m=processUpdate, status=finish, payment update={}", payment);
        PaymentStatusDTO paymentStatusDTO = new PaymentStatusDTO(payment.getPaymentId(),payment.getOrderId(), payment.getPaymentStatus());
        jmsTemplate.convertAndSend("foodservice-payment", paymentStatusDTO);
        logger.info("m=processUpdate, status=finish, payment update={}", payment);
    }
}
