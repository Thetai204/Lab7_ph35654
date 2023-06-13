package com.example.lab7_ph35654;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class fan extends AppCompatActivity {
    ImageView fan;
    Animation animation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fan);
        Button btnRun = findViewById(R.id.btn_on);
        Button btnMin = findViewById(R.id.btn_min);
        Button btnMedium = findViewById(R.id.btn_medium);
        Button btnMax = findViewById(R.id.btn_max);
        Button btnOff = findViewById(R.id.btn_off);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationfan);

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StartFan(1000);
            }
        });

        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartFan(1500);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartFan(1000);
            }
        });
        btnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartFan(200);
            }
        });
        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndFan();


            }
        });


    }
    private void StartFan(long speed ){
        fan= findViewById(R.id.im_fan);
        animation = AnimationUtils.loadAnimation(this,R.anim.animationfan);
        Runnable run = new Runnable() {
            @Override
            public void run() {
                fan.animate().rotation(360)
                        .withEndAction(this)
                        .setDuration(speed)
                        .setInterpolator(new LinearInterpolator())

                        .start();

            }
        };

//            fan.animate().rotation(360)
//                    .withEndAction(run)
//                    .setDuration(1000)
//                    .setInterpolator(new LinearInterpolator())
//                    .start();

animation.setDuration(speed);
fan.startAnimation(animation);
    }
    private  void EndFan(){
        ImageView fan = findViewById(R.id.im_fan);
        animation = AnimationUtils.loadAnimation(this,R.anim.animationfan);
        animation.setDuration(0);
        fan.startAnimation(animation);
    }
}
