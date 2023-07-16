package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name attribute is mandatory")
    private String name;

    @NotBlank(message = "address attribute is mandatory")
    private String address;

    @NotBlank(message = "This attribute is mandatory")
    @OneToMany(mappedBy = "worksIn",fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "managesIn",fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Employee> managers = new HashSet<>();

    @OneToMany(mappedBy = "orStore",fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Order2> orders = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouze;


}
