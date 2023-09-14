package com.example.store.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderProduct> orderProducts;

    @Column(name = "Date")
    private LocalDateTime dateTimeOrder;
    @Column(name = "Status")
    private String status;


    public Order(){
    }

    public Order(Client client, Set<OrderProduct> orderProducts, LocalDateTime dateTimeOrder, String status) {
        this.client = client;
        this.orderProducts = orderProducts;
        this.dateTimeOrder = dateTimeOrder;
        this.status = status;
    }

    // Getters and setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public LocalDateTime getDateTimeOrder() { return dateTimeOrder; }

    public void setDateTimeOrder(LocalDateTime dateTimeOrder) { this.dateTimeOrder = dateTimeOrder;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
