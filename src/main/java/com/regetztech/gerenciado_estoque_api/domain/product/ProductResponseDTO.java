package com.regetztech.gerenciado_estoque_api.domain.product;


import com.regetztech.gerenciado_estoque_api.domain.category.Category;

public record ProductResponseDTO(Long id, String name, String description, Double buy_price, Double sell_price, Category category) {

    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getDescription(), product.getBuyPrice(), product.getSellPrice(), product.getCategory());
    }
}
