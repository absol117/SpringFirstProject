package com.example.demo.service;

import com.example.demo.model.ItemShop;
import com.example.demo.model.ShoppingCart;
import com.example.demo.repository.ItemShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartService {
    private final ItemShopRepository itemShopRepository;
    private final ShoppingCart shoppingCart;

    @Autowired
    public CartService(ItemShopRepository itemShopRepository, ShoppingCart shoppingCart) {
        this.itemShopRepository = itemShopRepository;
        this.shoppingCart = shoppingCart;
    }


    public ItemShop add(ItemShop itemShop) {
        shoppingCart.getItemShopList().add(itemShop);
        return itemShopRepository.save(itemShop);
    }

    public List<ItemShop> readAll() {
        //return new ArrayList<>(shoppingCart.getItemShopList());
        return itemShopRepository.findAll();
    }

    public Optional<ItemShop> delete(int id) {
        Optional<ItemShop> first = shoppingCart.getItemShopList()
                .stream()
                .filter(itemShop -> itemShop.getId() == id).
                findFirst();

        itemShopRepository.deleteById(id);

        return first;
    }

    public Optional<ItemShop> fix(int id, String newName) {
        shoppingCart.getItemShopList()
                .stream()
                .filter(itemShop -> itemShop.getId() == id)
                .findFirst()
                .ifPresent(itemShop -> itemShop.setId(id));

        Optional<ItemShop> byId = itemShopRepository.findById(id);

        int id1 = byId.get().getId();
        float price = byId.get().getPrice();

        itemShopRepository.deleteById(id);
        itemShopRepository.save(new ItemShop(newName, id1, price));

        return byId;
    }

}




