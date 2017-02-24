package com.ozturkburak.itbooksretrofit.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class SearchResponseInfo {

    @SerializedName("Error")
    @Expose
    private String error;
    @SerializedName("Time")
    @Expose
    private Double time;
    @SerializedName("Total")
    @Expose
    private Integer total;
    @SerializedName("Page")
    @Expose
    private Integer page;
    @SerializedName("Books")
    @Expose
    private List<BookInfo> books = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public SearchResponseInfo()
    {
        this.error = "DUMMY";
        this.time = 0.0;
        this.total = 0;
        this.page = 0;
        this.books = new ArrayList<>();
    }

    /**
     *
     * @param total
     * @param books
     * @param time
     * @param error
     * @param page
     */
    public SearchResponseInfo(String error, Double time, Integer total, Integer page, List<BookInfo> books) {
        super();
        this.error = error;
        this.time = time;
        this.total = total;
        this.page = page;
        this.books = books;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public SearchResponseInfo withError(String error) {
        this.error = error;
        return this;
    }

    public Double getTime() {
        return time;
    }
    public void setTime(Double time) {
        this.time = time;
    }

    public SearchResponseInfo withTime(Double time) {
        this.time = time;
        return this;
    }

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

    public SearchResponseInfo withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }

    public SearchResponseInfo withPage(Integer page) {
        this.page = page;
        return this;
    }

    public List<BookInfo> getBooks() {
        return books;
    }

    public void setBooks(List<BookInfo> books) {
        this.books = books;
    }

    public SearchResponseInfo withBooks(List<BookInfo> books) {
        this.books = books;
        return this;
    }
    public int getMaxPage()
    {
        return total/10;
    }

}