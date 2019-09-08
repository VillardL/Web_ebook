package com.villardl.ebookrealb.controller;

import com.villardl.ebookrealb.entity.User;
import com.villardl.ebookrealb.repository.UserDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/userm")
public class usermController {
    @Autowired
    UserDao auser;
    @RequestMapping("/showuser")
    @ResponseBody
    public List<User> passUser(){
        List<User> user1=auser.findByType(0);
        return user1;
    }

    @RequestMapping("/forbuser")
    @ResponseBody
    public String manauser(@RequestBody JSONObject itemname){
        System.out.println(itemname);
        String namefo=(String)itemname.get("name");
        User user1=auser.findByName(namefo);
        user1.setAlive(0);
        auser.save(user1);
        return "okk";
    }

    @RequestMapping("/releuser")
    @ResponseBody
    public String meneuser(@RequestBody JSONObject itemneme){
        String namere=(String)itemneme.get("name");
        User user1=auser.findByName(namere);
        user1.setAlive(1);
        auser.save(user1);
        return "okk";
    }

}
