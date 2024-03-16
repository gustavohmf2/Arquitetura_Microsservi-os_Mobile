package com.foodservice.notification.infrastructure.listener;


import com.foodservice.notification.infrastructure.listener.dto.NotificationOrderDTO;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationProcessListener {

    private final NotificationOrderDTOConverter notificationOrderDTOConverter;

    public NotificationProcessListener(NotificationOrderDTOConverter notificationOrderDTOConverter) {
        this.notificationOrderDTOConverter = notificationOrderDTOConverter;
    }

    @JmsListener(destination = "foodservice-notification", containerFactory = "defaultFactory")
    void process(Message message) throws JMSException {
        NotificationOrderDTO notification = (NotificationOrderDTO) notificationOrderDTOConverter.fromMessage(message);
        System.out.println("Receive notification: statusOrder=> %s".formatted(notification.getStatusOrder()));
    }
}
