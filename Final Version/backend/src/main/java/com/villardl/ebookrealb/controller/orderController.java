package com.villardl.ebookrealb.controller;
import com.villardl.ebookrealb.entity.Order;
import com.villardl.ebookrealb.repository.OrderDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class orderController {
        @Autowired
        OrderDao orderDao;
        @RequestMapping(value = "/morder")
        @ResponseBody
        public List<Order> passOrder() {
            List<Order> order1 = orderDao.findAll();
            return order1;
        }

    @RequestMapping(value = "/uorder")
    @ResponseBody
    public List<Order> uOrder(@RequestBody JSONObject uord){
        String oname =uord.getString("buser");
        List<Order>uorders=orderDao.findByOuser(oname);
        return uorders;
    }
    }
