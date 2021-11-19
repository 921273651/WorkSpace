package com.example.activityproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btn1 =findViewById(R.id.btn_first);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent 显式用法
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);
             Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
             intent.putExtra("ZNL","hello,SecondActivity!!");
//             startActivity(intent);
                startActivityForResult(intent,1);
                //隐式用法
//              Intent intent = new Intent("com.example.activityapplication.MY_ACTION");
//                intent.addCategory("android.intent.category.DEFAULT");
//              startActivity(intent);

                //使用Intent打开网页
//               openWebPage("https://www.tfswufe.edu.cn/");

                //使用Intent拨打电话
//             makeCall("19949510615");
            //使用地图
//                showMap(Uri.parse("geo:47.6,-122.3"));
                //
//                createAlarm("起床",8,20);

                //Bundle传输复杂数据
                Bundle bundle =new Bundle();
                bundle.putString("name","FirstActivity");
                bundle.putInt("id",121);
                intent.putExtra("info",bundle);
                startActivity(intent);
            }
        });
    }

         //接收到数据并打印
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode){
//            case 1:
//                if(resultCode==RESULT_OK){
//                    String returnedData = data.getStringExtra("data_second");
//                    Log.d("FirstActivity",returnedData);
//                }
//                break;
//            default:
//                break;
//        }
//    }
//使用Intent打开网页
//    public void openWebPage(String url){
//        Uri webpage = Uri.parse(url);
//        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
//        if (intent.resolveActivity(getPackageManager())!= null){
//            startActivity(intent);

//        }
//    }
//
            //使用Intent拨打电话
//       public void makeCall(String phoneNumber){
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:"+phoneNumber));
//        if (intent.resolveActivity(getPackageManager()) !=null){
//            startActivity(intent);
//        }
//       }

    //使用Intent调出地图
//    public void showMap(Uri geoLocation){
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(geoLocation);
//        if (intent.resolveActivity(getPackageManager())!=null){
//            startActivity(intent);
//        }
//    }
        //闹钟
    public void createAlarm(String message,int hour,int minutes){
         Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM)
                 .putExtra(AlarmClock.EXTRA_MESSAGE,message)
                 .putExtra(AlarmClock.EXTRA_HOUR,hour)
                 .putExtra(AlarmClock.EXTRA_MINUTES,minutes);
         if (intent.resolveActivity(getPackageManager())!=null){
             startActivity(intent);
         }

    }
}
