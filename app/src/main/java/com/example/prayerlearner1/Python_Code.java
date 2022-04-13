package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class Python_Code extends AppCompatActivity {

    PyObject obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_code);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(Python_Code.this));
        } // this will start Python


    }

    public void check(View view) {

        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
      final Python  Py = Python.getInstance();
        // now create Python instances

        try (PyObject Pyobj = Py.getModule("Test")) {
            obj = Pyobj.callAttr("testing", "heloo");
        }

    }
}