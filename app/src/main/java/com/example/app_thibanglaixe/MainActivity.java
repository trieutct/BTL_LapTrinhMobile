package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    ProgressBar progressBar;
    int timerValue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressbar);
        countDownTimer=new CountDownTimer(5000,85) {
            @Override
            public void onTick(long l) {
                timerValue=timerValue+2;
                progressBar.setProgress(timerValue);
            }
            @Override
            public void onFinish() {
                Intent intent=new Intent(MainActivity.this,MainTrangChuActivity.class);
                startActivity(intent);
            }
        }.start();

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(MainActivity.this,MainTrangChuActivity.class);
//                startActivity(intent);
//            }
//        },5000);
    }
}