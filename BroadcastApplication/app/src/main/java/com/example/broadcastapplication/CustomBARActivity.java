package com.example.broadcastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomBARActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_baractivity);

        Button btn_normal = findViewById(R.id.btn_normal);
        btn_normal.setOnClickListener(this);

        Button btn_order = findViewById(R.id.btn_order);
        btn_order.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_normal:
                Intent intent_normal = new Intent("com.example.broadcastapplication.MY_BROADCAST");
                intent_normal.setPackage(getPackageName());
                sendBroadcast(intent_normal);
                break;
            case R.id.btn_order:
                Intent intent_order = new Intent("com.example.broadcastapplication.MY_BROADCAST");
                intent_order.setPackage(getPackageName());
                sendOrderedBroadcast(intent_order,null);
            default:
                break;
    }
}
}