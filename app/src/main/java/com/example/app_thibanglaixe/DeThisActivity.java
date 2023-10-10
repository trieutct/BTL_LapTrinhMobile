package com.example.app_thibanglaixe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class DeThisActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_this);
        listView=findViewById(R.id.listView);
        ArrayList<HashMap<String, Object>> list_item=new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("image",R.drawable.baseline_arrow_back_ios_24);
            hashMap.put("text","Thu "+i);
            hashMap.put("text1","text 1 "+i);
            list_item.add(hashMap);
        }
        String[] from={"image","text","text1"};
        int to[]={R.id.imageView,R.id.textView,R.id.textView1};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list_item,R.layout.layout_listview_dethi,from,to);
        listView.setAdapter(simpleAdapter);
    }
}