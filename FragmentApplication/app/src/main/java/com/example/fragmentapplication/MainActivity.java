package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new RightFragment());
        Button btn_left = findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
              replaceFragment(new RightFragment2());
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        //获取FragmentManager
        FragmentManager fragmentManager =getSupportFragmentManager();
      //通过FragmentManager开启一个Fragment Transaction事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //通过Fragment Transaction对象的replace（）方法替换Fragment实例
        transaction.replace(R.id.right_fragment,fragment);
        //在碎片中模拟返回栈
        transaction.addToBackStack(null);
        //提交事务
        transaction.commit();
    }
}
