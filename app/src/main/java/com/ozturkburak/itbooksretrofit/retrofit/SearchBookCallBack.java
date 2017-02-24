package com.ozturkburak.itbooksretrofit.retrofit;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import com.ozturkburak.itbooksretrofit.viewLayer.CustomAdapter;
import com.ozturkburak.itbooksretrofit.entity.SearchResponseInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by burak on 2/17/17.
 */

public class SearchBookCallBack
{
    private static Activity ms_activity;
    private static CustomAdapter ms_adapter;
    private static SearchResponseInfo ms_searchResponseInfo;
    private static boolean ms_appendBooks;
    private static ListView ms_listview;


    public static Callback<SearchResponseInfo> set(Activity activity , ListView listView ,CustomAdapter adapter , SearchResponseInfo searchResponseInfo , boolean appendBooks)
    {
        ms_listview = listView;
        ms_activity = activity;
        ms_searchResponseInfo = searchResponseInfo;
        ms_adapter = adapter;
        ms_appendBooks = appendBooks;

        return new CallBack();
    }

    static
    {

    }

    static class CallBack implements Callback<SearchResponseInfo>
    {
        @Override
        public void onResponse(Call<SearchResponseInfo> call, Response<SearchResponseInfo> response)
        {

            if (response.body() == null )
                return;

            ms_searchResponseInfo = response.body();


            if (!ms_appendBooks)
            {
                Toast.makeText(ms_activity , ms_searchResponseInfo.getTotal() + " BOOKS FOUND", Toast.LENGTH_SHORT).show();
                ms_adapter.clear();
            }

            ms_adapter.addBooks(ms_searchResponseInfo.getBooks());



        }

        @Override
        public void onFailure(Call<SearchResponseInfo> call, Throwable t)
        {
            Toast.makeText(ms_activity , t.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }
}