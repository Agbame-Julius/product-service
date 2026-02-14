package com.example.product_service_application.mapper;

import com.example.product_service_application.dto.ProductRequest;
import com.example.product_service_application.dto.ProductResponse;
import com.example.product_service_application.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toResponse(Product product);
    List<ProductResponse> toResponseList(List<Product> product);
    Product toProduct(ProductRequest request);
}
