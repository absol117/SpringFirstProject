package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ItemShop {

    private String name;
    @Id
    private int id;
    private float price;

    public ItemShop(String name, int id, float price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public ItemShop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }



    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}
