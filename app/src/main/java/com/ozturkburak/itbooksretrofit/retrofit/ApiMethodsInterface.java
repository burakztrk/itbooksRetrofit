package com.ozturkburak.itbooksretrofit.retrofit;


import com.ozturkburak.itbooksretrofit.entity.BookInfo;
import com.ozturkburak.itbooksretrofit.entity.SearchResponseInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by burak on 2/10/17.
 */

public interface ApiMethodsInterface
{
    @GET("search/{searchText}/page/{pageNum}")
    Call<SearchResponseInfo> getSearchBooksDetails(@Path("searchText") String searchText, @Path("pageNum") int pageNum);

    @GET("search/{searchText}")
    Call<SearchResponseInfo> getSearchBooksDetails(@Path("searchText")  String searchText);

    @GET("book/{id}")
    Call<BookInfo> getBookDetails(@Path("id") String bookID);
}