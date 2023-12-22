package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.app_thibanglaixe.Model.Question;

import java.util.ArrayList;
import java.util.Random;

public class KetQuaActivity extends AppCompatActivity {

    private TextView DapAnDung;
    private TextView DapAnSai;
    AppCompatButton btn_choilai;
    AppCompatButton btn_exit;
    AppCompatButton btn_xemcausai;
    private  String MaDeThi,TenDeThi;
    ArrayList<Question> questionErrors = new ArrayList<>();

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
        Intent intent = getIntent();
        if (intent != null) {
             questionErrors = (ArrayList<Question>) intent.getSerializableExtra("questionErrors");
//             int i=0;
//            for (Question question : questionErrors) {
//                Log.d(++i+"", question.getNoiDungCauHoi());
//            }
        }
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
        btn_xemcausai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(KetQuaActivity.this,TrangXemCauSaiActivity.class);
                intent.putExtra("questionErrors", questionErrors);
                startActivity(intent);
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(KetQuaActivity.this,MainTrangChuActivity.class);
                startActivity(intent);
            }
        });
}}