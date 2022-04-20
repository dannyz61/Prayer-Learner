package com.example.prayerlearner1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.firebase.ui.auth.data.model.Resource;

public class Python_Code extends AppCompatActivity {

    PyObject obj;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_code);
        et=findViewById(R.id.et1);
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(Python_Code.this));

        } // this will start Python


    }

    public void check(View view) {


      final Python  Py = Python.getInstance();
        // now create Python instances

        try (PyObject Pyobj = Py.getModule("Test")) {
             obj = Pyobj.callAttr("test");
            Toast.makeText(this, ""+obj, Toast.LENGTH_SHORT).show();

        }



    }
}