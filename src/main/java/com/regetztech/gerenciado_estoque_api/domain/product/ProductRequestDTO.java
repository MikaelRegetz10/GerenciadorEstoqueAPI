package com.regetztech.gerenciado_estoque_api.domain.product;


public record ProductRequestDTO(String name, String description, Double buyPrice, Double sellPrice) {

}
