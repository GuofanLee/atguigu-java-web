package com.atguigu.pojo;

import java.util.List;
import java.util.Objects;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-13 00:39
 */
public class Page<T> {

    //默认每页数量
    public static final Integer PAGE_SIZE = 4;

    //当前页码
    private Integer pageNo;
    //每页数量
    private Integer pageSize = PAGE_SIZE;
    //总记录数
    private Integer dataCount;
    //总页数
    private Integer pageCount;
    //当前页数据
    private List<T> data;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer dataCount, Integer pageCount, List<T> data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.dataCount = dataCount;
        this.pageCount = pageCount;
        this.data = data;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", dataCount=" + dataCount +
                ", pageCount=" + pageCount +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page<?> page = (Page<?>) o;
        return Objects.equals(pageNo, page.pageNo) &&
                Objects.equals(pageSize, page.pageSize) &&
                Objects.equals(dataCount, page.dataCount) &&
                Objects.equals(pageCount, page.pageCount) &&
                Objects.equals(data, page.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNo, pageSize, dataCount, pageCount, data);
    }

}
