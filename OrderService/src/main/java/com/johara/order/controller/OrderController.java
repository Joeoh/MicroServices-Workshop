package com.johara.order.controller;

import com.johara.order.client.ProductServiceClient;
import com.johara.order.model.Order;
import com.johara.order.model.ProductDTO;
import com.johara.order.repository.OrderRepository;
import com.johara.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    private OrderService orderService;
    private ProductServiceClient productServiceClient;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> maybeOrder = orderRepository.findById(id);
        return maybeOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Optional<Order> maybeExistingOrder = orderRepository.findById(id);
        if (maybeExistingOrder.isPresent()) {
            order.setId(id);
            Order updatedOrder = orderRepository.save(order);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        Optional<Order> maybeExistingOrder = orderRepository.findById(id);
        if (maybeExistingOrder.isPresent()) {
            orderRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }



    @GetMapping("/by-topic/{topic}")
    public ResponseEntity<List<Order>> getOrdersByField(@PathVariable String topic) {
        List<Order> ordersByTopic = orderRepository.findAll().stream()
                .filter(order -> order.getTopic().equals(topic))
                .collect(Collectors.toList());
        if (!ordersByTopic.isEmpty()) {
            return ResponseEntity.ok(ordersByTopic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
