package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.EnumSet;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Setter(AccessLevel.NONE)
    @Column(nullable = false)
    private EnumSet<EmployeeType> types;

    @NotBlank(message = "firstName attribute is mandatory")
    private String firstName;

    @NotBlank(message = "lastName attribute is mandatory")
    private String lastName;

    @Min(10)
    @Max(100000)
    private Integer salary;
    //-- intern only
    private String internNumber;

    //-- just pharma
    private Integer yearsInCompany;

    private Integer yearsOfExperience;



    public void setInternNumber(String internNumber)
    {
        if(types.contains(EmployeeType.PHARMACIST) || this.internNumber == internNumber || internNumber == null) return;

        this.internNumber = internNumber;
    }

    public void setYearsInCompany(Integer yearsInCompany)
    {
        if(types.contains(EmployeeType.INTERN) || this.yearsInCompany == yearsInCompany || yearsInCompany == null) return;

        this.yearsInCompany = yearsInCompany;
    }

    public void setYearsOfExperience(Integer yearsOfExperience)
    {
        if(types.contains(EmployeeType.INTERN) || this.yearsOfExperience == yearsOfExperience || yearsOfExperience == null) return;

        this.yearsOfExperience = yearsOfExperience;
    }

    public void addType(EmployeeType type) throws Exception {
        if(type == null) throw new Exception("not legal argument");
        if(types.contains(type)) throw new Exception("already contains");

        types.add(type);
    }

    public void removeType(EmployeeType type) throws Exception {
        if(type == null) throw new Exception("not legal argument");
        if(!types.contains(type)) throw new Exception("not contains");
        if(types.size() == 1) throw new Exception("List will be empty");

        types.remove(type);
    }


    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store worksIn;

    @ManyToOne
    @JoinColumn(name = "manager_store_id")
    private Store managesIn;


}
