package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ShoppingCart {

    private int idCart;

    private List<ItemShop> itemShopList = new ArrayList<>();

    public ShoppingCart(List<ItemShop> itemShopList) {
        this.itemShopList = itemShopList;
        idCart++;
    }

    public ShoppingCart() {
    }

    public List<ItemShop> getItemShopList() {
        return itemShopList;
    }

    public void setItemShopList(List<ItemShop> itemShopList) {
        this.itemShopList = itemShopList;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }
}
