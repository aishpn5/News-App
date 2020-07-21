package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<News> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item, parent, false);
        }

        News currentNews = getItem(position);
        TextView newsTitleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        String title = currentNews.getmTitle();
        newsTitleTextView.setText(title);


        TextView newsCategorytextView = (TextView) listItemView.findViewById(R.id.category_text_view);
        String category = currentNews.getmCategory();
        newsCategorytextView.setText(category);

        TextView newsDatetextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        String date = currentNews.getmDate();
        newsDatetextView.setText(date);

        TextView newsAuthortextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        String author = currentNews.getmAuthor();
        newsAuthortextView.setText(author);

        return listItemView;
    }
}