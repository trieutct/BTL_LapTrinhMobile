package com.example.app_thibanglaixe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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
    private int Phut = 19;
    private int Giay = 60;
    private Timer quiziTimer;
    //private Handler handler;
    private TextView txtThoiGianThi;
    private String MaDeThi,TenDeThi;
    private TextView tvDeThi;
    private AppCompatButton option1,option2,option3,option4;
    private AppCompatButton nextBtn;
    private TextView NoiDungCauHoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_thi);
        txtThoiGianThi = findViewById(R.id.txtThoiGianThi);
        settimer();
        getId();
        MaDeThi=getIntent().getStringExtra("MaDeThi");
        TenDeThi=getIntent().getStringExtra("TenDeThi");
        tvDeThi.setText(TenDeThi);
        //Toast.makeText(this, MaDeThi, Toast.LENGTH_SHORT).show();
    }
    private void getId()
    {
        tvDeThi=findViewById(R.id.TenDeThi);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);

        nextBtn=findViewById(R.id.nextBtn);
        NoiDungCauHoi=findViewById(R.id.questionContent);
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
                else if(Phut==2 && Giay==0)
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
