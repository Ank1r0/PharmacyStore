package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ChemistLicences {


    @NotBlank(message = "desc cannot be null")
    private String desc;

    @OneToMany(mappedBy = "pack")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Licence> licence = new HashSet<>();



    @NotNull(message = "Licence comparator should be specified")
    private static Comparator<Licence> licenceComparator = Comparator.comparing(Licence::getName);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public List<Licence> getListLicences(){
        return licence.stream().sorted(licenceComparator).toList();
    }

}
