package com.enclave.backend.api;

import com.enclave.backend.entity.Category;
import com.enclave.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category.getName());
    }

    @PutMapping("/{id}")
    public Category editCategory(@PathVariable("id") short id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category.getName());
    }
}
