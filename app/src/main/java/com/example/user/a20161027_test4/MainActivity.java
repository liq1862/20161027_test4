package com.example.user.a20161027_test4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt;
    Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt =(Button) findViewById(R.id.button);
        bt2 =(Button) findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("標題");
                builder.setMessage("訊息");
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"按下確定",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"按下取消",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"按下略過",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {     //顯示輸入訊息框
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("輸入");
                builder.setMessage("請輸入: ");
                final EditText ed = new EditText(MainActivity.this);
                builder.setView(ed);

                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"輸入為: "+ed.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}
