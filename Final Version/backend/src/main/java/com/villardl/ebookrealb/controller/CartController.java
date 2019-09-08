package com.villardl.ebookrealb.controller;

import com.villardl.ebookrealb.entity.ma;
import com.villardl.ebookrealb.entity.Cart;
import com.villardl.ebookrealb.repository.BooksDao;
import com.villardl.ebookrealb.repository.CartDao;
import net.sf.json.JSONObject;
import org.apache.commons.collections.FastArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cartm")
public class CartController {
    @Autowired
    CartDao cartDao;

    @RequestMapping("/addcart")
    @ResponseBody
    public String addcbook(@RequestBody JSONObject varc) {
        System.out.println(varc);
       String busername =varc.getString("busername");
       String bookname = varc.getString("bookname");
       Integer price = varc.getInt("price");
        System.out.println(busername);
       Cart cart1=new Cart();
       String ubname=busername+bookname;
       cart1.setUbname(ubname);
        cart1.setBusername(busername);
        cart1.setBprice(price);
        cart1.setBbookname(bookname);
        cart1.setBnum(1);
        System.out.println(cart1.getBnum());
        cartDao.save(cart1);
            return "ok";
        }

    @RequestMapping("/showcart")
    @ResponseBody
    public List<ma> passcart(@RequestBody JSONObject tam){
        String cusername =tam.getString("cuser");
        List<Cart> ucarts=cartDao.findByBusername(cusername);
        List<ma> list = new ArrayList();
        for(Cart cart : ucarts){
            ma temp = new ma();
            temp.aname = cart.getBbookname();
            temp.aprice = cart.getBprice();
            temp.anum = cart.getBnum();
            list.add(temp);
        }
            return list;
    }

    @RequestMapping("/buyall")
    @ResponseBody
    public String bought(@RequestBody JSONObject bam){
        String cusername =bam.getString("buser");
        return "okk";
    }
    }
