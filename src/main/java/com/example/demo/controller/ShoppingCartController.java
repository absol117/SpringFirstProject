package com.example.demo.controller;

import com.example.demo.model.ItemShop;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ShoppingCartController {

    private final CartService cartService;

    @Autowired
    public ShoppingCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public String add(ItemShop itemShop) {
        cartService.add(itemShop);
        return "add1";
    }


    @GetMapping("/read")
    public String readAll(Model model) {
        List<ItemShop> items = cartService.readAll();
        model.addAttribute("items", items);
        return "read1";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        cartService.delete(id);
        return "read1";
    }

    @PostMapping("/fix")
    public String fixItemName(@RequestParam int id, @RequestParam String newName) {
        cartService.fix(id, newName);
        return "add1";
    }



}

