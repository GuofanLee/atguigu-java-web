package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 19:11
 */
public class BookServiceTest {

    private final BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国哥为什么这么帅！", "191125", new BigDecimal(1),2,3,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(26);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(26,"Java从入门到秃顶", "帆哥", new BigDecimal(10),5,1,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(26);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        books.forEach(System.out::println);
    }

}