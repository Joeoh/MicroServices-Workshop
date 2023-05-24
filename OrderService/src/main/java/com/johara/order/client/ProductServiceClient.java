package com.johara.order.client;

import com.johara.order.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {
    private static final String PRODUCT_SERVICE_NAME = "product-service";
    private static final String PRODUCTS_ENDPOINT = "/products";
    private static final String PRODUCT_ID_PARAM = "/{id}";

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductServiceClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = new RestTemplate();
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        ServiceInstance productInstance = getServiceInstance();
        String productUrl = productInstance.getUri().toString() + PRODUCTS_ENDPOINT;
        ResponseEntity<ProductDTO> response = restTemplate.postForEntity(productUrl, productDTO, ProductDTO.class);
        return response.getBody();
    }

    public ProductDTO getProductById(Long productId) {
        ServiceInstance productInstance = getServiceInstance();
        String productUrl = productInstance.getUri().toString() + PRODUCTS_ENDPOINT + PRODUCT_ID_PARAM;
        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(productUrl, ProductDTO.class, productId);
        return response.getBody();
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        ServiceInstance productInstance = getServiceInstance();
        String productUrl = productInstance.getUri().toString() + PRODUCTS_ENDPOINT + PRODUCT_ID_PARAM;
        HttpEntity<ProductDTO> requestEntity = new HttpEntity<>(productDTO);
        ResponseEntity<ProductDTO> response = restTemplate.exchange(productUrl, HttpMethod.PUT, requestEntity, ProductDTO.class, productDTO.getId());
        return response.getBody();
    }

    public void deleteProduct(Long productId) {
        ServiceInstance productInstance = getServiceInstance();
        String productUrl = productInstance.getUri().toString() + PRODUCTS_ENDPOINT + PRODUCT_ID_PARAM;
        restTemplate.delete(productUrl, productId);
    }

    private ServiceInstance getServiceInstance() {
        return discoveryClient.getInstances(PRODUCT_SERVICE_NAME)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product Service not found"));
    }
}
