package com.example.onlinejipmerhospitalappointments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    public static int SPLASH=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        ImageView i=(ImageView)findViewById(R.id.img);
        Animation top,bottom;
        top = AnimationUtils.loadAnimation(Splash.this,R.anim.top);
        bottom= AnimationUtils.loadAnimation(Splash.this,R.anim.bottom);
        i.startAnimation(top);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home=new Intent(Splash.this,MainActivity3.class);
                startActivity(home);
                finish();
            }
        },SPLASH);

    }
}
