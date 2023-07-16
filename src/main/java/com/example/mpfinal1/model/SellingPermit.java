package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SellingPermit extends Employee{

    @NotBlank(message = "this attribute cannot be empty")
    private String name;

    @NotBlank(message = "this attribute cannot be empty")
    private String desc;

    @OneToMany(mappedBy = "permit",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Certificate> certificates = new HashSet<>();

    public List<Certificate> getCertificateList() {
        return certificates.stream()
                .sorted(Comparator.comparing(Certificate::getName)).toList();
    }

}
