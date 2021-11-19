package com.example.broadcastapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LocalActivity extends AppCompatActivity {
private IntentFilter intentFilter;
private LocalReceiver localReceiver;
private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter("com.example.broadcastapplication.LOCALBR");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

        Button btn_loacl =findViewById(R.id.btn_local);
        btn_loacl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               localBroadcastManager = LocalBroadcastManager.getInstance(LocalActivity.this);
               Intent intent_local = new Intent("com.example.broadcastapplication.LOCALBR");
               localBroadcastManager.sendBroadcast(intent_local);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Received in LocalReceiver!", Toast.LENGTH_SHORT).show();
        }

    }

}