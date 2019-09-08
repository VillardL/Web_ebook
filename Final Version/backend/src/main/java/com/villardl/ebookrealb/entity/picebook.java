package com.villardl.ebookrealb.entity;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document
public class picebook {
    @Id
    private String isbn;
    private String name; // 文件名
    private Binary content;
//    private Date createdTime; // 上传时间
//    private Binary content; // 文件内容
//    private String contentType; // 文件类型
//    private long size; // 文件大小
    public String getName() {
        return name;
    }

    public Binary getContent() {
        return content;
    }

    public void setContent(Binary content) {
        this.content = content;
    }
    //    public Date getCreatedTime() {
//        return createdTime;
//    }
//    public String getContentType() {
//        return contentType;
//    }
//    public Binary getContent() {
//        return content;
//    }
//    public long getSize() {
//        return size;
//    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
//    public void setContent(Binary content) {
//        this.content = content;
//    }
//    public void setContentType(String contentType) {
//        this.contentType = contentType;
//    }
//    public void setCreatedTime(Date createdTime) {
//        this.createdTime = createdTime;
//    }
    public void setName(String name) {
        this.name = name;
    }
//    public void setSize(long size) {
//        this.size = size;
//    }
}
