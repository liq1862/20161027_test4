package com.example.user.a20161027_test4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int tmp, ch=-1;
    Button bt;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt9;
    boolean chks[] = new boolean[4];
    boolean tmps[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        bt5 = (Button) findViewById(R.id.button5);
        bt6 = (Button) findViewById(R.id.button6);
        bt7 = (Button) findViewById(R.id.button7);
        bt9 = (Button) findViewById(R.id.button9);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("標題");
                builder.setMessage("訊息");
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下確定", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下略過", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(MainActivity.this, "輸入為: " + ed.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("多選一");
                tmp = ch;
                builder.setSingleChoiceItems(R.array.drinks, tmp, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tmp = which;
                    }
                });
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (tmp >= 0) {
                            String[] str = getResources().getStringArray(R.array.drinks);
                            TextView tv = (TextView) findViewById(R.id.textView2);
                            ch = tmp;
                            tv.setText(str[ch]);
                        }
                    }
                });
                builder.show();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("多選一");

                builder.setItems(R.array.drinks, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] str = getResources().getStringArray(R.array.drinks);
                        TextView tv3 = (TextView) findViewById(R.id.textView3);
                        tv3.setText(str[which]);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmps = chks.clone();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("多選多");
                builder.setMultiChoiceItems(R.array.drinks, tmps, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        chks = tmps.clone();
                        String[] str = getResources().getStringArray(R.array.drinks);
                        TextView tv4 = (TextView) findViewById(R.id.textView4);
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i <= 3; i++) {
                            if (chks[i]) {
                                sb.append(str[i] + ",");
                            }
                        }

                        tv4.setText(sb);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tmps = chks.clone();
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("自訂");
                builder.setView(R.layout.layout1);


                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下確定", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下略過", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("自訂");
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                View myview = inflater.inflate(R.layout.layout1, null);
                Button bt = (Button) myview.findViewById(R.id.button8);

                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Click!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setView(myview);
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下確定", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "按下略過", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                pd.setTitle("工作中");
                pd.setMessage("請稍後....");
                pd.show();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pd.dismiss();
                            }
                        });
                    }
                }.start();
            }
        });
    }
}