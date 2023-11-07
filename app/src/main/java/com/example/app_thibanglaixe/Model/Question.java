package com.example.app_thibanglaixe.Model;

public class Question {
    private long id;
    private String maDeThi;
    private String noiDungCauHoi;
    public Question() {
    }

    public Question(String maDeThi, String noiDungCauHoi) {
        this.maDeThi = maDeThi;
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaDeThi() {
        return maDeThi;
    }

    public void setMaDeThi(String maDeThi) {
        this.maDeThi = maDeThi;
    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }
}
