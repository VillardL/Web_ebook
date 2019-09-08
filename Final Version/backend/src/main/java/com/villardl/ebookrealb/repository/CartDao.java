package com.villardl.ebookrealb.repository;

import com.villardl.ebookrealb.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartDao extends JpaRepository<Cart, Long> {
    public List<Cart>findByBusername(String busername);
}

