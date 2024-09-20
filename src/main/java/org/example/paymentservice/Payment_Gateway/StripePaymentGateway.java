package org.example.paymentservice.Payment_Gateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGatewayInterface {


    @Value("${stripe.secret.key}")
    private String stripeSecretKey;
    @Override
    public String createPaymentLink(long orderId, long amount) throws StripeException {
        Stripe.apiKey = stripeSecretKey;

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1Q0zHNF57fTA5yqRDxZMo6gv")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                .setRedirect(
                                        PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                        .setUrl("https://www.amazon.in/")
                                        .build()
                                ).build()
                        ).build();



        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.getUrl();
    }
}
