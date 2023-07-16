package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActiveSubstance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name attribute cannot be empty")
    private String name;


    @NotBlank(message = "activeGroup attribute cannot be empty")
    private String activeGroup;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product inProduct;

}
