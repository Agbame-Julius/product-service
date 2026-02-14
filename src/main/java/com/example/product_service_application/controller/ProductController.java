package com.example.product_service_application.controller;

import com.example.product_service_application.dto.ProductRequest;
import com.example.product_service_application.dto.ProductResponse;
import com.example.product_service_application.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public void createProduct(@RequestBody ProductRequest request){
        service.createProduct(request);
//        return ResponseEntity.ok();
    }

    @GetMapping
    public List<ProductResponse> getProducts(){
        return service.getProducts();
    }
}
