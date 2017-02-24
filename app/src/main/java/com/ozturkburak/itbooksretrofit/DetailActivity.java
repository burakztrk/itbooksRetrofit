package com.ozturkburak.itbooksretrofit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ozturkburak.itbooksretrofit.entity.BookInfo;
import com.ozturkburak.itbooksretrofit.entity.SearchResponseInfo;
import com.ozturkburak.itbooksretrofit.retrofit.ApiClient;
import com.ozturkburak.itbooksretrofit.retrofit.ApiMethodsInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends Activity
{
    private ImageView m_imageView_cover;
    private TextView m_textView_title , m_textView_desc;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.init();
    }


    private void gatherViews()
    {
        m_imageView_cover = (ImageView) this.findViewById(R.id.DETAILACTIVITY_IMAGE_COVER);
        m_textView_title = (TextView) this.findViewById(R.id.DETAILACTIVITY_TEXTVIEW_TITLE);
        m_textView_desc = (TextView) this.findViewById(R.id.DETAILACTIVITY_TEXTVIEW_DESC);
    }


    public void init()
    {
        this.gatherViews();

        Intent intent = this.getIntent();
        final BookInfo bookInfo = (BookInfo) intent.getSerializableExtra("BOOKINFO");

        m_textView_title.setText( bookInfo.getTitle() );
        m_textView_desc.setText( bookInfo.getDescription() );
        Picasso.with(this).load(bookInfo.getImage()).into(m_imageView_cover);

        ApiMethodsInterface apiMethods = ApiClient.getClient().create(ApiMethodsInterface.class);
        Call<BookInfo> call = apiMethods.getBookDetails(bookInfo.getID());
        call.enqueue(new Callback<BookInfo>()
        {
            @Override
            public void onResponse(Call<BookInfo> call, Response<BookInfo> response)
            {
                BookInfo responseBookInfo = response.body();

                if (responseBookInfo.getID() == null)
                {
                    Toast.makeText(DetailActivity.this, "UPPSS!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                m_textView_title.setText(responseBookInfo.getTitle());
                m_textView_desc.setText(responseBookInfo.getDescription());

            }

            @Override
            public void onFailure(Call<BookInfo> call, Throwable t)
            {
                Toast.makeText(DetailActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
