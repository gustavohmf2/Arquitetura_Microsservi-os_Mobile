package com.foodservice.order.infrastructure.integration.payment;

import com.foodservice.order.domain.events.OrderPaymentEvent;
import com.foodservice.order.domain.model.OrderPaymentStatus;
import com.foodservice.order.infrastructure.integration.payment.dto.PaymentStatusDTO;
import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    private Logger logger = LoggerFactory.getLogger(PaymentListener.class);
    private final PaymentStatusDTOConvert convert;
    private final ApplicationEventPublisher publisher;

    public PaymentListener(PaymentStatusDTOConvert convert, ApplicationEventPublisher publisher) {
        this.convert = convert;
        this.publisher = publisher;
    }

    @JmsListener(destination = "foodservice-payment", containerFactory = "defaultFactory")
    void process(TextMessage message) throws JMSException {
        PaymentStatusDTO paymentStatusDTO = (PaymentStatusDTO) convert.fromMessage(message);
        logger.info("m=process, status=start, rocesses paymeny message, order={}", paymentStatusDTO.getOrderId());
        OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus(paymentStatusDTO.getId(),paymentStatusDTO.getOrderId(), paymentStatusDTO.getPaymentStatus());
        publisher.publishEvent(new OrderPaymentEvent(this, orderPaymentStatus));
        message.acknowledge();
        logger.info("m=process, status=finish, rocesses payment message, order={}", paymentStatusDTO.getOrderId());
    }
}
