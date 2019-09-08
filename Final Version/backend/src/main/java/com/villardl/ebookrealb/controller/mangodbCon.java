package com.villardl.ebookrealb.controller;

import com.villardl.ebookrealb.entity.picebook;
import com.villardl.ebookrealb.repository.UploadFileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@Controller
public class mangodbCon {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/showpic", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public String image() {
        String data = null;
        picebook file = mongoTemplate.findById("5d1aeafb96df2a3c507017cf", picebook.class);
        if (file != null) {
            data = file.getName();
            return data;
        }
//        picebook file = uploadFileDao.findByIsbn(1234566);
//        System.out.println(file);
//        String pic1= file.getName();
//
//        return pic1;
//
//    }
        else return "okk";
    }
}
