package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name attribute is mandatory")
    private String name;

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<warehouseProduct> warehouseProduct;

    @OneToOne(mappedBy = "warehouze")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Store store;

}
