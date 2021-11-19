package com.example.activityproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn2 =findViewById(R.id.btn_second);
        Intent  intent =getIntent();
        Bundle bundle=intent.getBundleExtra("info");
        String name = bundle.getString("name");
        int id =bundle.getInt("id",0);
        Log.d("SecondActivity","******接收到源Activity信息，名称："+name+",Id:"+id);
//        btn2.setOnClickListener(new View.OnClickListener(){
    }
//            @Override
//            public void onClick(View view) {

//                String data_reply ="Hello from SecondActivity";
//                Intent intent2 =new Intent();
//                intent2.putExtra("data_second",data_reply);
//                setResult(RESULT_OK,intent2);
//                finish();
//            }

//    );
//        Intent intent2=getIntent();
//        String data_get = intent2.getStringExtra("ZNL");
//        Log.d("SecondActivity",data_get);
    }

