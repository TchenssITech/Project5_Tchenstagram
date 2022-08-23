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

        // Use for troubleshooting -- remove this line for production
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        // Use for monitoring Parse OkHttp traffic
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        // See https://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ejEC5U1saDhjXwurnpNqVmI6EtucAA8VDrrbyq5Q")
                .clientKey("4Jym6VfXNzD1Bzcjktk9oxBsqrSaQKLz4ug6F0MO")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}
