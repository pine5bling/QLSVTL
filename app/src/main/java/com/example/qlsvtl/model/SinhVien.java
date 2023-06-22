package com.example.qlsvtl.model;

public class SinhVien {
    private int maSV;
    private String tenSV;
    private int namSinh;
    private String queQuan;
    private String namHoc;

    public SinhVien() {
    }

    public String toString() {
        return "Sinh vien { ma sv: " + maSV + "; ten sv: " + tenSV + "; nam sinh : " + namSinh + "; que quan: " + queQuan + "; nam hoc: " + namHoc + " }";
    }

    public SinhVien(int maSV, String tenSV, int namSinh, String queQuan, String namHoc) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }
}
