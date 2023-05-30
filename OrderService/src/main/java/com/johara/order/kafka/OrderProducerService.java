package com.johara.order.kafka;

import com.johara.order.model.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {
    private static final String TOPIC_NAME = "orders";
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducerService.class);

    private final KafkaTemplate<Object, String> kafkaTemplate;

    @Autowired
    public OrderProducerService(KafkaTemplate<Object, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderMessage(OrderMessage orderMessage) {
        kafkaTemplate.send(TOPIC_NAME, orderMessage.toString());
        LOGGER.info("Order message sent to Kafka topic: {}", TOPIC_NAME);
    }
}
