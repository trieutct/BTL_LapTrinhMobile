package com.example.app_thibanglaixe.Model;

public class Question {
    private String MaDeThi;
    private String NoiDungCauHoi;
    private String Option1,Option2,Option3,Option4;
    private String UserSelectedAnswer,Answer;
    public Question() {
    }

    public Question(String maDeThi, String noiDungCauHoi, String option1, String option2, String option3, String option4, String userSelectedAnswer, String answer) {
        MaDeThi = maDeThi;
        NoiDungCauHoi = noiDungCauHoi;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        UserSelectedAnswer = userSelectedAnswer;
        Answer = answer;
    }

    public String getMaDeThi() {
        return MaDeThi;
    }

    public void setMaDeThi(String maDeThi) {
        MaDeThi = maDeThi;
    }

    public String getNoiDungCauHoi() {
        return NoiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        NoiDungCauHoi = noiDungCauHoi;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public String getUserSelectedAnswer() {
        return UserSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        UserSelectedAnswer = userSelectedAnswer;
    }

    public String getAnswer() {
        return Answer;
    }
    public void setAnswer(String answer) {
        Answer = answer;
    }
}
