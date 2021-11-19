package com.example.myapplication02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queation);

        ImageButton im1=findViewById(R.id.im1);
        im1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.im1:
                AlertDialog alertDialog1=new AlertDialog.Builder(MainActivity.this).create();
                alertDialog1.setIcon(R.drawable.ic_launcher_background);
                alertDialog1.setTitle("提交问卷？");
                alertDialog1.setMessage("提交此问卷？");

                alertDialog1.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"取消提交",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog1.setButton(DialogInterface.BUTTON_POSITIVE, "是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "正在提交", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                alertDialog1.show();
                break;

        }
    }
}
