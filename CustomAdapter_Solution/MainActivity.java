package com.example.customadapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mobileArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileArray.add("Android");
        mobileArray.add("IPhone X");
        mobileArray.add("Windows Phone");
        mobileArray.add("Blackberry");
        mobileArray.add("Super MAC");
        mobileArray.add("TEVA phone");
        mobileArray.add("Android");
        mobileArray.add("IPhone X");
        mobileArray.add("Windows Phone");
        mobileArray.add("Blackberry");
        mobileArray.add("Super MAC");
        mobileArray.add("TEVA phone");

        ArrayAdapter adapter = new MyArrayAdapter(
                this, android.R.layout.simple_list_item_1,
                mobileArray);

        ListView lv = findViewById(R.id.mobileList);
        lv.setAdapter(adapter);

    }
}
