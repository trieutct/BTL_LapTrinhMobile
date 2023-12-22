package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.app_thibanglaixe.Adapter.CauSaiAdapter;
import com.example.app_thibanglaixe.Adapter.DeThiAdapter;
import com.example.app_thibanglaixe.Model.Question;

import java.util.ArrayList;

public class TrangXemCauSaiActivity extends AppCompatActivity {
    ArrayList<Question> questionErrors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_xem_cau_sai);
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
    }
}