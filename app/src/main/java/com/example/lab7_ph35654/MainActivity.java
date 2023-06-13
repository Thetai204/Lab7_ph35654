package com.example.lab7_ph35654;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.im_logo);
        TextView textView = findViewById(R.id.tv_text);

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.animation1);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.animation2);


        new Thread(){
            @Override
            public void run() {
                super.run();
                int time = 0;
                imageView.startAnimation(animation1);
                textView.startAnimation(animation2);
                while (true){
                    try {

                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(time==1){
                        Intent intent = new Intent(MainActivity.this, login.class);
                        startActivity(intent);
                    }
                    time++;
                }
            }
        }.start();
    }
}