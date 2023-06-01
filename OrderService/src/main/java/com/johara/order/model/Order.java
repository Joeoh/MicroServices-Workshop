package com.johara.order.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String orderId;

    private Long customerId;

    private Long productId;

    private int quantity;

    private LocalDateTime orderDate;

    private String status, topic;

    // Constructors

    public Order() {
    }

    public Order(String orderId, Long customerId, Long productId, int quantity, LocalDateTime orderDate, String status, String topic) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
        this.topic = topic;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status){this.status = status;}

    public String getStatus(){return status;}


    public String getTopic(){return topic;}

    public void setTopic(String topic){this.topic = topic;}
}
