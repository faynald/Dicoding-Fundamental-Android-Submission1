package com.farhanrv.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ShowDetailActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "extra_data";
    TextView tvUsername, tvName, tvLocation, tvCompany, tvRepository, tvFollowers, tvFollowing;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvUsername = findViewById(R.id.tv_detail_username);
        tvName = findViewById(R.id.tv_detail_name);
        tvLocation = findViewById(R.id.tv_detail_location);
        tvCompany = findViewById(R.id.tv_detail_company);
        imgPhoto = findViewById(R.id.img_detail_photo);
        tvRepository = findViewById(R.id.tv_detail_repository);
        tvFollowers = findViewById(R.id.tv_detail_followers);
        tvFollowing = findViewById(R.id.tv_detail_following);

        GithubUsers guParcel = getIntent().getParcelableExtra(EXTRA_DATA);
        getSupportActionBar().setTitle(guParcel.getName());

        tvUsername.setText(guParcel.getUsername());
        tvName.setText(guParcel.getName());
        tvLocation.setText(guParcel.getLocation());
        tvCompany.setText(guParcel.getCompany());
        imgPhoto.setImageResource(guParcel.getAvatar());
        tvRepository.setText(String.valueOf(guParcel.getRepository()));
        tvFollowers.setText(String.valueOf(guParcel.getFollowers()));
        tvFollowing.setText(String.valueOf(guParcel.getFollowing()));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}