package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class postureIdentification extends AppCompatActivity {
    PyObject obj;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture_identification);
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(postureIdentification.this));

        }

    }

    public void check(View view) {
        final Python  Py = Python.getInstance();
        try (PyObject Pyobj = Py.getModule("Posture")) {
            obj = Pyobj.callAttr("checkposture");
            Toast.makeText(this, ""+obj, Toast.LENGTH_SHORT).show();

        }
    }
}