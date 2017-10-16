package com.aridj.rxjavaassignment;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by arihant on 16/10/17.
 */

public interface GithubService {

    @GET("users/{user}")
    Observable<Github> getUserInfo(@Path("user") String user);
}