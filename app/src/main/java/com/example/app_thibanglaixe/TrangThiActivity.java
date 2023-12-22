package com.example.app_thibanglaixe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_thibanglaixe.Model.Question;
import com.example.app_thibanglaixe.SQLite.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class TrangThiActivity extends AppCompatActivity {
    private int Phut = 19;
    private int Giay = 59;
    private Timer quiziTimer;
    //private Handler handler;
    private TextView txtThoiGianThi;
    private String MaDeThi,TenDeThi;
    private TextView tvDeThi;
    private TextView Questions;
    private  TextView txt_ChamDiem;
    private AppCompatButton option1,option2,option3,option4;
    private ImageView Image;
    private AppCompatButton nextBtn;
    private TextView NoiDungCauHoi;
    private List<Question> questionList;
    private int CauHienTai=0;
    private String UserSelected="";

    private List<Question> CauSai;
    private TextView btn_ThuLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_thi);
        txtThoiGianThi = findViewById(R.id.txtThoiGianThi);
        settimer();
        getId();
        MaDeThi=getIntent().getStringExtra("MaDeThi");
        TenDeThi=getIntent().getStringExtra("TenDeThi");
//        Log.d("QuestionInfo", MaDeThi);
//        Log.d("QuestionInfo", TenDeThi);
        tvDeThi.setText(TenDeThi);
        SQLiteHelper sqLiteHelper=new SQLiteHelper(TrangThiActivity.this);
        questionList=sqLiteHelper.getAllQuestionByMaDeThi(MaDeThi);
//        for (Question question : questionList) {
//            Log.d("QuestionInfo", "ID: " + question.getMaDeThi());
//            Log.d("QuestionInfo", "MaDeThi: " + question.getUserSelectedAnswer());
//            Log.d("QuestionInfo", "NoiDungCauHoi: " + question.getNoiDungCauHoi());
//        }
       // option4.setVisibility(View.GONE);

        Questions.setText(CauHienTai+1+"/"+questionList.size());
        NoiDungCauHoi.setText(questionList.get(0).getNoiDungCauHoi());
        option1.setText(questionList.get(0).getOption1());
        option2.setText(questionList.get(0).getOption2());
        if(questionList.get(3).getOption3().isEmpty())
        {
            option3.setVisibility(View.GONE);
        }
        else
        {
            option3.setVisibility(View.VISIBLE);
            option3.setText(questionList.get(0).getOption3());
        }
        if(questionList.get(0).getOption4().isEmpty())
        {
            option4.setVisibility(View.GONE);
        }
        else
        {
            option4.setVisibility(View.VISIBLE);
            option4.setText(questionList.get(0).getOption4());
        }
        if(questionList.get(0).getLinkAnh().isEmpty())
        {
            Image.setVisibility(View.GONE);
        }
        else
        {
            Image.setVisibility(View.VISIBLE);
            int Idimage=getResourceId(questionList.get(0).getLinkAnh(),"drawable", getPackageName());
            Image.setImageResource(Idimage);
        }
        txt_ChamDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TrangThiActivity.this,KetQuaActivity.class);
                intent.putExtra("DapAnDung",getCorrectAnswers()+"");
                intent.putExtra("DapAnSai",getInCorrectAnswers()+"");
                intent.putExtra("MaDeThi",MaDeThi);
                intent.putExtra("TenDeThi",TenDeThi);
                ArrayList<Question> questionErrors = new ArrayList<>();
