package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PostureResult extends AppCompatActivity implements SensorEventListener  {
    SensorManager sensorManager, sensorManager1, sensorManager2;
    List<String[]> data;
    Long lastTimeUpdate;
    List<Float> X1=new ArrayList<>();
    List<Float> Y1=new ArrayList<>();
    List<Float> Z1=new ArrayList<>();
    List<Float> X2=new ArrayList<>();
    List<Float> Y2=new ArrayList<>();
    List<Float> Z2=new ArrayList<>();
    List<Float> X3=new ArrayList<>();
    List<Float> Y3=new ArrayList<>();
    List<Float> Z3=new ArrayList<>();
    int i=0;
    View v;
    TextView acc0,acc1,acc2,gyr0,gyr1,gyr2,meg0,meg1,meg2, avg_t;
    String csv = "/sdcard/Download/SensorData.csv";// Here csv
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture_result);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MANAGE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        data = new ArrayList<String[]>();
//        data.add(new String[]{"Sensors"," ", " ", "Accelemeter", " ", ""," ", "Gyrometer", "", "","", "Magnetometer", ""});
        data.add(new String[]{"Axis", "TS1","X1", "Y1", "Z1", "TS2","X2", "Y2", "Z2","TS3", "X3", "Y3", "Z3"});

        avg_t =findViewById(R.id.meanTextView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager1 = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager2 = (SensorManager) getSystemService(SENSOR_SERVICE);
    }


    public void start_file(View view) {
        sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager1.registerListener(this, sensorManager1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL);
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
    public void getMyAccelerometerValues(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];

        float y = values[1];
        float z = values[2];
        BigDecimal bd = new BigDecimal(event.timestamp);
        long val = bd.longValue();
        Log.d("danny", "getMyAccelerometerValues: "+val);
        data.add(new String[]{"",String.valueOf(val), String.valueOf((float) event.values[0]), String.valueOf((float) event.values[1]), String.valueOf((float) event.values[2]),"", "", "", "", "", "", ""});
         X1.add(values[0]);
         Y1.add(values[1]);
         Z1.add(values[2]);

        //        acc0.setText(String.valueOf(x));
//        acc1.setText(String.valueOf(y));
//        acc2.setText(String.valueOf(z));
//        Toast.makeText(this,"accelerometer data \nvalue of x is "+x+"\nvalue of Y "+y+"\nvalue of z "+z,Toast.LENGTH_LONG).show();
//        getWindow().getDecorView().setBackgroundColor(Color.RED);

    }

    public void getMyGyroscope(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        BigDecimal bd = new BigDecimal(event.timestamp);
        long val = bd.longValue();
        data.add(new String[]{"","", "", "","", String.valueOf(val), String.valueOf((float) event.values[0]), String.valueOf((float) event.values[1]), String.valueOf((float) event.values[2]),"", "", "", ""});
//        gyr0.setText(String.valueOf(x));
//        gyr1.setText(String.valueOf(y));
//        gyr2.setText(String.valueOf(z));
        //Toast.makeText(this,"Gyroscope data \nvalue of x is "+x+"\nvalue of Y "+y+"value of z "+z,Toast.LENGTH_LONG).show();
        // getWindow().getDecorView().setBackgroundColor(Color.RED);
        X2.add(values[0]);
        Y2.add(values[1]);
        Z2.add(values[2]);

    }

    public void getMyMagneticfield(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        BigDecimal bd = new BigDecimal(event.timestamp);
        long val = bd.longValue();
        data.add(new String[]{"","", "", "", "", "", "","","", String.valueOf(val), String.valueOf((float) event.values[0]), String.valueOf((float) event.values[1]), String.valueOf((float) event.values[2])});
//        meg0.setText(String.valueOf(x));
//        meg1.setText(String.valueOf(y));
//        meg2.setText(String.valueOf(z));
        // Toast.makeText(this,"Magnetometer data \nvalue of x is "+x+"\nvalue of Y "+y+"value of z "+z,Toast.LENGTH_LONG).show();
        // getWindow().getDecorView().setBackgroundColor(Color.RED);

        X3.add(values[0]);
        Y3.add(values[1]);
        Z3.add(values[2]);

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void end_file(View view) {
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

    public void Calculate_Average(View view) {
        float  sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
        double avgX1,avgX2,avgX3,avgY1,avgY2,avgY3,avgZ1,avgZ2,avgZ3=0;
        double accavgX1,accavgX2,accavgX3,accavgY1,accavgY2,accavgY3,accavgZ1,accavgZ2,accavgZ3;
        //read from file
        accavgX1=3.5;
        accavgX2=3.5;
        accavgX3=3.5;
        accavgY1=3.5;
        accavgY2=3.5;
        accavgY3=3.5;
        accavgZ1=3.5;
        accavgZ2=3.5;
        accavgZ3=3.5;
       for(int j=0;j<X1.size();j++)
       {

           sum1+=X1.get(j);
       }
        for(int j=0;j<Y1.size();j++)
        {

            sum2+=Y1.get(j);
        }
        for(int j=0;j<Z1.size();j++)
        {

            sum3+=Z1.get(j);
        }
        for(int j=0;j<X2.size();j++)
        {

            sum4+=X2.get(j);
        }
        for(int j=0;j<Y2.size();j++)
        {

            sum5+=Y2.get(j);
        }
        for(int j=0;j<Z2.size();j++)
        {

            sum6+=Z2.get(j);
        }
        for(int j=0;j<X3.size();j++)
        {

            sum7+=X3.get(j);
        }
        for(int j=0;j<Y3.size();j++)
        {

            sum8+=Y3.get(j);
        }
        for(int j=0;j<Z3.size();j++)
        {

            sum9+=Z3.get(j);
        }

        avgX1=sum1/X1.size();
        avgY1=sum2/Y1.size();
        avgZ1=sum3/Z1.size();
        avgX2=sum4/X2.size();
        avgY2=sum5/Y2.size();
        avgZ2=sum6/Z2.size();
        avgX3=sum7/X3.size();
        avgY3=sum8/Y3.size();
        avgZ3=sum9/Z3.size();

    avg_t.setText(String.valueOf(avgX1));
       Toast.makeText(getApplicationContext(),"average of  X axix of accelerometer is "+avgX1,Toast.LENGTH_LONG).show();
       double accX1=0,accX2=0,accX3=0,accY1=0,accY2,accY3,accZ1=0,accZ2,accZ3=0;
       //for accuracy of X1.......
  if(accavgX1>avgX1)
  {
      accX1=accavgX1-avgX1;
  }
  else if (accavgX1<avgX1)
  {
      accX1=avgX1-accavgX1;
  }
        //for accuracy of Y1.......
        if(accavgX1>avgX1)
        {
            accX1=accavgY1-avgY1;
        }
        else if (accavgY1<avgY1)
        {
            accY1=avgY1-accavgY1;
        }
//for accuracy Z1
        if(accavgZ1>avgZ1)
        {
            accZ1=accavgZ1-avgZ1;
        }
        else if (accavgZ1<avgZ1)
        {
            accZ1=avgZ1-accavgZ1;
        }
    double totalAcc=(accX1+accY1+accZ1)*100;//store value in total accuracy

    }
}