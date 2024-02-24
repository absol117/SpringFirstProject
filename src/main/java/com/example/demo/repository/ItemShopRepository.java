package com.example.demo.repository;

import com.example.demo.model.ItemShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemShopRepository extends JpaRepository<ItemShop, Integer> {

}

