package com.example.lab7_ph35654;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class bai2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2);
        ImageView imageView =findViewById(R.id.fan);
        Button btnfast =findViewById(R.id.btn_Fast);
        Button btnmedium=findViewById(R.id.btn_Medium);
        Button btnslow =findViewById(R.id.btn_slow);
        Button btnoff =findViewById(R.id.btn_off);
        Animation animation =AnimationUtils.loadAnimation(this,R.anim.anim2);
        btnslow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.setDuration(2000);
                imageView.startAnimation(animation);
            }
        });


        btnfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.setDuration(500);
                imageView.startAnimation(animation);
            }
        });
btnmedium.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        animation.setDuration(1000);
        imageView.startAnimation(animation);
    }
});
btnoff.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
animation.setDuration(0);
imageView.startAnimation(animation);
    }
});



    }
}
