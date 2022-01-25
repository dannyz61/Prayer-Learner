package com.example.prayerlearner1;

import com.google.firebase.database.PropertyName;
import com.google.gson.annotations.SerializedName;

public class today {
    private String Fajr;
    private String Sunrise;
    private String Dhuhr;
    private String Asr;
    private String Maghrib;
@SerializedName("Isha'a")
    private String Isha;

    public today() {
    }

    public today(String fajr, String sunrise, String dhuhr, String asr, String maghrib, String isha) {
        Fajr = fajr;
        Sunrise = sunrise;
        Dhuhr = dhuhr;
        Asr = asr;
        Maghrib = maghrib;
        Isha = isha;
    }
// Getter Methods

    public String getFajr() {
        return Fajr;
    }

    public String getSunrise() {
        return Sunrise;
    }

    public String getDhuhr() {
        return Dhuhr;
    }

    public String getAsr() {
        return Asr;
    }

    public String getMaghrib() {
        return Maghrib;
    }

    public String getIsha() {
        return Isha;
    }

// Setter Methods

    public void setFajr(String Fajr) {
        this.Fajr = Fajr;
    }

    public void setSunrise(String Sunrise) {
        this.Sunrise = Sunrise;
    }

    public void setDhuhr(String Dhuhr) {
        this.Dhuhr = Dhuhr;
    }

    public void setAsr(String Asr) {
        this.Asr = Asr;
    }

    public void setMaghrib(String Maghrib) {
        this.Maghrib = Maghrib;
    }

    public void setIsha(String Isha) {
        this.Isha = Isha;
    }
}
