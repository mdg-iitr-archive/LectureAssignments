package com.example.whocares.rxjavaassignment.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by whocares on 17/10/17.
 */

public class UserModel {

    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private String location;
    @SerializedName("email")
    private String email;
    @SerializedName("bio")
    private String bio;
    @SerializedName("public_repos")
    private String public_repos;
    @SerializedName("public_gists")
    private String public_gists;
    @SerializedName("followers")
    private String followers;
    @SerializedName("following")
    private String following;
    @SerializedName("avatar_url")
    private String avatar_url;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }

    public void setPublic_gists(String public_gists) {
        this.public_gists = public_gists;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public void setFollowing(String following) {
        this.following = following;
    }


    //getters

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public String getPublic_gists() {
        return public_gists;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }
}
