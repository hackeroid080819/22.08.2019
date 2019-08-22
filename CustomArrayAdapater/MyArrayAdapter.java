package com.example.customadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<String> {

    Context _context;
    int _layout;
    String[] _objects;

    public MyArrayAdapter(Context context, int layout, String[] objects) {
        super(context, layout, objects);
        _context = context;
        _layout = layout;
        _objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("=============", "Get view for " + position);

        //return super.getView(position, convertView, parent);

        // position
        // convert view -- current view
        // parent ViewGroup

        View result = convertView;

        // option 1 - view is null
        // option 2 - view is already inflated ( no data guarantee )

        if (result == null)
        {
            Log.d("=======", "Drawing " + position);
            result = LayoutInflater.from(_context).inflate(_layout,
                    parent, false);
        }
        TextView tv = result.findViewById(android.R.id.text1);
        tv.setText(_objects[position]);

        return result;

    }
}
