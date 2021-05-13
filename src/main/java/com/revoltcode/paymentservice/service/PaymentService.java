package com.revoltcode.paymentservice.service;

import com.revoltcode.paymentservice.entity.Payment;
import com.revoltcode.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){

        payment.setPaymentStatus(isPaymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String isPaymentProcessing(){
        //api should be third party payment gateway
        return new Random().nextBoolean()? "success" : "false";
    }
}
