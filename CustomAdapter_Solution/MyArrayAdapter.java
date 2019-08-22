package com.example.customadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<String> {

    Context _context;
    int _layout;
    ArrayList<String> _objects;

    public MyArrayAdapter(Context context, int layout, ArrayList<String> objects) {
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

            // draw the current view in two options:
            // if is even -- draw using the android layout (white)
            // if is odd -- draw using our layout (colored)
            result = LayoutInflater.from(_context).inflate(
                    position % 2 == 0 ?
                            android.R.layout.simple_list_item_1 :
                    R.layout.my_layout_item_yellow,
                    parent, false);
        }
        TextView tv = result.findViewById(android.R.id.text1);
        tv.setText(_objects.get(position));

        final MyArrayAdapter self = this;
        final int selfPosition = position;

        result.setOnClickListener(new DeleteOnClickListener(this, position));

        return result;

    }
}
