package com.example.qlsvtl.activity;

import androidx.appcompat.app.AppCompatActivity;

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

public class SinhVienLopActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    EditText edt1;

    Spinner spSV, spLop, spKiHoc;

    ListView lvSVL;

    List<SinhVienLop> sinhVienLopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien_lop);

        databaseHelper = new DatabaseHelper(this);

        edt1 = findViewById(R.id.edtSoTinChi);
        spLop = findViewById(R.id.spIdLop);
        spSV = findViewById(R.id.spIdSV);
        spKiHoc = findViewById(R.id.spKiHoc);
        Button btnSVL = findViewById(R.id.btnThemSVL);
        lvSVL = findViewById(R.id.lvSVL);

        setupSpinnerIdLop();
        setupSpinnerIdLSV();
        setupSpinnerKiHoc();

        btnSVL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVienLop sinhVienLop = new SinhVienLop();
                sinhVienLop.setIdLop(Integer.parseInt(spLop.getSelectedItem().toString()));
                sinhVienLop.setIdSV(Integer.parseInt(spSV.getSelectedItem().toString()));
                sinhVienLop.setKiHoc(spKiHoc.getSelectedItem().toString());
                sinhVienLop.setSoTinChi(Integer.parseInt(edt1.getText().toString()));
                themSVL(sinhVienLop);
                spLop.setSelection(0);
                spSV.setSelection(0);
                spKiHoc.setSelection(0);
                edt1.setText("");
            }
        });
    }

    public void setupSpinnerIdLop() {
        List<Integer> integerList = databaseHelper.layDSIdLop();
        ArrayAdapter<Integer> integerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, integerList);
        spLop.setAdapter(integerArrayAdapter);
    }

    public void setupSpinnerIdLSV() {
        List<Integer> integerList = databaseHelper.layDSIdSV();
        ArrayAdapter<Integer> integerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, integerList);
        spSV.setAdapter(integerArrayAdapter);
    }

    public void setupSpinnerKiHoc() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Ki 1");
        stringList.add("Ki 2");
        stringList.add("Ki 3");
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        spKiHoc.setAdapter(stringArrayAdapter);
    }

    public void setupListView() {
        sinhVienLopList = databaseHelper.layDSSinhVienLop();
        ArrayAdapter<SinhVienLop> sinhVienArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sinhVienLopList);
        lvSVL.setAdapter(sinhVienArrayAdapter);
    }

    public void themSVL(SinhVienLop sinhVienLop) {
        databaseHelper.themSinhVienLop(sinhVienLop);
        setupListView();
    }
}
