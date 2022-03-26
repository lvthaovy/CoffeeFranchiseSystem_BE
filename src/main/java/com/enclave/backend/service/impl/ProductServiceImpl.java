package com.enclave.backend.service.impl;

import com.enclave.backend.converter.ProductConverter;
import com.enclave.backend.dto.ProductDTO;
import com.enclave.backend.entity.Category;
import com.enclave.backend.entity.Product;
import com.enclave.backend.repository.CategoryRepository;
import com.enclave.backend.repository.ProductRepository;
import com.enclave.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public Product createProduct(ProductDTO product) {
        short categoryId = product.getCategoryId();
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + categoryId));

        Product newProduct = productConverter.toEntity(product);
        newProduct.setCategory(category);

        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Product product) {
        short categoryId = product.getCategory().getId();
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + categoryId));

        short productId = product.getId();
        Product oldProduct = productRepository.findById(productId).orElseThrow();
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setImage(product.getImage());
        oldProduct.setCategory(category);

        return productRepository.save(oldProduct);
    }

    //TODO: Pagination
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


}
