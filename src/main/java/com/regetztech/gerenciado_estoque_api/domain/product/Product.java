package com.regetztech.gerenciado_estoque_api.domain.product;

import com.regetztech.gerenciado_estoque_api.domain.category.Category;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Product")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double buyPrice;
    private Double sellPrice;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id")
    private Category category;

}
