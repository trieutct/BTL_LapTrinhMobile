package com.example.app_thibanglaixe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
public class TrangThiActivity extends AppCompatActivity {
    private int Phut = 2;
    private int Giay = 5;
    private Timer quiziTimer;
    //private Handler handler;
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
                            View alertCustomDialog= LayoutInflater.from(TrangThiActivity.this).inflate(R.layout.waring_het_thoigian,null);
                            AlertDialog.Builder alertDialog=new AlertDialog.Builder(TrangThiActivity.this);
                            alertDialog.setView(alertCustomDialog);
                            final AlertDialog dialog=alertDialog.create();
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog.setCanceledOnTouchOutside(false);
                            dialog.show();
                        }
                    });
                }
                else if(Phut==2 && Giay==00)
                {
                    Phut--;
                    Giay =5;
                    txtThoiGianThi.setTextColor(Color.RED);
                }
                else if (Giay == 0) {
                    Phut--;
                    Giay = 5;
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
