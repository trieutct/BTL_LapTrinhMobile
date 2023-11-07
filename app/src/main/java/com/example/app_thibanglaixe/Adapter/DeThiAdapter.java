package com.example.app_thibanglaixe.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_thibanglaixe.Model.DeThi;
import com.example.app_thibanglaixe.R;
import com.example.app_thibanglaixe.TrangThiActivity;

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
        holder.examNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), exam.getTenDeThi(), Toast.LENGTH_SHORT).show();
                Intent itent=new Intent(view.getContext(), TrangThiActivity.class);
                itent.putExtra("MaDeThi",exam.getMaDeThi());
                view.getContext().startActivity(itent);
            }
        });
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