//            //Log.d("aaa", getCorrectAnswers()+"" );
                for (Question question : questionList) {
                    if(!question.getUserSelectedAnswer().equals(question.getAnswer()))
                    {
                        questionErrors.add(question);
                    }
                }
                intent.putExtra("questionErrors", questionErrors);
                startActivity(intent);
            }
        });
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UserSelected.isEmpty())
                {
                    UserSelected=option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);
                    revalAnswer();
                    questionList.get(CauHienTai).setUserSelectedAnswer(UserSelected);
                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UserSelected.isEmpty())
                {
                    UserSelected=option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);

                    revalAnswer();

                    questionList.get(CauHienTai).setUserSelectedAnswer(UserSelected);
                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UserSelected.isEmpty())
                {
                    UserSelected=option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);

                    revalAnswer();

                    questionList.get(CauHienTai).setUserSelectedAnswer(UserSelected);
                }
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UserSelected.isEmpty())
                {
                    UserSelected=option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);

                    revalAnswer();

                    questionList.get(CauHienTai).setUserSelectedAnswer(UserSelected);
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UserSelected.isEmpty())
                {
                    Toast.makeText(TrangThiActivity.this,"Bạn chưa chọn đáp án",Toast.LENGTH_LONG).show();
                }
                else
                {
                    changNextQuestion();
                }
            }
        });
    }
    public int getResourceId(String pVariableName, String pResourcename, String pPackageName)
    {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    private void changNextQuestion()
    {
        CauHienTai++;
        if(CauHienTai+1==questionList.size())
        {
            nextBtn.setText("Nộp bài");
        }
        if(CauHienTai<questionList.size())
        {
            UserSelected="";
            option1.setBackgroundResource(R.drawable.round_back_options);
            option1.setTextColor(Color.parseColor("#1F6B88"));

            option2.setBackgroundResource(R.drawable.round_back_options);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_options);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_options);
            option4.setTextColor(Color.parseColor("#1F6BB8"));


            Questions.setText(CauHienTai+1+"/"+questionList.size());
            NoiDungCauHoi.setText(questionList.get(CauHienTai).getNoiDungCauHoi());
            option1.setText(questionList.get(CauHienTai).getOption1());
            option2.setText(questionList.get(CauHienTai).getOption2());
            if(questionList.get(CauHienTai).getOption3().isEmpty())
            {
                option3.setVisibility(View.GONE);
            }
            else
            {
                option3.setVisibility(View.VISIBLE);
                option3.setText(questionList.get(CauHienTai).getOption3());
            }
            if(questionList.get(CauHienTai).getOption4().isEmpty())
            {
                option4.setVisibility(View.GONE);
            }
            else
            {
                option4.setVisibility(View.VISIBLE);
                option4.setText(questionList.get(CauHienTai).getOption4());
            }
            if(questionList.get(CauHienTai).getLinkAnh().isEmpty())
            {
                Image.setVisibility(View.GONE);
            }
            else
            {
                Image.setVisibility(View.VISIBLE);
                int Idimage=getResourceId(questionList.get(CauHienTai).getLinkAnh(),"drawable", getPackageName());
                Image.setImageResource(Idimage);
            }
        }
        else
        {
            Intent intent=new Intent(TrangThiActivity.this,KetQuaActivity.class);
            intent.putExtra("DapAnDung",getCorrectAnswers()+"");
            intent.putExtra("DapAnSai",getInCorrectAnswers()+"");
            intent.putExtra("MaDeThi",MaDeThi);
            intent.putExtra("TenDeThi",TenDeThi);
            ArrayList<Question> questionErrors = new ArrayList<>();
//            //Log.d("aaa", getCorrectAnswers()+"" );
           for (Question question : questionList) {
               if(!question.getUserSelectedAnswer().equals(question.getAnswer()))
               {
                   questionErrors.add(question);
               }
            }
            intent.putExtra("questionErrors", questionErrors);
            startActivity(intent);
        }
    }
    private void revalAnswer()
    {
        final String getAnswer=questionList.get(CauHienTai).getAnswer();
        if(option1.getText().toString().equals(getAnswer))
        {
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer))
        {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals(getAnswer))
        {
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals(getAnswer))
        {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
    private void getId()
    {
        tvDeThi=findViewById(R.id.TenDeThi);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);

        nextBtn=findViewById(R.id.nextBtn);
        NoiDungCauHoi=findViewById(R.id.questionContent);

        Questions=findViewById(R.id.questions);
        Image=findViewById(R.id.image);
        txt_ChamDiem=findViewById(R.id.txtChamDiem);
    }
    private void settimer() {
        quiziTimer = new Timer();
        quiziTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Giay == 0 && Phut == 0) {
                    cancelTimer();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            View alertCustomDialog= LayoutInflater.from(TrangThiActivity.this).inflate(R.layout.waring_het_thoigian,null);
                            AlertDialog.Builder alertDialog=new AlertDialog.Builder(TrangThiActivity.this);
                            alertDialog.setView(alertCustomDialog);
                            btn_ThuLai=alertCustomDialog.findViewById(R.id.btn_ThuLai);
                            final AlertDialog dialog=alertDialog.create();
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog.setCanceledOnTouchOutside(false);
                            dialog.show();
                            btn_ThuLai.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(TrangThiActivity.this,MainTrangChuActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
                else if(Phut==2 && Giay==0)
                {
                    Phut--;
                    Giay =59;
                    txtThoiGianThi.setTextColor(Color.RED);
                }
                else if (Giay == 0) {
                    Phut--;
                    Giay = 59;
                } else {
                    Giay--;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateCountdown();
                    }
                });
            }
        }, 0, 1000);
    }
    private void updateCountdown() {
        String finalMinutes = String.format("%02d", Phut);
        String finalSeconds = String.format("%02d", Giay);
        txtThoiGianThi.setText(finalMinutes + ":" + finalSeconds);
    }
    private void cancelTimer() {
        if (quiziTimer != null) {
            quiziTimer.cancel();
            quiziTimer.purge();
            quiziTimer = null;
        }
    }
    private int getCorrectAnswers()
    {
        int correctAnswers=0;
        for(int i=0;i<questionList.size();i++)
        {
            final String getUserSelectedUser=questionList.get(i).getUserSelectedAnswer();
            final String getAnswer=questionList.get(i).getAnswer();
            if(getUserSelectedUser.equals(getAnswer))
            {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }
    private int getInCorrectAnswers()
    {
        int IncorrectAnswers=0;
        for(int i=0;i<questionList.size();i++)
        {
            final String getUserSelectedUser=questionList.get(i).getUserSelectedAnswer();
            final String getAnswer=questionList.get(i).getAnswer();
            if(!getUserSelectedUser.equals(getAnswer))
            {
                IncorrectAnswers++;
            }
        }
        return IncorrectAnswers;
    }
    @Override
    public void onBackPressed() {
        cancelTimer();
        super.onBackPressed();
    }
}
