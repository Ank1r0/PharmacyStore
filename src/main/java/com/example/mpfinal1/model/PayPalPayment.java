package com.example.mpfinal1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PayPalPayment extends PaymentMethod{


    @Override
    public float fullAmount() {
        return amount+((float) (amount * 8) /100);
    }

    @NotBlank(message = "this attribute cannot be null")
    private String email;

    @OneToOne(mappedBy = "payPalPayment")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Order2 order;
}
