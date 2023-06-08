package com.example.lab7_ph35654;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView log =findViewById(R.id.logo);
        TextView wecom =findViewById(R.id.wecom);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim1 );

        Thread thread =new Thread(){
            @Override
            public void run(){
                try {
                    log.startAnimation(animation);
                    wecom.startAnimation(animation);
                    sleep(3000);

                  startActivity(new Intent(bai1.this, bai2.class));
                }catch (Exception e){

                }
            }

        }; thread.start();

    }
}