package com.regetztech.gerenciado_estoque_api.controller;

import com.regetztech.gerenciado_estoque_api.domain.category.CategoryRequestDTO;
import com.regetztech.gerenciado_estoque_api.domain.product.Product;
import com.regetztech.gerenciado_estoque_api.domain.product.ProductRepository;
import com.regetztech.gerenciado_estoque_api.domain.product.ProductRequestDTO;
import com.regetztech.gerenciado_estoque_api.domain.product.ProductResponseDTO;
import com.regetztech.gerenciado_estoque_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Product> addProduct(@RequestParam("name_product") String nameProduct,
                                              @RequestParam("description") String description,
                                              @RequestParam("buy_price") Double buyPrice,
                                              @RequestParam("sell_price") Double sellPrice,
                                              @RequestParam("category_name") String categoryName,
                                              @RequestParam("description_category") String descriptionCategory) {

        ProductRequestDTO productRequestDTO = new ProductRequestDTO(nameProduct, description, buyPrice, sellPrice);
        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO(categoryName, descriptionCategory);

        Product newProduct = this.productService.createProduct(productRequestDTO, categoryRequestDTO);

        return ResponseEntity.ok(newProduct);
    }


    @GetMapping
    public List<ProductResponseDTO> getAll(){

        List<ProductResponseDTO> productsList = repository.findAll()
                                                            .stream()
                                                            .map(ProductResponseDTO::new)
                                                            .toList();

        return productsList;
    }
}
