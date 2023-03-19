package com.mfslink.newsapi;

import com.mfslink.newsapi.Model.MainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BaseUrl = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<MainNews> getNews(

            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey


    );

    @GET("top-headlines")
    Call<MainNews> getCategoryNews(

            @Query("category") String category,
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey



    );


}
