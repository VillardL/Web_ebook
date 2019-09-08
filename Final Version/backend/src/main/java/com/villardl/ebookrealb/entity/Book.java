package com.villardl.ebookrealb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Year;

@Table(name="booklist")
@Entity

public class Book {
    @Id

    private Integer bookid;
    private String bookname;
    private Integer price;
    private Integer stocknum;
    private String pic;
    private String author;
    private String isbn;
    private String describes;
    public void Book(){
    }
    public Integer getBookid(){ return bookid;}
    public String getBookname(){return bookname;}
    public String getAuthor(){return author;}
    public Integer getPrice(){return price;}
    public String getPic(){return pic;}
    public Integer getStocknum(){return stocknum;}
    public String getIsbn(){return isbn;}
    public String getDescribes(){return describes;}
    public void setBookid(Integer bookid){this.bookid=bookid;}
    public void setBookname(String bookname){this.bookname=bookname;}
    public void setAuthor(String author){this.author=author;}
    public void setPrice(Integer price){this.price=price;}
    public void setPic(String pic){this.pic=pic;}
    public void setStocknum(Integer stocknum){this.stocknum=stocknum;}
    public void setIsbn(String isbn){this.isbn=isbn;}
    public void setDescribes(String describes){this.describes=describes;}
}
