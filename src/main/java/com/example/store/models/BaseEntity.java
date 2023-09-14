package com.example.store.models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    public long getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
