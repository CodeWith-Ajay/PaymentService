package org.example.paymentservice.Payment_Gateway;

public interface PaymentGatewayInterface {

    String createPaymentLink(long orderId, long amount)throws Exception;
}
