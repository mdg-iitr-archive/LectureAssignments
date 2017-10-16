package com.aridj.rxjavaassignment;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {

    @GET("users/{user}")
    Observable<UserModel> getUserInfo(@Path("user") String user);
}
