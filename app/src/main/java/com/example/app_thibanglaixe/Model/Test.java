package com.example.app_thibanglaixe.Model;

public class Test {
    String image,Ten,NoiDung,Ngay;

    public Test(String image, String ten, String noiDung, String ngay) {
        this.image = image;
        Ten = ten;
        NoiDung = noiDung;
        Ngay = ngay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }
}
