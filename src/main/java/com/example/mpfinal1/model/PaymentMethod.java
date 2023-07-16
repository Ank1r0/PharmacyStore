package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "this attribute cannot be null")
    Integer amount;

    public boolean processPayment()
    {
        return true;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        if(amount < 0)
            return;


        this.amount = amount;
    }

    public abstract float fullAmount();
}
