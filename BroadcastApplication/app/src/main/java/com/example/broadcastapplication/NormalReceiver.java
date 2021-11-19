package com.example.broadcastapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NormalReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Received in NormalReceiver!", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}