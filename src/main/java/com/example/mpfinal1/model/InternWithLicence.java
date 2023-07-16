package com.example.mpfinal1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InternWithLicence extends Employee implements IIntern{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "internNumber cannot be empty")
    private String internNumber;

    @NotBlank(message = "InternshipDays cannot be empty")
    private Integer InternshipDays;

    @NotBlank(message = "licenceDuration cannot be empty")
    private LocalDate licenceDuration;


    public String getInternNumber()
    {
        return internNumber;
    }
    public void setInternNumber(String internNumber)
    {
         this.internNumber =internNumber;
    }




}
