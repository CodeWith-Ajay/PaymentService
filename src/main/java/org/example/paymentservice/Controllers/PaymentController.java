package org.example.paymentservice.Controllers;

import org.example.paymentservice.Payment_Gateway.PaymentGatewayInterface;
import org.example.paymentservice.Payment_Gateway.StripePaymentGateway;
import org.example.paymentservice.Services.PaymentService;
import org.example.paymentservice.dtos.CreatePaymentLinkRequestDto;
import org.example.paymentservice.dtos.CreatePaymentLinkResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/paymentLink")
    public ResponseEntity<CreatePaymentLinkResponseDto> createPaymentLink(@RequestBody CreatePaymentLinkRequestDto requestDto) throws Exception {
        try {
            String url = paymentService.createPaymentLink(requestDto.getOrderId());
            CreatePaymentLinkResponseDto responseDto = new CreatePaymentLinkResponseDto();
            responseDto.setUrl(url);
            return ResponseEntity.ok(responseDto);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
