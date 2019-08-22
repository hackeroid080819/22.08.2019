package com.example.listviewclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] mobileArray = {
            "Android", "IPhone X", "Windows Phone" , "Blackberry",
            "Super MAC", "TEVA phone",
            "Android", "IPhone X", "Windows Phone" , "Blackberry",
            "Super MAC", "TEVA phone"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,
                mobileArray);

        ListView lv = findViewById(R.id.mobileLV);
        lv.setAdapter(adapter);

        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("================= ", "Item " + i + " was clicked");
                Toast.makeText(getBaseContext(), "Item " + i + " was clicked", Toast.LENGTH_LONG).show();

                // 1) Task: print the selected item (from the array)
                // 2) Task: print the selected item (from the text view)

                // view.findViewById(android.R.id.text1);


            }
        });

    }
}

