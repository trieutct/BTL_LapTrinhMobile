package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.example.app_thibanglaixe.Adapter.DeThiAdapter;
import com.example.app_thibanglaixe.Model.DeThi;
import com.example.app_thibanglaixe.SQLite.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class DeThisActivity extends AppCompatActivity {
    List<DeThi> deThiList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_this);
        RecyclerView examRecyclerView = findViewById(R.id.examRecyclerView);
        //ArrayList<DeThi> examList = new ArrayList<>();
//        examList.add(new DeThi(1,"MD1","Đề Thi 1"));
//        examList.add(new DeThi(2,"MD2","Đề Thi 2"));
//        examList.add(new DeThi(3,"MD3","Đề Thi 3"));
//        examList.add(new DeThi(4,"MD4","Đề Thi 4"));
//        DeThiAdapter adapter = new DeThiAdapter(examList);
//        examRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
//        examRecyclerView.setAdapter(adapter);


        SQLiteHelper sqLiteHelper=new SQLiteHelper(DeThisActivity.this);
        sqLiteHelper.AddDeThi();
        deThiList=sqLiteHelper.getAllDeThi();
        DeThiAdapter adapter = new DeThiAdapter(deThiList);
        examRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        examRecyclerView.setAdapter(adapter);
    }
}