package org.example.paymentservice.Services;

import org.example.paymentservice.Payment_Gateway.PaymentGatewayInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentGatewayInterface pgi;
    @Override
    public String createPaymentLink(long orderId) throws Exception {
        long amount=1000;
        return pgi.createPaymentLink(orderId, amount);
    }
}
