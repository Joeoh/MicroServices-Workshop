package com.johara.order.model;

public class ProductDTO {
    public ProductDTO() {
    }
    private Long id;
    private String name;
    private String description;
    private String status;
    private String topic;
    private double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status){this.status = status;}

    public String getStatus(){
        return status;
    }


    public void setTopic(String topic){this.topic = topic;}

    public String getTopic(){return topic;}

}
