package com.johara.email.service;

import com.johara.email.model.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

@Service
public class EmailSendingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSendingService.class);

    public void sendOrderConfirmationEmail(OrderMessage orderMessage) {
        LOGGER.info("Sending order confirmation email for orderId: {}", orderMessage.getOrderId());

        Email from = new Email("adamrbyrne@gmail.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email("adamrbyrne@gmail.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException ex) {
            LOGGER.error("ERROR");
        }
    }
}
