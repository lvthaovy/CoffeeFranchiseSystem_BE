package com.enclave.backend.service.impl;

import com.enclave.backend.converter.ProductConverter;
import com.enclave.backend.dto.ProductDTO;
import com.enclave.backend.entity.Category;
import com.enclave.backend.entity.Product;
import com.enclave.backend.repository.CategoryRepository;
import com.enclave.backend.repository.ProductRepository;
import com.enclave.backend.service.CategoryService;
import com.enclave.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductConverter productConverter;

    @Override
    public Product createProduct(ProductDTO product) {
        Category category = categoryRepository.findById(product.getCategoryId()).orElseThrow(() -> new IllegalArgumentException("Invalid"));

        Product newProduct = productConverter.toEntity(product);

        newProduct.setName(product.getName());
        newProduct.setImage(product.getImage());
        newProduct.setPrice(product.getPrice());
        newProduct.setCategory(category);
        productRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Product oldProduct = productRepository.findById(product.getId()).orElseThrow();
        short id = product.getCategory().getId();
        Category category = categoryRepository.findById(id).orElseThrow();

        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setImage(product.getImage());
        oldProduct.setCategory(category);
        return productRepository.save(oldProduct);
    }


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
