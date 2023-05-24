package com.johara.email.service;

import com.johara.email.model.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSendingService.class);

    public void sendOrderConfirmationEmail(OrderMessage orderMessage) {
        // Logic to send order confirmation email
        LOGGER.info("Sending order confirmation email for orderId: {}", orderMessage.getOrderId());

        // Implement your email sending logic here
        // Use the orderMessage to retrieve necessary information for the email content, such as customer email, product details, etc.
    }
}
