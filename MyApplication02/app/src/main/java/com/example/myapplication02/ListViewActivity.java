package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {
   private String[] data={"珠宝","项链","镶钻项链","戒指","卡地亚大钻","闪耀对戒","情侣项链","玫瑰系列","田间系列" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
/*
*创建适配器
* 资源映射引入到java文件
 */
        ArrayAdapter<String> adapter =new ArrayAdapter<>( ListViewActivity.this,android.R.layout.simple_expandable_list_item_1,data);
        ListView listView =findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
