package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 19:01
 */
public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDao.getBookById(id);
    }

    @Override
    public Page<Book> pageQuery(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        //每页数量
        page.setPageSize(pageSize);
        //总记录数
        int dataCount = bookDao.getCount();
        page.setDataCount(dataCount);
        //总页数
        int pageCount = dataCount / pageSize;
        if (dataCount % pageSize != 0) {
            pageCount += 1;
        }
        page.setPageCount(pageCount);
        //当前页码
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageCount) {
            pageNo = pageCount;
        }
        page.setPageNo(pageNo);
        //当前页数据
        List<Book> books = bookDao.pageQuery((pageNo - 1) * pageSize, pageSize);
        page.setData(books);
        return page;
    }

    @Override
    public Page<Book> pageQueryByPrice(int minPrice, int maxPrice, int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        //每页数量
        page.setPageSize(pageSize);
        //总记录数
        int dataCount = bookDao.getCountByPrice(minPrice, maxPrice);
        page.setDataCount(dataCount);
        //总页数
        int pageCount = dataCount / pageSize;
        if (dataCount % pageSize != 0) {
            pageCount += 1;
        }
        page.setPageCount(pageCount);
        //当前页码
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageCount) {
            pageNo = pageCount;
        }
        page.setPageNo(pageNo);
        //当前页数据
        List<Book> books = bookDao.pageQueryByPrice(minPrice, maxPrice, (pageNo - 1) * pageSize, pageSize);
        page.setData(books);
        return page;
    }

}
