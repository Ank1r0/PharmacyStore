package com.example.mpfinal1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "cannot be empty")
    @Size(min = 2, max = 20)
    @Column(name = "ORDERCODE", unique = true)
    private String orderCode;

    @NotBlank(message = "cannot be empty")
    private LocalDate orderTime;

    @NotBlank(message = "cannot be empty")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "in_store_id")
    private Store orStore;


    @OneToMany(mappedBy = "inOrderPO")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Product> product = new HashSet<>();

    //XOR
    @OneToOne
    @JoinColumn(name = "PayPalPayment_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private PayPalPayment payPalPayment;


    @OneToOne
    @JoinColumn(name = "card_payment_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private CardPayment cardPayment;

    public void setCardPayment(CardPayment cardPayment)
    {
        if(cardPayment == null || this.cardPayment == cardPayment || payPalPayment != null) return;

        this.cardPayment = cardPayment;
    }

    public void setCardPayment(PayPalPayment payPalPayment)
    {
        if(payPalPayment == null ||this.payPalPayment == payPalPayment || cardPayment != null) return;

        this.payPalPayment = payPalPayment;
    }
}

