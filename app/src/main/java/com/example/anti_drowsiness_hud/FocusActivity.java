package com.example.anti_drowsiness_hud;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FocusActivity extends AppCompatActivity {

    ImageView eyes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        eyes = findViewById(R.id.eyes_main);
        class ShakeEyes extends TimerTask {
            public void run() {
                animateView(eyes);
            }
        }
        TimerTask shakeEyes = new ShakeEyes();
        Timer timer1 = new Timer();

        timer1.scheduleAtFixedRate(shakeEyes, 1500000, 1500000);

    }
    public void animateView(View view){
        Animation shake = AnimationUtils.loadAnimation(this,R.anim.shake);
        view.startAnimation(shake);
    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(FocusActivity.this, ActivityHome.class));
        finish();

    }
}