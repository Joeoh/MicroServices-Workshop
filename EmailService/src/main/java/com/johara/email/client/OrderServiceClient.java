package com.johara.email.client;

import com.johara.email.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderServiceClient {
    private static final String ORDER_SERVICE_NAME = "order-service";
    private static final String ORDERS_ENDPOINT = "/orders";
    private static final String ORDER_ID_PARAM = "/{id}";

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderServiceClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = new RestTemplate();
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        ServiceInstance orderInstance = getServiceInstance();
        String orderUrl = orderInstance.getUri().toString() + ORDERS_ENDPOINT;
        ResponseEntity<OrderDTO> response = restTemplate.postForEntity(orderUrl, orderDTO, OrderDTO.class);
        return response.getBody();
    }

    public OrderDTO getOrderById(Long orderId) {
        ServiceInstance orderInstance = getServiceInstance();
        String orderUrl = orderInstance.getUri().toString() + ORDERS_ENDPOINT + ORDER_ID_PARAM;
        ResponseEntity<OrderDTO> response = restTemplate.getForEntity(orderUrl, OrderDTO.class, orderId);
        return response.getBody();
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) {
        ServiceInstance orderInstance = getServiceInstance();
        String orderUrl = orderInstance.getUri().toString() + ORDERS_ENDPOINT + ORDER_ID_PARAM;
        HttpEntity<OrderDTO> requestEntity = new HttpEntity<>(orderDTO);
        ResponseEntity<OrderDTO> response = restTemplate.exchange(orderUrl, HttpMethod.PUT, requestEntity, OrderDTO.class, orderDTO.getId());
        return response.getBody();
    }

    public void deleteOrder(Long orderId) {
        ServiceInstance orderInstance = getServiceInstance();
        String orderUrl = orderInstance.getUri().toString() + ORDERS_ENDPOINT + ORDER_ID_PARAM;
        restTemplate.delete(orderUrl, orderId);
    }

    private ServiceInstance getServiceInstance() {
        return discoveryClient.getInstances(ORDER_SERVICE_NAME)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order Service not found"));
    }
}