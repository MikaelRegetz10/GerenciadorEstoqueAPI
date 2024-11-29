package com.regetztech.gerenciado_estoque_api.service;


import com.regetztech.gerenciado_estoque_api.domain.category.Category;
import com.regetztech.gerenciado_estoque_api.domain.category.CategoryRepository;
import com.regetztech.gerenciado_estoque_api.domain.category.CategoryRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(CategoryRequestDTO data){
        Category newCategory = new Category();
        newCategory.setName(data.name());
        newCategory.setDescription(data.description());
        categoryRepository.save(newCategory);

        return newCategory;
    }
}
