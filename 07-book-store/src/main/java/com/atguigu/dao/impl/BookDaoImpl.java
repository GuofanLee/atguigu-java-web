package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 18:32
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name, author, price, sales, stock, img_path) values(?, ?, ?, ?, ?, ?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?, author = ?, price = ?, sales = ?, stock = ?, img_path = ? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book getBookById(Integer id) {
        String sql = "select id, name, author, price, sales, stock, img_path imgPath from t_book where id = ?";
        return queryForOne(sql, id);
    }

    @Override
    public int getCount() {
        String sql = "select count(*) from t_book";
        Number count = queryForValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> pageQuery(int begin, int pageSize) {
        String sql = "select id, name, author, price, sales, stock, img_path imgPath from t_book limit ?, ?";
        return queryForList(sql, begin, pageSize);
    }

    @Override
    public int getCountByPrice(int minPrice, int maxPrice) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = queryForValue(sql, minPrice, maxPrice);
        return count.intValue();
    }

    @Override
    public List<Book> pageQueryByPrice(int minPrice, int maxPrice, int begin, int pageSize) {
        String sql = "select id, name, author, price, sales, stock, img_path imgPath from t_book " +
                     "where price between ? and ? order by price asc limit ?, ?";
        return queryForList(sql, minPrice, maxPrice, begin, pageSize);
    }

}
