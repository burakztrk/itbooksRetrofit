package com.ozturkburak.itbooksretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ozturkburak.itbooksretrofit.entity.*;
import com.ozturkburak.itbooksretrofit.retrofit.*;
import com.ozturkburak.itbooksretrofit.viewLayer.*;

import retrofit2.Call;


public class MainActivity extends AppCompatActivity {
    private EditText m_editText_searchText;

    private ListView m_listview;
    private CustomAdapter m_adapter;
    private SearchResponseInfo m_searchResponseInfo;
    private EndlessScrollListener m_scrollListener;

    private String latestSearchText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }


    private void init()
    {
        m_editText_searchText = (EditText) this.findViewById(R.id.MAINACTIVITY_EDITTEXT_TEXT);
        m_listview = (ListView) this.findViewById(R.id.MAINACTIVITY_LISTVIEW_LIST);

        m_searchResponseInfo = new SearchResponseInfo();
        m_adapter = new CustomAdapter(this, m_searchResponseInfo.getBooks());
        m_listview.setAdapter(m_adapter);

        m_scrollListener = new EndlessScrollListener(m_searchResponseInfo)
        {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount)
            {
                ApiMethodsInterface apiMethods = ApiClient.getClient().create(ApiMethodsInterface.class);
                Call<SearchResponseInfo> call = apiMethods.getSearchBooksDetails(m_editText_searchText.getText().toString().trim() , page );
                call.enqueue(SearchBookCallBack.set(MainActivity.this , m_listview , m_adapter , m_searchResponseInfo , true));

                Toast.makeText(MainActivity.this, String.format("Page %d Loading....",page), Toast.LENGTH_SHORT).show();

                return true;
            }
        };
        m_listview.setOnScrollListener(m_scrollListener);

        m_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                BookInfo bookInfo = (BookInfo) m_adapter.getItem(position);

                Intent intent = new Intent(MainActivity.this ,DetailActivity.class);
                intent.putExtra("BOOKINFO" , bookInfo);
                MainActivity.this.startActivityForResult(intent , Variables.SECONDACTIVITY_REQUEST_CODE);
            }
        });


    }



    public void searchButtonClicked(View v)
    {
        m_listview.smoothScrollToPosition(0);

        String searchText = m_editText_searchText.getText().toString().trim();

        if (searchText.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Bir kelime giriniz", Toast.LENGTH_SHORT).show();
            return;
        }
        if(latestSearchText.equals(searchText))
            return;

        latestSearchText = searchText;

        m_scrollListener.resetState();

        ApiMethodsInterface apiMethods = ApiClient.getClient().create(ApiMethodsInterface.class);
        Call<SearchResponseInfo> call = apiMethods.getSearchBooksDetails(searchText);
        call.enqueue(SearchBookCallBack.set(MainActivity.this, m_listview , m_adapter , m_searchResponseInfo , false));
    }

}



