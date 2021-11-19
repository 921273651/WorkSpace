package com.example.myapplication02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class jewelryAdapterY extends ArrayAdapter {
    private final int resourceId;


    public jewelryAdapterY(@NonNull Context context, int resource, @NonNull List objects, int resourceId) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        if (convertView== null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }else{
            view=convertView;
        }
        ImageView jewelryImage =view.findViewById(R.id.jewelry0);
        TextView jewelryName=view.findViewById(R.id.jewelry0);
        return super.getView(position, convertView, parent);
        }


}
