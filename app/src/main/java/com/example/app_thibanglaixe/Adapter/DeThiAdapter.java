package com.example.app_thibanglaixe.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_thibanglaixe.Model.DeThi;
import com.example.app_thibanglaixe.R;

import java.util.List;
public class DeThiAdapter extends RecyclerView.Adapter<DeThiAdapter.ExamViewHolder> {
    private List<DeThi> examList;
    public DeThiAdapter(List<DeThi> examList) {
        this.examList = examList;
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dethi_item, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        DeThi exam = examList.get(position);
        holder.examNameTextView.setText(exam.getTenDeThi());
    }

    @Override
    public int getItemCount() {
        return examList.size();
    }

    public class ExamViewHolder extends RecyclerView.ViewHolder {
        public TextView examNameTextView;
        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            examNameTextView = itemView.findViewById(R.id.examNameTextView);
        }
    }
}
