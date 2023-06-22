package com.example.qlsvtl.model;

public class SinhVienLop {
    private int idLop;

    private int idSV;

    private String kiHoc;

    private int soTinChi;

    public SinhVienLop(){}

    public String toString() {
        return "Sinh Vien Lop { ma lop: " + idLop + "; msv: " + idSV + "; ki hoc : " + kiHoc + "; so tin chi : " + soTinChi + " }";
    }

    public SinhVienLop(int idLop, int idSV, String kiHoc, int soTinChi) {
        this.idLop = idLop;
        this.idSV = idSV;
        this.kiHoc = kiHoc;
        this.soTinChi = soTinChi;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }

    public String getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(String kiHoc) {
        this.kiHoc = kiHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
