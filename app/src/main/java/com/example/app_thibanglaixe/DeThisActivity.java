package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.app_thibanglaixe.Adapter.DeThiAdapter;
import com.example.app_thibanglaixe.Model.DeThi;
import com.example.app_thibanglaixe.Model.Question;
import com.example.app_thibanglaixe.SQLite.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class DeThisActivity extends AppCompatActivity {
    List<DeThi> deThiList;
    List<Question> questionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_this);
        RecyclerView examRecyclerView = findViewById(R.id.examRecyclerView);

        SQLiteHelper sqLiteHelper=new SQLiteHelper(DeThisActivity.this);
        sqLiteHelper.AddDeThi();
        deThiList=sqLiteHelper.getAllDeThi();
        DeThiAdapter adapter = new DeThiAdapter(deThiList);
        examRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        examRecyclerView.setAdapter(adapter);
        sqLiteHelper.AddQuestion();
//        questionList=sqLiteHelper.getAllQuestion();
//        for (Question question : questionList) {
//            Log.d("QuestionInfo", "ID: " + question.getMaDeThi());
//            Log.d("QuestionInfo", "MaDeThi: " + question.getUserSelectedAnswer());
//            Log.d("QuestionInfo", "NoiDungCauHoi: " + question.getNoiDungCauHoi());
//        }
    }
}