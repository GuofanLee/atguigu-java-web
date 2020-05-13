package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 18:31
 */
public interface BookDao {

    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book getBookById(Integer id);

    int getCount();

    List<Book> pageQuery(int begin, int pageSize);

    int getCountByPrice(int minPrice, int maxPrice);

    List<Book> pageQueryByPrice(int minPrice, int maxPrice, int begin, int pageSize);

}
