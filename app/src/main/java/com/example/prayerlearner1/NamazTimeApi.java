package com.example.prayerlearner1;


import org.apache.commons.collections4.Get;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NamazTimeApi {
    @GET("today.json?city=faisalabad")
    Call<NamazTimeModelClass> getime();

}
