package com.farhanrv.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class GithubUsers implements Parcelable {
    private String username, name, location, company, repository, followers, following;
    private int avatar;

    protected GithubUsers(Parcel in) {
        username = in.readString();
        name = in.readString();
        location = in.readString();
        company = in.readString();
        repository = in.readString();
        followers = in.readString();
        following = in.readString();
        avatar = in.readInt();
    }

    public static final Creator<GithubUsers> CREATOR = new Creator<GithubUsers>() {
        @Override
        public GithubUsers createFromParcel(Parcel in) {
            return new GithubUsers(in);
        }

        @Override
        public GithubUsers[] newArray(int size) {
            return new GithubUsers[size];
        }
    };

    public GithubUsers() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(name);
        parcel.writeString(location);
        parcel.writeString(company);
        parcel.writeString(repository);
        parcel.writeString(followers);
        parcel.writeString(following);
        parcel.writeInt(avatar);
    }
}
