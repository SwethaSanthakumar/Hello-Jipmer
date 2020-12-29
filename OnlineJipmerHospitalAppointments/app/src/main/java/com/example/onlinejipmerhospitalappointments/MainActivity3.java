package com.example.onlinejipmerhospitalappointments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity3 extends AppCompatActivity {
    private sliderAdapter msliderAdapter;
    ViewPager mSlideViewPager;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mSlideViewPager = (ViewPager) findViewById(R.id.slideviwepager);
        msliderAdapter = new sliderAdapter(this);
        mSlideViewPager.setAdapter(msliderAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Mytimer(), 5000, 5000);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this, Search.class);
                startActivity(i);
                finish();
            }
        });
    }
    public class Mytimer extends TimerTask {
        @Override
        public void run() {
            MainActivity3.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mSlideViewPager.getCurrentItem() == 0) {
                        mSlideViewPager.setCurrentItem(1);
                    }
                    else {
                        mSlideViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}