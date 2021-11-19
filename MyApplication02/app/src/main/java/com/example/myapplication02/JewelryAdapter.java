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
/*
* 1.继承ArrayAdapter类，并重写适配器构造函数；
* 2.定义适配器成员变量（子项布局资源ID）
* 3.重写getView()方法，实现数据与子项布局资源对象的匹配
**/
public class JewelryAdapter extends ArrayAdapter<Jewelry> {
   private final int resourceId;
/* 通过Generate生成Override*/
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       Jewelry jewelry =getItem(position);  /*获取当前项的jewelry实例*/
       /*为子项加载传入的布局*/
       View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        /*调用View的findViewById()获取ImageView实例和TextView实例*/
        ImageView jewelryImage=view.findViewById(R.id.jewelry0);
        TextView jewelryName=view.findViewById(R.id.text01);

        /*调用ImageView实例的setImageResource()方法和TextView实例的setText来设置图片和文字*/
        jewelryImage.setImageResource(jewelry.getImageId());
        jewelryName.setText(jewelry.getName());
        return view;

    }

    public JewelryAdapter(@NonNull Context context, int resource, @NonNull List<Jewelry> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }
}
