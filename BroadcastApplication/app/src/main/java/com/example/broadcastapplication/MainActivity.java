package com.example.broadcastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;
//实现网络改变时，弹出提示弹窗
//创建IntentFilter实例
//调用Intent Filter实例的addaction()方法添加监听的广播类型。
//调用Context的registerReceiver(BroadcastRecevier,IntentFilter)动态的注册广播。
//结束时需调用unregisterRecevier（）取消注册
public class MainActivity extends AppCompatActivity {
private IntentFilter intentFilter;
private NetworkChangeReceiver networkChangeReceiver;
private TimeChangeRecevier timeChangeRecevier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//监听时间变化
//        timeChangeRecevier = new TimeChangeRecevier();
//        intentFilter = new IntentFilter("android.intent.action.TIME_TICK");
//        registerReceiver(timeChangeRecevier,intentFilter);
//监听网络变化
        networkChangeReceiver = new NetworkChangeReceiver();
        intentFilter = new IntentFilter("android.net.conn.connectivity_CHANGE");
        registerReceiver(networkChangeReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
//        unregisterReceiver(timeChangeRecevier);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Network Changes!", Toast.LENGTH_SHORT).show();

        }
    }
    class TimeChangeRecevier extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Time Changes!", Toast.LENGTH_SHORT).show();
        }
    }
}
