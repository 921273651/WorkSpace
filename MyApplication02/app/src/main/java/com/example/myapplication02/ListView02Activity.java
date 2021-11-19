package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView02Activity extends AppCompatActivity {
    private List<Jewelry> jewelryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        initJewelry();
        JewelryAdapterY2 jewelryAdapterY2 =new JewelryAdapterY2 (ListView02Activity.this,R.layout.jewelry,jewelryList);

        ListView listView =findViewById(R.id.list_view);
        listView.setAdapter(jewelryAdapterY2);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Jewelry jewelry = jewelryList.get(i);
                Toast.makeText(ListView02Activity.this,jewelry.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initJewelry(){
     Jewelry rings=new Jewelry("真爱对戒" ,R.drawable.rings);
     jewelryList.add(rings);

        Jewelry flower=new Jewelry("花语项链",R.drawable.flowers);
        jewelryList.add(flower);

        Jewelry stars=new Jewelry("星河项链",R.drawable.stars);
        jewelryList.add(stars);

        Jewelry  necklace =new Jewelry("异域宝石项链",R.drawable.necklace01);
        jewelryList.add(necklace);

        Jewelry  necklace02 =new Jewelry("腥红之石项链",R.drawable.necklace02);
        jewelryList.add(necklace02);

        Jewelry earing=new Jewelry("星耀耳环",R.drawable.earing);
        jewelryList.add(earing);

        Jewelry earing04=new Jewelry("花语耳环",R.drawable.earing03);
        jewelryList.add(earing04);

        Jewelry  earing02 =new Jewelry("简约耳环",R.drawable.eraing02);
        jewelryList.add(earing02);

        Jewelry  earing03=new Jewelry("国风再现耳环",R.drawable.earing02);
        jewelryList.add(earing03);
        Jewelry  jiezhi =new Jewelry("粉蓝对戒",R.drawable.jiezhi_2);
        jewelryList.add(jiezhi);


    }
}
