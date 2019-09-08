package com.villardl.ebookrealb.repository;

import com.villardl.ebookrealb.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
    public List<Order> findByOuser(String ouser);

}
