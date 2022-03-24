package com.enclave.backend.repository;

import com.enclave.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Short> {
    Optional<Product> findById(Short id);
}
