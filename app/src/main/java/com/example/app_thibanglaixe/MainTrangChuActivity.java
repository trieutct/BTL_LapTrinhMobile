package com.example.app_thibanglaixe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

public class MainTrangChuActivity extends AppCompatActivity {
    CardView cardViewDeNgauNhien;
    CardView cardThiTheoBoDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trang_chu);

        cardViewDeNgauNhien=findViewById(R.id.cardViewDeNgauNhien);
        cardViewDeNgauNhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainTrangChuActivity.this,TrangThiActivity.class);
                startActivity(intent);
            }
        });

        cardThiTheoBoDe=findViewById(R.id.cardThiTheoBoDe);
        cardThiTheoBoDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainTrangChuActivity.this,DeThisActivity.class);
                startActivity(intent);
            }
        });
    }
}