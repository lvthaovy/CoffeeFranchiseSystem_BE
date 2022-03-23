package com.enclave.backend.repository;

import com.enclave.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Short> {
    Category findByName(String name);

    Optional<Category> findById(int id);
}
