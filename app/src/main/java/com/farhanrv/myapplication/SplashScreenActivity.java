package com.farhanrv.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    TextView tvSplashScreenTitle;
    ImageView imgGithub;
    Animation fadeinAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Github Users's");
        }

        tvSplashScreenTitle = findViewById(R.id.tv_submission_title);
        imgGithub = findViewById(R.id.img_github);
        fadeinAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        tvSplashScreenTitle.setAnimation(fadeinAnim);
        imgGithub.setAnimation(fadeinAnim);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        },3000);



    }
}