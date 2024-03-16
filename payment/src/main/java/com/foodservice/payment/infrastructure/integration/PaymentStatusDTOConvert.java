package com.foodservice.payment.infrastructure.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodservice.payment.infrastructure.integration.dto.PaymentStatusDTO;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;


public class PaymentStatusDTOConvert implements MessageConverter {

    private final ObjectMapper objectMapper;

    public PaymentStatusDTOConvert(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        PaymentStatusDTO dto = (PaymentStatusDTO) object;
        TextMessage textMessage = null;
        try {
            textMessage = session.createTextMessage(objectMapper.writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            System.out.println("Convert Fail to MessageTexts");
            throw new RuntimeException(e);
        }
        return textMessage;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        TextMessage textMessage = (TextMessage) message;
        String payload = textMessage.getText();

        PaymentStatusDTO dto = null;
        try {
            dto = objectMapper.readValue(payload, PaymentStatusDTO.class);
        } catch (Exception e) {
            System.out.println("Fail to convert to DTO");
        }

        return dto;
    }
}

