package com.example.product_service_application.service;

import com.example.product_service_application.dto.ProductRequest;
import com.example.product_service_application.dto.ProductResponse;
import com.example.product_service_application.mapper.ProductMapper;
import com.example.product_service_application.model.Product;
import com.example.product_service_application.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;


    public void createProduct(ProductRequest productRequest){
//        var product = mapper.toProduct(productRequest);
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        repository.insert(product);
        log.info("Product save successfully");

    }

    public void updateProduct(String id){
//        Optional<Product> product = Optional.of(repository.findById(id).orElse())

    }

    public List<ProductResponse> getProducts(){
        List<Product> products = repository.findAll();
        //mapping the products to the product response
      return  mapper.toResponseList(products);
    }
//
//    //helper method to map product to product response
//    private ProductResponse mapToProductREsponse(Product product) {
//        return ProductResponse.builder()
//                .id(product.getId())
//                .name(product.getName())
//                .description(product.getDescription())
//                .price(product.getPrice())
//                .build();
//    }
}
