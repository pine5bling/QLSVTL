package com.example.qlsvtl.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.qlsvtl.R;
import com.example.qlsvtl.database.DatabaseHelper;
import com.example.qlsvtl.model.SinhVien;
import com.example.qlsvtl.model.SinhVienLop;

import java.util.ArrayList;
import java.util.List;

public class SinhVienActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    EditText edt1, edt2, edt3;

    Spinner spNamHoc;

    ListView lvSV;

    List<SinhVien> sinhVienList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);

        databaseHelper = new DatabaseHelper(this);

        edt1 = findViewById(R.id.edtTenSV);
        edt2 = findViewById(R.id.edtNamSinh);
        edt3 = findViewById(R.id.edtQueQuan);
        spNamHoc = findViewById(R.id.spNamHoc);
        Button btnSV = findViewById(R.id.btnThemSV);
        lvSV = findViewById(R.id.lvSV);

        setupSpinner();

        btnSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setTenSV(edt1.getText().toString());
                sinhVien.setNamSinh(Integer.parseInt(edt2.getText().toString()));
                sinhVien.setQueQuan(edt3.getText().toString());
                sinhVien.setNamHoc(spNamHoc.getSelectedItem().toString());
                themSV(sinhVien);
                edt1.setText("");
                edt2.setText("");
                edt3.setText("");
                spNamHoc.setSelection(0);
            }
        });
    }

    public void setupSpinner() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Nam 1");
        stringList.add("Nam 2");
        stringList.add("Nam 3");
        stringList.add("Nam 4");
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        spNamHoc.setAdapter(stringArrayAdapter);
    }

    public void setupListView() {
        sinhVienList = databaseHelper.layDSSinhVien();
        ArrayAdapter<SinhVien> sinhVienArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sinhVienList);
        lvSV.setAdapter(sinhVienArrayAdapter);
    }

    public void themSV(SinhVien sinhVien) {
        databaseHelper.themSinhVien(sinhVien);
        setupListView();
    }
}
