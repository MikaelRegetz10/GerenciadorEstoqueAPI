package com.regetztech.gerenciado_estoque_api.domain.category;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "category")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    public Category(CategoryRequestDTO data){
        this.name = data.name();
        this.description = data.description();
    }

}
