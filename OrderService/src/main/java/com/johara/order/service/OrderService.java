package com.johara.order.service;

import com.johara.order.kafka.OrderProducerService;
import com.johara.order.model.Order;
import com.johara.order.model.OrderMessage;
import com.johara.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProducerService orderProducerService;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderProducerService orderProducerService) {
        this.orderRepository = orderRepository;
        this.orderProducerService = orderProducerService;
    }

    public Order createOrder(Order order) {
        // Save the order to the database
        Order savedOrder = orderRepository.save(order);

        // Send the order message to Kafka
        OrderMessage orderMessage = convertToOrderMessage(savedOrder);
        orderProducerService.sendOrderMessage(orderMessage);

        return savedOrder;
    }

    private OrderMessage convertToOrderMessage(Order order) {
        // Convert Order object to OrderMessage object
        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setId(order.getId());
        orderMessage.setOrderId(order.getOrderId());
        orderMessage.setCustomerId(order.getCustomerId());
        orderMessage.setProductId(order.getProductId());
        orderMessage.setQuantity(order.getQuantity());
        orderMessage.setOrderDate(order.getOrderDate());

        return orderMessage;
    }
}
