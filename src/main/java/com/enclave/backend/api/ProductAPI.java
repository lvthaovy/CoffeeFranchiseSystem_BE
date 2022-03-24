package com.enclave.backend.api;

import com.enclave.backend.dto.ProductDTO;
import com.enclave.backend.entity.Product;
import com.enclave.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPI {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public Product createProduct(@RequestBody ProductDTO dto) {
        Product product = productService.createProduct(dto);
        return product;
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product product) {
        System.out.println(product.getCategory().getId());
        return productService.updateProduct(product);
    }

//    @PutMapping("/product/{id}")
//    public Product updateProduct( @RequestBody ProductDTO product) {
//        System.out.println(product.getCategoryId());
//        return productService.updateProduct(product);
//    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
