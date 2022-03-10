package com.example.prayerlearner1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NamazAhadithAlerts extends AppCompatActivity {
    Button btn4;
    SliderView sliderView;
    TextView loc,fajar,zuhr,asar,maghrib,isha,sunrise;
    String uRL="https://dailyprayer.abdulrcs.repl.co/api/";
    int[] images = {R.drawable.h1,
            R.drawable.h2,
            R.drawable.h3,
            R.drawable.h4,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        sliderView = findViewById(R.id.image_slider);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Alerts");
        actionBar.setDisplayHomeAsUpEnabled(true);
        loc=findViewById(R.id.location);
        fajar=findViewById(R.id.fajar);
        zuhr=findViewById(R.id.zuhr);
        asar=findViewById(R.id.asar);
        maghrib=findViewById(R.id.mghrib);
        isha=findViewById(R.id.isha);
        sunrise=findViewById(R.id.sunrise);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();




    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
       Retrofit retrofit= new Retrofit.Builder().baseUrl(uRL).addConverterFactory(GsonConverterFactory.create()).build();
       NamazTimeApi api=retrofit.create(NamazTimeApi.class);
        Call<NamazTimeModelClass> call=api.getime();
        call.enqueue(new Callback<NamazTimeModelClass>() {
            @Override
            public void onResponse(Call<NamazTimeModelClass> call, Response<NamazTimeModelClass> response) {
                Toast.makeText(NamazAhadithAlerts.this, "Success", Toast.LENGTH_SHORT).show();
                NamazTimeModelClass data=response.body();
                loc.setText(data.getCity());
                today today=data.getTodayObject();
                sunrise.setText(today.getSunrise());
                fajar.setText(today.getFajr());
                zuhr.setText(today.getDhuhr());
                asar.setText(today.getAsr());
                maghrib.setText(today.getMaghrib());
                isha.setText(today.getIsha());

            }

            @Override
            public void onFailure(Call<NamazTimeModelClass> call, Throwable t) {
                Toast.makeText(NamazAhadithAlerts.this, "Failure", Toast.LENGTH_SHORT).show();
                t.getCause();
            }
        });

//        Retrofit retrofit1= new Retrofit.Builder().baseUrl(uRL).addConverterFactory(GsonConverterFactory.create()).build();
//        NamazTimeApi api1=retrofit.create(NamazTimeApi.class);
//        Call<ArrayList<NamazTimeModelClass>> call1=api1.gedata();
    }
}