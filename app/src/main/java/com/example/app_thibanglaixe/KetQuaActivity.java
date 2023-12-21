package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class KetQuaActivity extends AppCompatActivity {

    private TextView DapAnDung;
    private TextView DapAnSai;
    AppCompatButton btn_choilai;
    AppCompatButton btn_exit;
    AppCompatButton btn_xemcausai;
    private  String MaDeThi,TenDeThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        DapAnDung=findViewById(R.id.DapAnDung);
        DapAnSai=findViewById(R.id.DapAnSai);
        btn_choilai=findViewById(R.id.btn_choilai);
        btn_exit=findViewById(R.id.btn_exit);
        btn_xemcausai=findViewById(R.id.btn_xemcausai);



        DapAnDung.setText(getIntent().getStringExtra("DapAnDung")+"");
        DapAnSai.setText(getIntent().getStringExtra("DapAnSai")+"");
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        if (bundle != null) {
//            ArrayList<String> receivedList = bundle.getStringArrayList("myList");
//            for (String item : receivedList) {
//                Log.d("MyActivity", "Item: " + item);
//            }
//        }
        MaDeThi=getIntent().getStringExtra("MaDeThi");
        TenDeThi=getIntent().getStringExtra("TenDeThi");
        btn_choilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(KetQuaActivity.this,TrangThiActivity.class);
                intent.putExtra("MaDeThi",MaDeThi);
                intent.putExtra("TenDeThi",TenDeThi);
                startActivity(intent);
            }
        });
    }
}