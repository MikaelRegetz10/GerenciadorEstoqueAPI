package com.regetztech.gerenciado_estoque_api.service;


import com.regetztech.gerenciado_estoque_api.domain.category.Category;
import com.regetztech.gerenciado_estoque_api.domain.category.CategoryRepository;
import com.regetztech.gerenciado_estoque_api.domain.category.CategoryRequestDTO;
import com.regetztech.gerenciado_estoque_api.domain.product.Product;
import com.regetztech.gerenciado_estoque_api.domain.product.ProductRepository;
import com.regetztech.gerenciado_estoque_api.domain.product.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    public Product createProduct(ProductRequestDTO data, CategoryRequestDTO dataCategory){
        Category category = categoryRepository.findByName(dataCategory.name());

        if (category == null){
            category = categoryService.createCategory(dataCategory);
        }


        Product newProduct = new Product();
        newProduct.setName(data.name());
        newProduct.setDescription(data.description());
        newProduct.setBuyPrice(data.buyPrice());
        newProduct.setSellPrice(data.sellPrice());

        newProduct.setCategory(category);

        productRepository.save(newProduct);

        return newProduct;
    }

}
