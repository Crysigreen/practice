package com.example.store.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

@Entity
@Table(name = "clients")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client extends BaseEntity {

    @OneToMany(mappedBy = "client",targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;

    protected Client() {
    }

    public Client(String name,String surname, String email, Set<Order> orders) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.orders = orders;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname=surname; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


}
