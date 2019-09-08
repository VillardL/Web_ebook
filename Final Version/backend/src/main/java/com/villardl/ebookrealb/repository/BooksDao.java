package com.villardl.ebookrealb.repository;
import com.villardl.ebookrealb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BooksDao extends JpaRepository<Book, Long> {
    public Book findByBookid(Integer bookid);
    public Book findByBookname(String bookname);
}
