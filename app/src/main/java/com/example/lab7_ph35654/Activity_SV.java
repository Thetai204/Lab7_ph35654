package com.example.lab7_ph35654;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Activity_SV extends AppCompatActivity {
    public static final String KEY_DATA = "data";
    public static final String KEY_SAVE = "data2.txt";
    ArrayList <HocSinh> list = new ArrayList<>();
    Adapter_SV adapter_sv  ;
    ActivityResultLauncher getData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==1){
                        Intent intent = result.getData();

                        HocSinh hocSinh = (HocSinh) intent.getSerializableExtra(KEY_DATA);
                        list.add(hocSinh);
                        ghi();
                        adapter_sv.notifyDataSetChanged();
                    }
                }
            }
    );
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_hs);

        ListView lv_hs = findViewById(R.id.lv_sv);
        Button them = findViewById(R.id.btn_them);
        doc();
        adapter_sv = new Adapter_SV(Activity_SV.this,list);
        lv_hs.setAdapter(adapter_sv);



        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_SV.this,ThemSV.class);
                getData.launch(intent);
            }
        });


    }
    public void ghi (){
        try {
            FileOutputStream fileOutputStream = openFileOutput(KEY_SAVE,MODE_PRIVATE);
            ObjectOutputStream objectOutputStream  = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (Exception e){

        }

    }

    public void doc(){
        try {
            FileInputStream fileInputStream = openFileInput(KEY_SAVE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (ArrayList<HocSinh>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (Exception e){

        }
    }
    public class Adapter_SV extends BaseAdapter{
    Activity activity;
        ArrayList <HocSinh> list = new ArrayList<>();

        public Adapter_SV(Activity activity, ArrayList<HocSinh> list) {
            this.activity = activity;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.modle_sv,parent,false);
            HocSinh hocSinh = list.get(position);
            TextView name = convertView.findViewById(R.id.tv_name);
            TextView id = convertView.findViewById(R.id.tv_id_sv);
            TextView diem = convertView.findViewById(R.id.tv_diem);
            Button xoa = convertView.findViewById(R.id.btn_xoa);
            name.setText(hocSinh.getName());
            id.setText(hocSinh.getIdSV());
            diem.setText(hocSinh.getDiem()+"");

            xoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    ghi();
                    notifyDataSetChanged();
                }
            });

            return convertView;
        }
    }
}
