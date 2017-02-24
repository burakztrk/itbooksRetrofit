package com.ozturkburak.itbooksretrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by burak on 2/10/17.
 */

public class ApiClient
{

    public static final String BASE_URL ="http://it-ebooks-api.info/v1/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient ()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
