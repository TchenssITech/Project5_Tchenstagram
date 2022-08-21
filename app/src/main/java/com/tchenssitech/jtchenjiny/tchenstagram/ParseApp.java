package com.tchenssitech.jtchenjiny.tchenstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import com.tchenssitech.jtchenjiny.tchenstagram.Models.Post;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //register parse model
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ejEC5U1saDhjXwurnpNqVmI6EtucAA8VDrrbyq5Q")
                .clientKey("4Jym6VfXNzD1Bzcjktk9oxBsqrSaQKLz4ug6F0MO")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}
