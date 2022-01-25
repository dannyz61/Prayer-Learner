package com.example.prayerlearner1;

import com.google.gson.annotations.SerializedName;

public class NamazTimeModelClass {
    public NamazTimeModelClass(String city, String date, today todayObject) {
        this.city = city;
        this.date = date;
        TodayObject = todayObject;
    }

    private String city;
    private String date;
    @SerializedName("today")
    today TodayObject;


    public today getTodayObject() {
        return TodayObject;
    }

    public void setTodayObject(today todayObject) {
        TodayObject = todayObject;
    }


    // Getter Methods

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }


    // Setter Methods

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String date) {
        this.date = date;
    }
}