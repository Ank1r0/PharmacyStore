package com.example.mpfinal1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CardPayment extends PaymentMethod{

    @NotBlank(message = "cardNumber attribute is mandatory")
    private String cardNumber;

    @NotBlank(message = "cardHolder attribute is mandatory")
    private String cardHolder;

    @NotBlank(message = "expirationDate attribute is mandatory")
    private LocalDate expirationDate;

    @Override

    public float fullAmount() {
        return amount+((float) (amount * 3) /100);
    }

    @OneToOne(mappedBy = "cardPayment")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Order2 order;
}
