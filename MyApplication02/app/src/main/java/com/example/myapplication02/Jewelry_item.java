package com.example.myapplication02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Jewelry_item extends RecyclerView.Adapter<Jewelry_item.ViewHolderR>{
    private List<Jewelry> mJewelry;

    public Jewelry_item(List<Jewelry> mJewelry) {
        this.mJewelry = mJewelry;
    }
//oncreatViewHolder 方法用于引入子项布局创建ViewHolderR实例，并将加载出的布局传入构造函数中，最后返回该实例。
    @NonNull
    @Override
    public ViewHolderR onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jewelry_item,parent,false);
        final ViewHolderR holderR=new ViewHolderR(view);

        holderR .jewelryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holderR.getAdapterPosition();
                Jewelry jewelry =mJewelry.get(position);
                Context context=view.getContext();
                Intent intent =new Intent(context,earing01_jump.class);
                intent.putExtra("goodsId",position);
                context.startActivity(intent);
            }
        });

        return holderR;
    }
//OncreateViewHolder方法用于引进子项布局创建ViewHolder实例，并将加载出来的布局传入构造函数中，最后返回该实例
    @Override
    public void onBindViewHolder(@NonNull ViewHolderR holder, int position) {
        Jewelry jewelry =mJewelry.get(position);
        holder.jewelryImage.setImageResource(jewelry.getImageId());
        holder .jewelryText.setText(jewelry.getName());

    }
//getItemCount 方法用于告诉RecyclerView一共有多少子项
    @Override
    public int getItemCount() {
        return mJewelry.size();
    }

    static class ViewHolderR extends RecyclerView.ViewHolder{
        View jewelryView;
        ImageView  jewelryImage;
        TextView jewelryText;


        public ViewHolderR(@NonNull View itemView) {
            super(itemView);
            jewelryView=itemView;
            jewelryImage=itemView.findViewById(R.id.jewelry0);
            jewelryText=itemView.findViewById(R.id.text01);

        }
    }
}
