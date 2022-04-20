package com.example.prayerlearner1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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


      final Python  Py = Python.getInstance();
        // now create Python instances

        try (PyObject Pyobj = Py.getModule("Test")) {
            obj = Pyobj.callAttr("test");
            Toast.makeText(this, ""+obj, Toast.LENGTH_SHORT).show();

        }
//        catch {
//            Toast.makeText(this, "Eror", Toast.LENGTH_SHORT).show();
//        }

    }
}