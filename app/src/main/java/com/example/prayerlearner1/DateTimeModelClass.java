package com.example.prayerlearner1;

import com.google.gson.annotations.SerializedName;

public class DateTimeModelClass {
    @SerializedName("times")
    TimesModelClass time;

    public DateTimeModelClass() {
    }

    public TimesModelClass getTime() {
        return time;
    }

    public void setTime(TimesModelClass time) {
        this.time = time;
    }

    public DateTimeModelClass(TimesModelClass time) {
        this.time = time;
    }
}
