package com.atguigu.dao;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 18:47
 */
public class BookDaoTest {

    private final BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"国哥为什么这么帅！", "191125", new BigDecimal(1),2,3,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(25);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22,"Java从入门到秃顶", "帆哥", new BigDecimal(10),5,1,null));
    }

    @Test
    public void getBookById() {
        Book book = bookDao.getBookById(22);
        System.out.println(book);
    }

    @Test
    public void getCount() {
        int count = bookDao.getCount();
        System.out.println(count);
    }

    @Test
    public void pageQuery() {
        List<Book> books = bookDao.pageQuery(0, 4);
        books.forEach(System.out::println);
    }

    @Test
    public void getCountByPrice() {
        int count = bookDao.getCountByPrice(10, 50);
        System.out.println(count);
    }

    @Test
    public void pageQueryByPrice() {
        List<Book> books = bookDao.pageQueryByPrice(10, 50, 0, 4);
        books.forEach(System.out::println);
    }
}