package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

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
    public void getBookById() {
        Book book = bookService.getBookById(26);
        System.out.println(book);
    }

    @Test
    public void pageQuery() {
        Page<Book> bookPage = bookService.pageQuery(1, Page.PAGE_SIZE);
        System.out.println(bookPage);
    }

    @Test
    public void pageQueryByPrice() {
        Page<Book> bookPage = bookService.pageQueryByPrice(10, 50, 1, Page.PAGE_SIZE);
        System.out.println(bookPage);
    }

}