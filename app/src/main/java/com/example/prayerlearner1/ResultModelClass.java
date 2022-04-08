package com.example.prayerlearner1;

import com.google.gson.annotations.SerializedName;

public class ResultModelClass {
    @SerializedName("datetime")
    DateTimeModelClass timeobj;

    public DateTimeModelClass getTimeobj() {
        return timeobj;
    }

    public void setTimeobj(DateTimeModelClass timeobj) {
        this.timeobj = timeobj;
    }

    public ResultModelClass(DateTimeModelClass timeobj) {
        this.timeobj = timeobj;
    }

    public ResultModelClass() {
    }
}
