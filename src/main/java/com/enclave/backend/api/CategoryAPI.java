package com.enclave.backend.api;

import com.enclave.backend.entity.Category;
import com.enclave.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryAPI {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category.getName());
    }

    @PutMapping("/category/{id}")
    public Category editCategory(@PathVariable("id") short id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category.getName());
    }
}
