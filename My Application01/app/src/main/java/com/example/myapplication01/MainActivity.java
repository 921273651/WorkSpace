package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button1= findViewById(R.id.btn1);
       button1.setOnClickListener(this);
       button2=findViewById(R.id.btn2);
       button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn1:
                Toast.makeText(MainActivity.this,"您好btn1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Log.d("MainActivity","您好btn2");
                break;
                default:
                    break;
        }
    }
}
