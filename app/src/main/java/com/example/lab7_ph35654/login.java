package com.example.lab7_ph35654;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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

public class login extends AppCompatActivity {
    public static final String KEY_USER = "user";
    public static final String KEY_PASS = "pass";
    String KEY_DATA = "data.txt";
    ArrayList<User> Acc = new ArrayList<>();
    String chUser = null;
    String chPass = null;
    CheckBox cboSave;
    ActivityResultLauncher getData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 1) {
                        Intent intent = result.getData();
                        Bundle bundle = intent.getExtras();
                        EditText user = findViewById(R.id.et_username);
                        EditText pass = findViewById(R.id.et_password);
                        chUser = bundle.getString(KEY_USER);
                        chPass = bundle.getString(KEY_PASS);
                        user.setText(chUser);
                        pass.setText(chPass);

                    }
                }
            }
    );

    public void ghi (){
        try {
            FileOutputStream fileOutputStream = openFileOutput(KEY_DATA,MODE_PRIVATE);
            ObjectOutputStream objectOutputStream  = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Acc);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (Exception e){

        }

    }

    public void doc(){
        try {
            FileInputStream fileInputStream = openFileInput(KEY_DATA);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Acc = (ArrayList<User>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (Exception e){

        }
    }
    private static final String KEY_PUSH = "nho";
    private static final String KEY_SAVE = "luu";
    public void luu (String user , String pass,boolean save){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PUSH,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER,user);
        editor.putString(KEY_PASS,pass);
        editor.putBoolean(KEY_SAVE,save);
        editor.apply();
    }
    public void checkBoolean (EditText a,EditText b){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PUSH,MODE_PRIVATE);
        String user = sharedPreferences.getString(KEY_USER,"");
        String pass = sharedPreferences.getString(KEY_PASS,"");
        boolean save = sharedPreferences.getBoolean(KEY_SAVE,false);
        cboSave.setChecked(save);
        if(cboSave.isChecked()==true){
            a.setText(user);
            b.setText(pass);
        }
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        if(Acc.size()<=0){
            Acc.add(new User("jhágfkýgdfkjhsdfjhshjfsd","sdhgfúgdfuhskdbfsdfds"));
        }
        EditText user = findViewById(R.id.et_username);
        EditText pass = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnSigin = findViewById(R.id.btn_sigin);
        cboSave = findViewById(R.id.cbo_save_user);
        cboSave.setChecked(true);

        Log.e("checkkkkkkkkkkkkk1", "onCreate: " + cboSave.isSelected());

       doc();
        chUser = Acc.get(0).getUserName();
        chPass = Acc.get(0).getPassWord();
       checkBoolean(user,pass);
        btnSigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, sigin.class);
                getData.launch(intent);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUser = user.getText().toString();
                String sPass = pass.getText().toString();
                if (!sUser.equals(chUser) && !sPass.equals(chPass)) {
                    Log.e("checkkkkkkkkkkkkk2", "onCreate: " + cboSave.isSelected());
                    Toast.makeText(login.this, "Sai tên user hoặc mật khẩu vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                } else {

                    if(cboSave.isChecked()){
                       User user1 = Acc.get(0);
                       user1.setUserName(sUser);
                       user1.setPassWord(sPass);
                       user1.setSave(true);
                        ghi();
                        luu(Acc.get(0).getUserName(),Acc.get(0).getPassWord(),cboSave.isChecked());
                    }else {
                        Toast.makeText(login.this, "ghi thất bại", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, Activity_SV.class);
                    Log.e("checkkkkkkkkkkkkk2", "onCreate: " + cboSave.isSelected());
                    startActivity(intent);
                }
            }
        });

    }
}
