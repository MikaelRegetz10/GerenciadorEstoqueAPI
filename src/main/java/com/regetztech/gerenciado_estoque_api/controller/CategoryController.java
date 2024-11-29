package com.regetztech.gerenciado_estoque_api.controller;

import com.regetztech.gerenciado_estoque_api.domain.category.Category;
import com.regetztech.gerenciado_estoque_api.domain.category.CategoryRepository;
import com.regetztech.gerenciado_estoque_api.domain.category.CategoryRequestDTO;
import com.regetztech.gerenciado_estoque_api.domain.category.CategoryResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public List<CategoryResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(CategoryResponseDTO::new)
                .toList();
    }

    @PostMapping
    public void saveCategory(@RequestBody CategoryRequestDTO data){
        Category categoryData = new Category(data);
        repository.save(categoryData);

        return;
    }
}
