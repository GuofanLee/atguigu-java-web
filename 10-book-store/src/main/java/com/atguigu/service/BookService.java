package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 19:00
 */
public interface BookService {

    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book getBookById(Integer id);

    Page<Book> pageQuery(int pageNo, int pageSize);

    Page<Book> pageQueryByPrice(int minPrice, int maxPrice, int pageNo, int pageSize);

}
