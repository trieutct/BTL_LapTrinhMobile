package com.example.app_thibanglaixe.Model;

public class DeThi {
    private long id;
    private String maDeThi;
    private String tenDeThi;

    public DeThi() {
        // Mặc định constructor
    }

    public DeThi(String maDeThi, String tenDeThi) {
        this.maDeThi = maDeThi;
        this.tenDeThi = tenDeThi;
    }

    // Getter và Setter cho các trường dữ liệu

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

    public String getTenDeThi() {
        return tenDeThi;
    }

    public void setTenDeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }
}
