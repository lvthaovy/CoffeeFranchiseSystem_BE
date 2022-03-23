package com.enclave.backend.service;

import com.enclave.backend.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(String name);

    Category updateCategory(short id, String name);

    List<Category> getCategories();
}
