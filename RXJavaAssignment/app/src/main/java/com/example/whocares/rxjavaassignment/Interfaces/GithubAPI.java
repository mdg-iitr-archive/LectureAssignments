package com.example.whocares.rxjavaassignment.Interfaces;

import com.example.whocares.rxjavaassignment.Models.UserModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by whocares on 17/10/17.
 */

public interface GithubAPI {
@GET("users/{username}")
Observable<UserModel> getUser(@Path("username") String username);
}
