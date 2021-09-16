package com.farhanrv.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.farhanrv.myapplication.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
    Animation fadeInAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Github User's");
        }

        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        binding.tvSubmissionTitle.setAnimation(fadeInAnim);
        binding.imgGithub.setAnimation(fadeInAnim);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        },3000);



    }
}