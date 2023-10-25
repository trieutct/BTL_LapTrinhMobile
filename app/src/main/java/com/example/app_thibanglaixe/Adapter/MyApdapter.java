package com.example.app_thibanglaixe.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_thibanglaixe.Model.DeThiModel;
import com.example.app_thibanglaixe.R;

import java.util.ArrayList;

public class MyApdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<DeThiModel> data;
    public MyApdapter(Context context, ArrayList<DeThiModel> data) {
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_listview_dethi, parent, false);
        }
        TextView Name = convertView.findViewById(R.id.Name);
        TextView NoiDung = convertView.findViewById(R.id.NoiDung);
        ImageView categoryImages = convertView.findViewById(R.id.categoryImages);

        DeThiModel item = (DeThiModel) getItem(i);

        Name.setText(item.getTenDeThi());
        NoiDung.setText(String.valueOf(item.getId()));
        categoryImages.setImageResource(item.getImage());
        return convertView;
    }
}
