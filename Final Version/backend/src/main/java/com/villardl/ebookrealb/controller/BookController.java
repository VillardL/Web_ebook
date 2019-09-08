package com.villardl.ebookrealb.controller;

import com.villardl.ebookrealb.entity.Book;
import com.villardl.ebookrealb.repository.BooksDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BooksDao abook;

    @RequestMapping(value = "/showbook")
    @ResponseBody
   public List<Book> passBook(){
        List<Book> book1=abook.findAll();
        return book1;
    }

    @RequestMapping(value = "/addb")
    @ResponseBody
    public String addBook(@RequestBody JSONObject book) {
        System.out.println(book);
        Integer bookid=book.getInt("id");
        String bookname = (String) book.get("bookname");
        Integer price = (Integer) book.getInt("price");
        Integer stocknum = (Integer) book.getInt("stocknum");
        String pic = (String) book.get("pic");
        String author = (String) book.get("author");
        String isbn = (String) book.get("isbn");
        String describes = (String) book.get("describes");
        Book bookab=new Book();
        bookab=abook.findByBookid(bookid);
        if(bookab!=null){return "has";}
        else{
            System.out.println(bookid);
            Book bookadd=new Book();
            bookadd.setBookid(bookid);
            bookadd.setAuthor(author);
            bookadd.setBookname(bookname);
            bookadd.setPrice(price);
            bookadd.setStocknum(stocknum);
            bookadd.setIsbn(isbn);
            bookadd.setPic(pic);
            bookadd.setDescribes(describes);
            System.out.println(bookadd);
            abook.save(bookadd);
            return "ok";}
    }

    @RequestMapping(value = "/delebook")
    @ResponseBody
    public String deleb(@RequestBody JSONObject deleid){
        Integer dbookid=(Integer)deleid.getInt("bookid");
        Book dbook=abook.findByBookid(dbookid);
        System.out.println(dbook.getBookname());
        abook.delete(dbook);
        return "ok";
    }
//        System.out.println(user1.getName());
        //User user;
        //  user.setName(user1.getName());
        //
}
