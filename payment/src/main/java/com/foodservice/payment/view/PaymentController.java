package com.foodservice.payment.view;

import com.foodservice.payment.domain.model.Payment;
import com.foodservice.payment.domain.service.PaymentService;
import com.foodservice.payment.view.dto.PaymentRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public record PaymentController(PaymentService paymentService) {

    @PostMapping
    ResponseEntity requestPayment(@RequestBody PaymentRequestDTO requestPaymentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.requestPayment(mapToPayment(requestPaymentDTO)));
    }

    @GetMapping("/{id}")
    ResponseEntity findOne(@PathVariable UUID id) {
        return ResponseEntity.ok(paymentService.findOne(id));
    }

    private Payment mapToPayment(final PaymentRequestDTO requestPaymentDTO) {
        Payment payment = new Payment();
        payment.setOrderId(requestPaymentDTO.getOrderId());
        payment.setCustomerId(requestPaymentDTO.getCustomerId());
        payment.setMerchantId(requestPaymentDTO.getMerchantId());
        payment.setAmount(requestPaymentDTO.getAmount());
        payment.setPaymentMethod(requestPaymentDTO.getPaymentMethod());
        return payment;
    }
}
