package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "this attribute is mandatory")
    private String name;

    @Max(100)
    @Min(0)
    private Integer discount;

    @ElementCollection
    @CollectionTable(name = "drug_group", joinColumns = @JoinColumn(name = "product_id"))
    @Builder.Default
    private java.util.List<String> drugGroups = new ArrayList<>();

    private static java.util.List<String> addictionTypeList = new ArrayList<>();

    private String addiction;

    @NotBlank(message = "price attribute is mandatory")
    @Setter(AccessLevel.NONE)
    private Integer price;

    @NotBlank(message = "miligram attribute is mandatory")
    private Integer miligram;



    public void setPrice(Integer price) {
        double newPperM = (double) price /miligram;

        if(newPperM < 10.0) {
            return;
        }

        this.price = price;
    }

    public Double getPricePerMiligram() {
        return (double) (price/miligram);
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<warehouseProduct> warehouseProduct;

    @OneToOne(mappedBy = "inProduct")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ActiveSubstance activeSubstances;

    @ManyToOne
    @JoinColumn(name = "order2_id")
    private Order2 inOrderPO;

}
