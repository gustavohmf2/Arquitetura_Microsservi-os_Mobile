package com.foodservice.order.infrastructure.integration.notification;

import com.foodservice.order.domain.events.CreateOrderEvent;
import com.foodservice.order.domain.model.Order;
import com.foodservice.order.domain.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl {
    private Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
    private final JmsTemplate jmsTemplate;
    private final OrderRepository orderRepository;

    public NotificationServiceImpl(JmsTemplate jmsTemplate, OrderRepository orderRepository) {
        this.jmsTemplate = jmsTemplate;
        this.orderRepository = orderRepository;
    }

    @EventListener
    void processRequest(CreateOrderEvent createOrderEvent) {
        logger.info("m=processRequest, status=start, New request, order: {}", createOrderEvent.getOrderId());
        Order order = orderRepository.findOne(createOrderEvent.getOrderId());
        var notification = new NotificationOrderDTO(order.getCustomerId(),order.getMerchantId(),order.getStatusOrder(), order.getCreateAt());
        jmsTemplate.convertAndSend("foodservice-notification", notification);
        logger.info("m=processRequest, status=finish,New request, order: {}", createOrderEvent);
    }
}
