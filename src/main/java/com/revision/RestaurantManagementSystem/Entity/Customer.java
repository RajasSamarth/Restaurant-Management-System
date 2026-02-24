package com.revision.RestaurantManagementSystem.Entity;


import jakarta.persistence.*;
import org.springframework.transaction.reactive.GenericReactiveTransaction;

@Entity
@Table(name="Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Long phone;

    private String email;

    @OneToOne(mappedBy = "customer")
    private LoyaltyCard loyaltyCard;

    public Customer() {
    }

    public Customer(String name, Long phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
