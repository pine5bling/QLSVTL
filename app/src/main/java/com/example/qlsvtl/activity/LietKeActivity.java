package com.example.qlsvtl.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qlsvtl.R;
import com.example.qlsvtl.database.DatabaseHelper;
import com.example.qlsvtl.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class LietKeActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ListView lvLK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liet_ke);

        databaseHelper = new DatabaseHelper(this);

        lvLK = findViewById(R.id.lvLK);

        List<SinhVien> sinhVienList = databaseHelper.layDSLKSinhVien();
        ArrayAdapter<SinhVien> sinhVienArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sinhVienList);
        lvLK.setAdapter(sinhVienArrayAdapter);
    }
}
