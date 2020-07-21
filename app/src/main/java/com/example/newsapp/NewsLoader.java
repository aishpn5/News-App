package com.example.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.Uri;

import java.net.MalformedURLException;
import java.util.List;

    public class NewsLoader extends AsyncTaskLoader<List<News>> {
       String requestUrl;

        /**
         * @param context
         * @deprecated
         */
        public NewsLoader(Context context) {
            super(context);
        }

        @Override
    protected void onStartLoading(

    ) { Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority("content.guardianapis.com");
        builder.appendPath("search");
        builder.appendQueryParameter("show_tags", "contributor");
        builder.appendQueryParameter("api-key", "test");

         requestUrl = builder.build().toString();

        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (requestUrl == null) {
            return null;
        }

        List<News> newsList = QueryUtils.fetchNewsData(requestUrl);
        return newsList;
    }
}