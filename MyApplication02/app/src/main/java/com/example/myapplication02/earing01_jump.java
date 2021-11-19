package com.example.myapplication02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class earing01_jump extends AppCompatActivity implements View.OnClickListener {
private Button shoppingCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_necklace01_jump);

        Button shoppingCar = findViewById(R.id.shopppingCar);
        shoppingCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shopppingCar:
                AlertDialog alertDialog2 = new AlertDialog.Builder(earing01_jump.this).create();
                alertDialog2.setIcon(R.drawable.ic_launcher_background);
                alertDialog2.setTitle("确定加入购物车？");
                alertDialog2.setMessage("加入购物车？");
                alertDialog2.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(earing01_jump.this,"取消加入",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog2.setButton(DialogInterface.BUTTON_POSITIVE, "是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(earing01_jump.this,"加入成功",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog2.show();
                break;
        }
    }
}