package com.example.tictactoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class gridAdapter extends BaseAdapter
{
    private final int image[];
    Context context;

    public gridAdapter(Context context, int[] image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public int getCount()
    {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.griditem,null);

        ImageView iv=(ImageView)view.findViewById(R.id.dataItem);
        iv.setImageResource(image[position]);
        return view;
    }
}

