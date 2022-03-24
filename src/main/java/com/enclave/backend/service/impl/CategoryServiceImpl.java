package com.enclave.backend.service.impl;

import com.enclave.backend.entity.Category;
import com.enclave.backend.repository.CategoryRepository;
import com.enclave.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(short id, String name) {
        Category oldCategory = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + id));
        oldCategory.setName(name);
        return categoryRepository.save(oldCategory);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

}
