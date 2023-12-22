package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.app_thibanglaixe.Adapter.CauSaiAdapter;
import com.example.app_thibanglaixe.Adapter.DeThiAdapter;
import com.example.app_thibanglaixe.Model.Question;

import java.util.ArrayList;

public class TrangXemCauSaiActivity extends AppCompatActivity {
    ArrayList<Question> questionErrors = new ArrayList<>();
    private ImageView btn_back;
    private  String MaDeThi,TenDeThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_xem_cau_sai);
        btn_back=findViewById(R.id.back);

        MaDeThi=getIntent().getStringExtra("MaDeThi");
        TenDeThi=getIntent().getStringExtra("TenDeThi");


        Intent intent = getIntent();
        if (intent != null) {
            questionErrors = (ArrayList<Question>) intent.getSerializableExtra("questionErrors");
            int i=0;
            for (Question question : questionErrors) {
                Log.d(++i+"", question.getNoiDungCauHoi());
            }
        }
        RecyclerView examRecyclerView = findViewById(R.id.examRecyclerView);
        CauSaiAdapter adapter = new CauSaiAdapter(questionErrors);
        examRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        examRecyclerView.setAdapter(adapter);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TrangXemCauSaiActivity.this,TrangThiActivity.class);
                intent.putExtra("MaDeThi",MaDeThi);
                intent.putExtra("TenDeThi",TenDeThi);
                startActivity(intent);
            }
        });
    }
}