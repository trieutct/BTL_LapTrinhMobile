package com.example.app_thibanglaixe.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_thibanglaixe.Model.DeThi;
import com.example.app_thibanglaixe.Model.Question;
import com.example.app_thibanglaixe.R;
import com.example.app_thibanglaixe.TrangThiActivity;

import java.util.List;

public class CauSaiAdapter extends RecyclerView.Adapter<CauSaiAdapter.ExamViewHolder>{
    private List<Question> examList;
    public CauSaiAdapter(List<Question> examList) {
        this.examList = examList;
    }
    @NonNull
    @Override
    public CauSaiAdapter.ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_causai_item, parent, false);
        return new CauSaiAdapter.ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CauSaiAdapter.ExamViewHolder holder, int position) {
        Question exam = examList.get(position);
        holder.CauHoi.setText(position+". "+exam.getNoiDungCauHoi());
        holder.option1.setText(exam.getOption1());
        holder.option2.setText(exam.getOption2());
        holder.option3.setText(exam.getOption3());
        holder.option4.setText(exam.getOption4());
        if(exam.getOption1().equals(exam.getAnswer()))
        {
            holder.option1.setTextColor(Color.parseColor("#FF0000"));
        }
         if(exam.getOption2().equals(exam.getAnswer()))
        {
            holder.option2.setTextColor(Color.parseColor("#FF0000"));
        }
        if(exam.getOption3().equals(exam.getAnswer()))
        {
            holder.option3.setTextColor(Color.parseColor("#FF0000"));
        }
        if(exam.getOption4().equals(exam.getAnswer()))
        {
            holder.option4.setTextColor(Color.parseColor("#FF0000"));
        }
        if(exam.getLinkAnh().isEmpty())
        {
            holder.imageView.setVisibility(View.GONE);
        }
        else
        {
            holder.imageView.setVisibility(View.VISIBLE);
//            holder.imageView.setImageResource();
        }
    }
    @Override
    public int getItemCount() {
        return examList.size();
    }
    public class ExamViewHolder extends RecyclerView.ViewHolder {
        public TextView CauHoi;
        public TextView option1;
        public TextView option2;
        public TextView option3;
        public TextView option4;
        public ImageView imageView;
        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            CauHoi = itemView.findViewById(R.id.CauHoi);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
            imageView=itemView.findViewById(R.id.Image);
        }
    }
}
