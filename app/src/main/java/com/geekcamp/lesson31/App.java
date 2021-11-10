package com.geekcamp.lesson31;

import android.app.Application;

import com.geekcamp.lesson31.data.remote.FilmApi;
import com.geekcamp.lesson31.data.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient= new RetrofitClient();
        api= retrofitClient.provideFilmApi();
    }
}
