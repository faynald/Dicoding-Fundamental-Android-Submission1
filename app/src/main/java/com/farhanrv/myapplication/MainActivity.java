package com.farhanrv.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvGithubUsers;
    private final ArrayList<GithubUsers> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGithubUsers = findViewById(R.id.rv_github_users);
        rvGithubUsers.setHasFixedSize(true);

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvGithubUsers.setLayoutManager(new LinearLayoutManager(this));
        GithubUsersAdapter guAdapter = new GithubUsersAdapter(list);
        rvGithubUsers.setAdapter(guAdapter);

        final String[] githubUsername = getResources().getStringArray(R.array.username);
        final String[] githubName = getResources().getStringArray(R.array.name);
        final String[] githubUserCompany = getResources().getStringArray(R.array.company);
        final String[] githubUserLocation = getResources().getStringArray(R.array.location);
        final String[] githubUserRepository = getResources().getStringArray(R.array.repository);
        final String[] githubUserFollowers = getResources().getStringArray(R.array.followers);
        final String[] githubUserFollowing = getResources().getStringArray(R.array.following);
        final TypedArray githubUserAvatar = getResources().obtainTypedArray(R.array.avatar);
        for (int position = 0; position < githubName.length; position++) {
            GithubUsers gu = new GithubUsers();
            gu.setUsername(githubUsername[position]);
            gu.setName(githubName[position]);
            gu.setCompany(githubUserCompany[position]);
            gu.setLocation(githubUserLocation[position]);
            gu.setRepository(githubUserRepository[position]);
            gu.setFollowers(githubUserFollowers[position]);
            gu.setFollowing(githubUserFollowing[position]);
            gu.setAvatar(githubUserAvatar.getResourceId(position, 0));
            list.add(gu);
        }
        githubUserAvatar.recycle();
        guAdapter.setOnItemClickCallback(data -> {
            Intent intent = new Intent(MainActivity.this, ShowDetailActivity.class);
            intent.putExtra(ShowDetailActivity.EXTRA_DATA, data);
            startActivity(intent);
        });
    }

}