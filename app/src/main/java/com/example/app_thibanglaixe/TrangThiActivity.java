package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
public class TrangThiActivity extends AppCompatActivity {
    private int Phut = 2;
    private int Giay = 5;
    private Timer quiziTimer;
    private Handler handler;
    private TextView txtThoiGianThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_thi);
        txtThoiGianThi = findViewById(R.id.txtThoiGianThi);
        settimer();



        ///ok
    }

    private void settimer() {
        quiziTimer = new Timer();
        quiziTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Giay == 0 && Phut == 0) {
                    cancelTimer();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(TrangThiActivity.this, "Hết thời gian", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if(Phut==2 && Giay==00)
                {
                    Phut--;
                    Giay =59;
                    txtThoiGianThi.setTextColor(Color.RED);
                }
                else if (Giay == 0) {
                    Phut--;
                    Giay = 59;
                } else {
                    Giay--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateCountdown();
                    }
                });
            }
        }, 0, 1000);
    }
    private void updateCountdown() {
        String finalMinutes = String.format("%02d", Phut);
        String finalSeconds = String.format("%02d", Giay);
        txtThoiGianThi.setText(finalMinutes + ":" + finalSeconds);
    }

    private void cancelTimer() {
        if (quiziTimer != null) {
            quiziTimer.cancel();
            quiziTimer.purge();
            quiziTimer = null;
        }
    }
    @Override
    public void onBackPressed() {
        cancelTimer();
        super.onBackPressed();
    }
}
