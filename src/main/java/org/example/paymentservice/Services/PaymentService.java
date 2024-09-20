package org.example.paymentservice.Services;

public interface PaymentService {
    String createPaymentLink(long orderId) throws Exception;
}
