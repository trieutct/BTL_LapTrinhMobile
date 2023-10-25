package com.example.app_thibanglaixe.Model;

public class DeThiModel {
    int id;
    String TenDeThi;
    int image;

    public DeThiModel(int id, String tenDeThi, int image) {
        this.id = id;
        TenDeThi = tenDeThi;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDeThi() {
        return TenDeThi;
    }

    public void setTenDeThi(String tenDeThi) {
        TenDeThi = tenDeThi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
