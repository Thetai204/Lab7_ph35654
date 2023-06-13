package com.example.lab7_ph35654;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThemSV extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addsv);
        EditText name = findViewById(R.id.et_hoTen);
        EditText id = findViewById(R.id.et_diaChi);
        EditText diem = findViewById(R.id.et_diem);
        Button add = findViewById(R.id.btn_Add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = name.getText().toString();
                String b = id.getText().toString();
                int c = Integer.parseInt(diem.getText().toString());
                Intent intent = new Intent();
                HocSinh hocSinh = new HocSinh(a,b,c);
                intent.putExtra(Activity_SV.KEY_DATA,hocSinh);
                setResult(1,intent);
                finish();
            }
        });
    }
}
