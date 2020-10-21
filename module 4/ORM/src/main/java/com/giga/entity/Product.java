package com.giga.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private String price;
    @Column(name="category")
    private String category;

    public Product(String id, String name, String price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
