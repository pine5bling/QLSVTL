package com.example.qlsvtl.database;

import android.content.Context;
import android.content.ContextWrapper;

import com.example.qlsvtl.model.Lop;
import com.example.qlsvtl.model.SinhVien;
import com.example.qlsvtl.model.SinhVienLop;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    private String FILE_NAME_SV = "FILE_NAME_SV";
    private String FILE_NAME_LOP = "FILE_NAME_LOP";
    private String FILE_NAME_SVL = "FILE_NAME_SVL";

    private String PATH = "PATH";

    private File fileSV;
    private File fileLop;
    private File fileSVL;

    private Context context;

    public DatabaseHelper(Context context) {
        this.context = context;
        ContextWrapper contextWrapper = new ContextWrapper(context.getApplicationContext());
        File internalfile = contextWrapper.getDir(PATH, Context.MODE_PRIVATE);
        fileSV = new File(internalfile, FILE_NAME_SV);
        fileLop = new File(internalfile, FILE_NAME_LOP);
        fileSVL = new File(internalfile, FILE_NAME_SVL);
    }

    /**
     * sinhVien
     */

    public List<SinhVien> layDSSinhVien() {
        List<SinhVien> sinhVienList = new ArrayList<>();
        try {
            FileInputStream os = new FileInputStream(fileSV);
            DataInputStream in = new DataInputStream(os);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strline = "";
            while ((strline = br.readLine()) != null) {
                String[] temp = strline.split("-");
                SinhVien sinhVien = new SinhVien(
                        Integer.parseInt(temp[0]),
                        temp[1],
                        Integer.parseInt(temp[2]),
                        temp[3],
                        temp[4]);
                sinhVienList.add(sinhVien);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sinhVienList;
    }

    public boolean themSinhVien(SinhVien sinhVien) {
        try {
            List<SinhVien> sinhVienList = layDSSinhVien();

            if (sinhVienList == null) {
                sinhVienList = new ArrayList<>();
                sinhVien.setMaSV(1);
            } else {
                sinhVien.setMaSV(sinhVienList.size() + 1);
            }
            sinhVienList.add(sinhVien);

            FileOutputStream os = new FileOutputStream(fileSV, true);
            os.write((sinhVien.getMaSV() + "-" +
                    sinhVien.getTenSV() + "-" +
                    sinhVien.getNamSinh() + "-" +
                    sinhVien.getQueQuan() + "-" +
                    sinhVien.getNamHoc() + "\n"
            ).getBytes());

            os.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Integer> layDSIdSV() {
        List<Integer> IdSVList = new ArrayList<>();
        List<SinhVien> sinhVienList = layDSSinhVien();
        for (SinhVien sinhVien : sinhVienList) {
            int idSV = sinhVien.getMaSV();
            IdSVList.add(idSV);
        }
        return IdSVList;
    }

    public List<SinhVien> layDSLKSinhVien() {
        List<SinhVien> sinhVienList = layDSSinhVien();
        List<SinhVien> filteredList = new ArrayList<>();
        for (SinhVien sinhVien : sinhVienList) {
            if (sinhVien.getTenSV().equals("Nam") && sinhVien.getNamHoc().equals("Nam 2")) {
                filteredList.add(sinhVien);
            }
        }
        return filteredList;
    }

    /**
     * lopHoc
     */

    public List<Lop> layDSLop() {
        List<Lop> lopList = new ArrayList<>();
        try {
            FileInputStream os = new FileInputStream(fileLop);
            DataInputStream in = new DataInputStream(os);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strline = "";
            while ((strline = br.readLine()) != null) {
                String[] temp = strline.split("-");
                Lop lop = new Lop(
                        Integer.parseInt(temp[0]),
                        temp[1],
                        temp[2]);
                lopList.add(lop);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lopList;
    }

    public boolean themLop(Lop lop) {
        try {
            List<Lop> lopList = layDSLop();

            if (lopList == null) {
                lopList = new ArrayList<>();
                lop.setMaLop(1);
            } else {
                lop.setMaLop(lopList.size() + 1);
            }
            lopList.add(lop);

            FileOutputStream os = new FileOutputStream(fileLop, true);
            os.write((lop.getMaLop() + "-" +
                    lop.getTenlop() + "-" +
                    lop.getMoTa() + "\n"
            ).getBytes());

            os.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Integer> layDSIdLop() {
        List<Integer> IdLopList = new ArrayList<>();
        List<Lop> lopList = layDSLop();
        for (Lop lop : lopList) {
            int idSV = lop.getMaLop();
            IdLopList.add(idSV);
        }
        return IdLopList;
    }

    /**
     * sinhVienLop
     */

    public List<SinhVienLop> layDSSinhVienLop() {
        List<SinhVienLop> lopList = new ArrayList<>();
        try {
            FileInputStream os = new FileInputStream(fileSVL);
            DataInputStream in = new DataInputStream(os);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strline = "";
            while ((strline = br.readLine()) != null) {
                String[] temp = strline.split("-");
                SinhVienLop sinhVienLop = new SinhVienLop(
                        Integer.parseInt(temp[0]),
                        Integer.parseInt(temp[1]),
                        temp[2],
                        Integer.parseInt(temp[3]));
                lopList.add(sinhVienLop);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lopList;
    }

    public boolean themSinhVienLop(SinhVienLop sinhVienLop) {
        try {
            FileOutputStream os = new FileOutputStream(fileSVL, true);
            os.write((sinhVienLop.getIdLop() + "-" +
                    sinhVienLop.getIdSV() + "-" +
                    sinhVienLop.getKiHoc() + "-" +
                    sinhVienLop.getSoTinChi() + "\n"
            ).getBytes());

            os.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
