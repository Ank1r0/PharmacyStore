package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name attribute is mandatory")
    private String name;

    @NotBlank(message = "expirationDate attribute is mandatory")
    private LocalDate expirationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "permit_id",nullable = false,updatable = false)
    private SellingPermit permit;
}
