package com.example.qlsvtl.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.qlsvtl.R;
import com.example.qlsvtl.database.DatabaseHelper;
import com.example.qlsvtl.model.Lop;

import java.util.List;

public class LopActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    EditText edt1, edt2;

    ListView lvLop;

    List<Lop> lopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop);

        databaseHelper = new DatabaseHelper(this);

        edt1 = findViewById(R.id.edtTenLop);
        edt2 = findViewById(R.id.edtMoTa);
        Button btnLop = findViewById(R.id.btnThemLop);
        lvLop = findViewById(R.id.lvLop);

        btnLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lop lop = new Lop();
                lop.setTenlop(edt1.getText().toString());
                lop.setMoTa(edt2.getText().toString());
                themLop(lop);
                edt1.setText("");
                edt2.setText("");
            }
        });

    }

    public void setupListView() {
        lopList = databaseHelper.layDSLop();
        ArrayAdapter<Lop> lopArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lopList);
        lvLop.setAdapter(lopArrayAdapter);
    }

    public void themLop(Lop lop) {
        databaseHelper.themLop(lop);
        setupListView();
    }

}
