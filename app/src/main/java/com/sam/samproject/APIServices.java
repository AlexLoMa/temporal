package com.sam.samproject;

import com.sam.samproject.model.WeatherEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIServices {

    @GET
    Call<WeatherEntity> getWeather(@Url String url);
}
