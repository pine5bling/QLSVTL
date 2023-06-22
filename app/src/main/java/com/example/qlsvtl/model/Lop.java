package com.example.qlsvtl.model;

public class Lop {
    private int maLop;

    private String tenlop;

    private String moTa;

    public Lop(){}

    public String toString() {
        return "Lop { ma lop: " + maLop + "; ten lop: " + tenlop + "; mo ta : " + moTa + " }";
    }

    public Lop(int maLop, String tenlop, String moTa) {
        this.maLop = maLop;
        this.tenlop = tenlop;
        this.moTa = moTa;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
