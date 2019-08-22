package com.example.listviewimages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        List<MyContact> myContactList = new ArrayList<>();
        myContactList.add(new MyContact("035555555", "Bituah", false));
        myContactList.add(new MyContact("0508664112", "Itay hau", true));
        myContactList.add(new MyContact("0365384674", "Isracard", false));
        myContactList.add(new MyContact("0507289467", "John Doe", true));

        List<HashMap<String, String>> fullDictionary = new ArrayList<HashMap<String, String>>();

        String keyForName = "KEY_FOR_NAME";
        String keyForNumber = "KEY_FOR_NUMBER";
        String keyForImageMBKV = "KEY_FOR_MB_KV";
        String keyForImageFV = "KEY_FOR_FV";

        for(MyContact contactOne : myContactList)
        {
            HashMap<String, String> dic = new HashMap<>();
            dic.put(keyForName, contactOne.getName());
            dic.put(keyForNumber, contactOne.getPh());
            dic.put(keyForImageMBKV,
                    String.valueOf(contactOne.getPh().startsWith("05")
                            ? R.drawable.mobile : R.drawable.kavi));
            dic.put(keyForImageFV,
                    String.valueOf(contactOne.IsFavorite() ?
                            R.drawable.love : R.drawable.angry));
            fullDictionary.add(dic);
        }
        String[] from = {keyForName, keyForNumber,
                keyForImageMBKV, keyForImageFV};
        int[] to = {R.id.contact_name, R.id.contact_number,
                R.id.mobile_kavi_image, R.id.fav_or_not};
        ListView lv = findViewById(R.id.myListView);
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                getBaseContext(), fullDictionary, R.layout.contact_listitem, from, to);
        lv.setAdapter(simpleAdapter);
    }
}
