package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.app_thibanglaixe.Adapter.MyApdapter;
import com.example.app_thibanglaixe.Model.DeThiModel;

import java.util.ArrayList;
import java.util.HashMap;

public class DeThisActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_this);
        listView=findViewById(R.id.listView);
//        ArrayList<HashMap<String, Object>> list_item=new ArrayList<>();
//        for(int i=0;i<4;i++)
//        {
//            HashMap<String,Object> hashMap=new HashMap<>();
//            hashMap.put("image",R.drawable.trieu);
//            hashMap.put("Name","Trinh Cong Trieu "+i);
//            hashMap.put("NoiDung","Cho em đi học muộn "+i);
//            list_item.add(hashMap);
//        }
//        String[] from={"image","Name","NoiDung"};
//        int to[]={R.id.imageView,R.id.Name,R.id.NoiDung};
//        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list_item,R.layout.layout_listview_dethi,from,to);
//        listView.setAdapter(simpleAdapter);


        ArrayList<DeThiModel> list = new ArrayList<>();

        list.add(new DeThiModel(1,"Trịnh Công Triệu",R.drawable.trieu));
        list.add(new DeThiModel(2,"Phạm Khắc Huy",R.drawable.trieu));
        list.add(new DeThiModel(3,"Phạm Khắc Huy",R.drawable.trieu));
        list.add(new DeThiModel(4,"Phạm Khắc Huy",R.drawable.trieu));
        MyApdapter adapter=new MyApdapter(this,list);
        listView.setAdapter(adapter);
    }
}