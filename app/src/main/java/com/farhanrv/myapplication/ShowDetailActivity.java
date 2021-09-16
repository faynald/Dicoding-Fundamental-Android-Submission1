package com.farhanrv.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.farhanrv.myapplication.databinding.ActivityShowDetailBinding;

public class ShowDetailActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShowDetailBinding binding = ActivityShowDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        GithubUsers guParcel = getIntent().getParcelableExtra(EXTRA_DATA);
        getSupportActionBar().setTitle(guParcel.getName());

        binding.tvDetailUsername.setText(guParcel.getUsername());
        binding.tvDetailName.setText(guParcel.getName());
        binding.tvDetailLocation.setText(guParcel.getLocation());
        binding.tvDetailCompany.setText(guParcel.getCompany());
        binding.imgDetailPhoto.setImageResource(guParcel.getAvatar());
        binding.tvDetailRepository.setText(String.valueOf(guParcel.getRepository()));
        binding.tvDetailFollowers.setText(String.valueOf(guParcel.getFollowers()));
        binding.tvDetailFollowing.setText(String.valueOf(guParcel.getFollowing()));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}