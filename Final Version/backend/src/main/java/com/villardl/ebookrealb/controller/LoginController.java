package com.villardl.ebookrealb.controller;

import com.villardl.ebookrealb.entity.User;
import com.villardl.ebookrealb.repository.UserDao;
import com.villardl.ebookrealb.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    UserDao userDao;
    @Autowired
    private UserService userService;

    @RequestMapping("/adduser")
    @ResponseBody
    public String addUser(@RequestBody JSONObject user) {
        String name = (String) user.get("name");
        String email = (String) user.get("email");
        String password = (String) user.get("password");
        User user1 = new User();
        user1=userDao.findByName(name);
        if(user1!=null){return "has";}
        else{
            user1.setName(name);
            user1.setType(1);
            user1.setPassword(password);
            user1.setAlive(1);
            user1.setEmail(email);
            userDao.save(user1);
            return "ok";
        }
//        System.out.println(user1.getName());
            //User user;
            //  user.setName(user1.getName());
            //
    }

    @RequestMapping("/login")
    @ResponseBody
    public String loguser(@RequestBody JSONObject user1og){
        User user1=new User();
        String namelo=(String)user1og.get("name");
        String passwordlo=(String)user1og.get("password");
        user1=userDao.findByName(namelo);
        if(user1==null){return "no";}
        else{
            user1=userDao.findByNameAndPassword(namelo,passwordlo);
            if(user1==null){
                return "wrong";
            }
            else if(user1.getType()==1){ return "admin";}
            else if(user1.getAlive()==0){return "forbid";}
            else
                return "login";}
    }
}
