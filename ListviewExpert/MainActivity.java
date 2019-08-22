package com.example.listviewclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // must be ArrayList in order to support adapter.remove
        final ArrayList<String> mobileArray = new ArrayList<>();
        mobileArray.add("Android");
        mobileArray.add("Windows Phone");
        mobileArray.add("Blackberry");
        mobileArray.add("Super MAC");
        mobileArray.add("TEVA phone");
        mobileArray.add("Android");
        mobileArray.add("Windows Phone");
        mobileArray.add("Blackberry");
        mobileArray.add("Super MAC");
        mobileArray.add("TEVA phone");

        final ArrayAdapter adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,

                mobileArray);

        ListView lv = findViewById(R.id.mobileLV);
        lv.setAdapter(adapter);

        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("================= ", "Item " + i + " was clicked");

                // 1) Task: print the selected item (from the array)
                // 2) Task: print the selected item (from the text view)

                // answer 1: [not recommended]
                //Toast.makeText(getBaseContext(), "Item " + mobileArray[i] + " was clicked", Toast.LENGTH_LONG).show();

                // answer 2: Better
                TextView tv = view.findViewById(android.R.id.text1);
                //Toast.makeText(getBaseContext(), "Item " + tv.getText().toString() +
                        //" was clicked", Toast.LENGTH_LONG).show();

                // answer 3:
                if (tv.getText().toString().endsWith("clicked!"))
                {
                    Toast.makeText(getBaseContext(), "Item " + tv.getText().toString() +
                            " was already clicked", Toast.LENGTH_LONG).show();
                }
                else {
                    tv.setText(tv.getText().toString() + " clicked!");
                }

                // remove clicked item
                //adapter.remove(adapter.getItem(i));
            }
        });

        final EditText listItemET = findViewById(R.id.itemET);

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(listItemET.getText().toString());
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = view.findViewById(android.R.id.text1);
                tv.setText(listItemET.getText().toString());
                return true;
            }
        });
    }
}

