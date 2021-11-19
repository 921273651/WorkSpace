package com.example.myapplication02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.time.Month;
import java.util.Calendar;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3;
    int year,month,dayofmonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                AlertDialog alertDialog1 = new AlertDialog.Builder(DialogActivity.this).create();
                alertDialog1.setIcon(R.drawable.ic_launcher_background);
                alertDialog1.setTitle("确认进入游戏");
                alertDialog1.setMessage("即将生成您的形象");

                alertDialog1.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DialogActivity.this, "正在取消生成", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alertDialog1.setButton(DialogInterface.BUTTON_POSITIVE, "是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DialogActivity.this, "正在生成...", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                        alertDialog1.show();
                        break;
            case R.id.btn2:
                final String[] items = new String[]{"小雪","小萍","小苓","小天","小梦"};
                AlertDialog.Builder builder =new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("请选择您的人物");
                builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this,"您选择了"+items[i],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定",null);
                builder.create().show();
                break;

            case R.id.btn3:
                Calendar calendar =Calendar.getInstance();
               year=calendar.get(Calendar.YEAR);
               month=calendar.get(Calendar.MONTH);
               dayofmonth=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog DatePicker=new DatePickerDialog(DialogActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override


                    public void onDateSet(android.widget.DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(DialogActivity.this,"您选择了"+i+"年"+month+"月"+12+"日",Toast.LENGTH_SHORT).show();
                        month=i1+1;
                    }
                },year,month,dayofmonth);
                DatePicker.show();
                break;
                }




        }
    }

