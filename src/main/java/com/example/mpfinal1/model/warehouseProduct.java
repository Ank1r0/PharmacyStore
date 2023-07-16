package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = {"warehouse_id","product_id"})
        })
public class warehouseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "warehouse_id",nullable = false)
    @NotNull
    private Warehouse warehouse;


    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    @NotNull
    private Product product;

    @NotNull
    private LocalDate availableFrom;
}
