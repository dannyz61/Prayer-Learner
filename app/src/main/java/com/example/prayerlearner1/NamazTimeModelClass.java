package com.example.prayerlearner1;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NamazTimeModelClass {
        private float code;
        private String status;
        @SerializedName("results")
        Results ResultsObject;


        // Getter Methods

        public float getCode() {
            return code;
        }

        public String getStatus() {
            return status;
        }

        public Results getResults() {
            return ResultsObject;
        }

        // Setter Methods

        public void setCode(float code) {
            this.code = code;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setResults(Results resultsObject) {
            this.ResultsObject = resultsObject;
        }
    }

    class Results {
    @SerializedName("datetime")
    ArrayList< Datetime > datetime = new ArrayList < Datetime > ();
    @SerializedName("location")
    Location LocationObject;
    @SerializedName("settings")
    Settings SettingsObject;


    // Getter Methods

    public Location getLocation() {
        return LocationObject;
    }

    public Settings getSettings() {
        return SettingsObject;
    }

    // Setter Methods

    public void setLocation(Location locationObject) {
        this.LocationObject = locationObject;
    }

    public void setSettings(Settings settingsObject) {
        this.SettingsObject = settingsObject;
    }

        class Datetime {
            @SerializedName("times")
            TimesModelClass times;
            @SerializedName("date")
            Date date;

            public Datetime() {
            }

            public TimesModelClass getTimes() {
                return times;
            }

            public void setTimes(TimesModelClass times) {
                this.times = times;
            }

            public Date getDate() {
                return date;
            }

            public void setDate(Date date) {
                this.date = date;
            }

            public Datetime(TimesModelClass times, Date date) {
                this.times = times;
                this.date = date;
            }
        }

        class Date {
            private float timestamp;
            private String gregorian;
            private String hijri;


            // Getter Methods

            public float getTimestamp() {
                return timestamp;
            }

            public String getGregorian() {
                return gregorian;
            }

            public String getHijri() {
                return hijri;
            }

            // Setter Methods

            public void setTimestamp(float timestamp) {
                this.timestamp = timestamp;
            }

            public void setGregorian(String gregorian) {
                this.gregorian = gregorian;
            }

            public void setHijri(String hijri) {
                this.hijri = hijri;
            }
        }
}





    class Settings {
        private String timeformat;
        private String school;
        private String juristic;
        private String highlat;
        private float fajr_angle;
        private float isha_angle;


        // Getter Methods

        public String getTimeformat() {
            return timeformat;
        }

        public String getSchool() {
            return school;
        }

        public String getJuristic() {
            return juristic;
        }

        public String getHighlat() {
            return highlat;
        }

        public float getFajr_angle() {
            return fajr_angle;
        }

        public float getIsha_angle() {
            return isha_angle;
        }

        // Setter Methods

        public void setTimeformat(String timeformat) {
            this.timeformat = timeformat;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public void setJuristic(String juristic) {
            this.juristic = juristic;
        }

        public void setHighlat(String highlat) {
            this.highlat = highlat;
        }

        public void setFajr_angle(float fajr_angle) {
            this.fajr_angle = fajr_angle;
        }

        public void setIsha_angle(float isha_angle) {
            this.isha_angle = isha_angle;
        }
    }

    class Location {
        private float latitude;
        private float longitude;
        private float elevation;
        private String city;
        private String country;
        private String country_code;
        private String timezone;
        private float local_offset;


        // Getter Methods

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public float getElevation() {
            return elevation;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getCountry_code() {
            return country_code;
        }

        public String getTimezone() {
            return timezone;
        }

        public float getLocal_offset() {
            return local_offset;
        }

        // Setter Methods

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public void setElevation(float elevation) {
            this.elevation = elevation;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public void setLocal_offset(float local_offset) {
            this.local_offset = local_offset;
        }
    }