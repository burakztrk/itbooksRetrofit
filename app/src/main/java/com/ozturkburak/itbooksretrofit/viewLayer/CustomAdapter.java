package com.ozturkburak.itbooksretrofit.viewLayer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ozturkburak.itbooksretrofit.R;
import com.ozturkburak.itbooksretrofit.entity.BookInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burak on 2/12/17.
 */

public class CustomAdapter extends BaseAdapter
{
    private TextView m_textView_title , m_textView_desc ;
    private ImageView m_imageView_cover ;
    private Activity m_activty;

    private LayoutInflater m_inflater;
    private List<BookInfo> m_bookList;

    public CustomAdapter(Activity activity , List<BookInfo> list)
    {

        m_activty = activity;
        m_bookList = list == null ? new ArrayList<BookInfo>() : list;
        m_inflater = (LayoutInflater) m_activty.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public List<BookInfo> getBooks()
    {
        return m_bookList;
    }


    public void clear()
    {
        m_bookList.clear();
        this.notifyDataSetChanged();
    }

    public boolean add(BookInfo book)
    {
        if (book == null)
            return false;

        m_bookList.add(book);
        this.notifyDataSetChanged();
        return true;
    }


    public boolean addBooks(List<BookInfo> list)
    {
        if (list == null)
            return false;

        m_bookList.addAll(list);
        this.notifyDataSetChanged();
        return true;
    }

    @Override
    public int getCount() {
        return m_bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return m_bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView = m_inflater.inflate(R.layout.customlist_book_view, null);

        m_textView_title = (TextView) rowView.findViewById(R.id.BOOKVIEW_TITLE);
        m_textView_desc = (TextView) rowView.findViewById(R.id.BOOKVIEW_DESC);
        m_imageView_cover = (ImageView) rowView.findViewById(R.id.BOOKVIEW_IMAGE);


        BookInfo curBook = m_bookList.get(position);
        m_textView_title.setText(String.format("%d-%s" , position+1 ,curBook.getTitle()));
        m_textView_desc.setText(curBook.getDescription());

        Picasso picasso = Picasso.with(m_activty);
        picasso.setIndicatorsEnabled(true);
        picasso.with(m_activty).load(curBook.getImage()).into(m_imageView_cover);

        return rowView;
    }
}



