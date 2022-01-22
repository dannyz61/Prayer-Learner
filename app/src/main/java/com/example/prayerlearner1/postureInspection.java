package com.example.prayerlearner1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class postureInspection extends AppCompatActivity  implements SensorEventListener {
    SensorManager sensorManager, sensorManager1, sensorManager2;
    List<String[]> data;
    Long lastTimeUpdate;
    View v;
    TextView acc0,acc1,acc2,gyr0,gyr1,gyr2,meg0,meg1,meg2;
    String csv = "/sdcard/Download/SensorData.csv";// Here csv

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MANAGE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        



        data = new ArrayList<String[]>();
        data.add(new String[]{"Sensors", " ", "Accelemeter", " ", "", "Gyrometer", "", "", "Magnetometer", ""});
        data.add(new String[]{"Axis", "X", "Y", "Z", "X", "Y", "Z", "X", "Y", "Z"});


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager1 = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager2 = (SensorManager) getSystemService(SENSOR_SERVICE);

        meg0=findViewById(R.id.meg_0);
        meg1=findViewById(R.id.meg_1);
        meg2=findViewById(R.id.meg_2);
        acc0=findViewById(R.id.acc_0);
        acc1=findViewById(R.id.acc_1);
        acc2=findViewById(R.id.acc_2);
        gyr0=findViewById(R.id.gyr_0);
        gyr1=findViewById(R.id.gyr_1);
        gyr2=findViewById(R.id.gyr_2);

    }

    public void getMyAccelerometerValues(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        data.add(new String[]{" ", String.valueOf((float) event.values[0]), String.valueOf((float) event.values[1]), String.valueOf((float) event.values[2]), " ", " ", " ", " ", " ", " "});
        acc0.setText(String.valueOf(x));
        acc1.setText(String.valueOf(y));
        acc2.setText(String.valueOf(z));
//        Toast.makeText(this,"accelerometer data \nvalue of x is "+x+"\nvalue of Y "+y+"\nvalue of z "+z,Toast.LENGTH_LONG).show();
//        getWindow().getDecorView().setBackgroundColor(Color.RED);

    }

    public void getMyGyroscope(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        data.add(new String[]{"", "", "", " ", String.valueOf((float) event.values[0]), String.valueOf((float) event.values[1]), String.valueOf((float) event.values[2]), " ", " ", " "});
        gyr0.setText(String.valueOf(x));
        gyr1.setText(String.valueOf(y));
        gyr2.setText(String.valueOf(z));
        //Toast.makeText(this,"Gyroscope data \nvalue of x is "+x+"\nvalue of Y "+y+"value of z "+z,Toast.LENGTH_LONG).show();
        // getWindow().getDecorView().setBackgroundColor(Color.RED);

    }

    public void getMyMagneticfield(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        data.add(new String[]{" ", "", "", "", "", "", "", String.valueOf((float) event.values[0]), String.valueOf((float) event.values[1]), String.valueOf((float) event.values[2])});
        meg0.setText(String.valueOf(x));
        meg1.setText(String.valueOf(y));
        meg2.setText(String.valueOf(z));
        // Toast.makeText(this,"Magnetometer data \nvalue of x is "+x+"\nvalue of Y "+y+"value of z "+z,Toast.LENGTH_LONG).show();
        // getWindow().getDecorView().setBackgroundColor(Color.RED);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getMyAccelerometerValues(event);
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            getMyGyroscope(event);
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            getMyMagneticfield(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    protected void onResume() {

        super.onResume();

        sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager1.registerListener(this, sensorManager1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        sensorManager1.unregisterListener(this);
        sensorManager2.unregisterListener(this);


    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    public void genratefile(View view) {
        try {
            sensorManager.unregisterListener(this);
            sensorManager1.unregisterListener(this);
            sensorManager2.unregisterListener(this);
            CSVWriter writer1;
            writer1 = null;
            writer1 = new CSVWriter(new FileWriter(csv));
            Toast.makeText(this, "Data Exported "+csv+" Succesfully", Toast.LENGTH_LONG).show();
            writer1.writeAll(data); // data is adding to csv
            writer1.close();

        } catch (IOException e) {
            Toast.makeText(this, "File not Created \nYour System Storage is not acceccible", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION));
            Toast.makeText(this, "Allow Prayer Learner to Access Files", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        }

    }

    public void back(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
