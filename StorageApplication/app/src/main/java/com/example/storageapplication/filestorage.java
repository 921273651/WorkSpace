package com.example.storageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;

public class filestorage extends AppCompatActivity implements View.OnClickListener {
    private EditText edit_write, edit_read;
    private Button btn_wInner, btn_wOuter, btn_rInner, btn_rOuter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filestorage);

        edit_write = findViewById(R.id.edit_write);
        btn_wInner = findViewById(R.id.save_inner);
        btn_wInner.setOnClickListener(this);
        btn_wOuter = findViewById(R.id.save_outer);
        btn_wOuter.setOnClickListener(this);

        edit_read = findViewById(R.id.edit_read);
        btn_rInner = findViewById(R.id.load_inner);
        btn_rInner.setOnClickListener(this);
        btn_rOuter = findViewById(R.id.load_outer);
        btn_rOuter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_inner:
                String data_w_i = edit_write.getText().toString();
                if (TextUtils.isEmpty(data_w_i)) {
                    Toast.makeText(filestorage.this, "请输入需要写入文件的内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveInnerFile(data_w_i);
                Toast.makeText(filestorage.this, "数据已保存至内部存储文件", Toast.LENGTH_SHORT).show();
                break;

            case R.id.load_inner:
                String data_r_i = readInnerFile("znl.txt");
                if (!TextUtils.isEmpty(data_r_i)) {
                    edit_read.setText(data_r_i);
                }
                break;
            default:
                break;
        }
    }

    private void saveInnerFile(String data_w_i) {

        FileOutputStream fos = null;
        try {
            fos = openFileOutput("znl.txt", Context.MODE_PRIVATE);
            fos.write(data_w_i.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public String readInnerFile(String filename) {
        String context = "";
        FileInputStream fis = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fis = openFileInput("znl.txt");
            InputStreamReader insReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(insReader);
            String Line = reader.readLine();
            while (Line != null) {
                stringBuilder.append(Line).append('\n');
                Line = reader.readLine();
            }
            if (fis != null) {
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context = stringBuilder.toString();

        }
        return context;
    }
}

