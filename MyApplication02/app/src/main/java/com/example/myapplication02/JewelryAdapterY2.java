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

public class JewelryAdapterY2 extends ArrayAdapter<Jewelry> {
   private final int resourceId;


    public JewelryAdapterY2(@NonNull Context context, int resource, @NonNull List<Jewelry> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Jewelry jewelry =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){

            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.jewelryImage = view.findViewById(R.id.jewelry0);
            viewHolder.jewelryName = view.findViewById(R.id.text01);
            view.setTag(viewHolder);

        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.jewelryImage.setImageResource(jewelry.getImageId());
        viewHolder.jewelryName.setText(jewelry.getName());

        return view;
    }
    class ViewHolder{
        ImageView jewelryImage;
        TextView jewelryName;
    }
}
