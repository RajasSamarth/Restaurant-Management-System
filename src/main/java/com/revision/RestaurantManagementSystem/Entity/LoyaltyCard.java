package com.revision.RestaurantManagementSystem.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class LoyaltyCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String cardNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expiryDate;

    @OneToOne
    @JoinColumn(name = "customer_Id", nullable = false)
    private Customer customer;

    public LoyaltyCard(String cardNumber, LocalDate expiryDate, Customer customer) {

        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LoyaltyCard() {
    }
}
