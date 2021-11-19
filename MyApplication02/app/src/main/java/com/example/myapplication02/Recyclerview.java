package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Recyclerview extends AppCompatActivity {
    private List<Jewelry> jewelryList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recyclerview);
        initJewelry();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(Recyclerview.this);

//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager1);

        Jewelry_item adapterR = new Jewelry_item(jewelryList);
        recyclerView.setAdapter(adapterR);



    }
    private void initJewelry(){
        Jewelry rings=new Jewelry("真爱对戒",R.drawable.rings);
        jewelryList.add(rings);

        Jewelry flower=new Jewelry("花语项链",R.drawable.flowers);
        jewelryList.add(flower);

        Jewelry stars=new Jewelry("星河项链",R.drawable.stars);
        jewelryList.add(stars);

        Jewelry  necklace =new Jewelry("异域宝石项链",R.drawable.necklace01);
        jewelryList.add(necklace);

        Jewelry  necklace01 =new Jewelry("腥红之石项链",R.drawable.necklace02);
        jewelryList.add(necklace01);

        Jewelry earing=new Jewelry("星耀耳环",R.drawable.earing);
        jewelryList.add(earing);

        Jewelry  jiezhi =new Jewelry("花语耳环",R.drawable.jiezhi_2);
        jewelryList.add(jiezhi);

        Jewelry  earing02 =new Jewelry("简约耳环",R.drawable.eraing02);
        jewelryList.add(earing02);

        Jewelry  earing03 =new Jewelry("国风再现耳环",R.drawable.earing02);
        jewelryList.add(earing03);

        Jewelry  earing04 =new Jewelry("粉蓝对戒",R.drawable.earing03);
        jewelryList.add(earing04);

    }
}
