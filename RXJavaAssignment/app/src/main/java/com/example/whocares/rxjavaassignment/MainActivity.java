package com.example.whocares.rxjavaassignment;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.whocares.rxjavaassignment.Interfaces.GithubAPI;
import com.example.whocares.rxjavaassignment.Models.UserModel;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText githubUsername;
    private ImageView searchForUser, profilePic;
    private TextView mName, mLocation, mEmail, mBio, publicRepos, publicGists, mFollowers, mFollowing, errorText;
    private ConstraintLayout userInfo;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        Observable<String> observableForUsername = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<String> e) throws Exception {
                searchForUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        e.onNext(githubUsername.getText().toString());
                        errorText.setText("");
                    }
                });
            }
        });

        observableForUsername
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        mProgress.setVisibility(View.VISIBLE);
                        userInfo.setVisibility(View.GONE);
                    }
                })
                .observeOn(Schedulers.io())
                .map(new Function<String, Observable<UserModel>>() {

                    @Override
                    public Observable<UserModel> apply(@NonNull String s) throws Exception {
                        Retrofit retrofitInstance = new Retrofit.Builder()
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .baseUrl("https://api.github.com/")
                                .build();

                        final GithubAPI apiInstance = retrofitInstance.create(GithubAPI.class);
                        return apiInstance.getUser(s);
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Observable<UserModel>>() {
                    @Override
                    public void accept(Observable<UserModel> userModelObservable) throws Exception {
                        displayResults(userModelObservable);
                    }
                });
    }

    private void displayResults(Observable<UserModel> userModelObservable) {
        userModelObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserModel>() {
                    @Override
                    public void accept(UserModel userModel) throws Exception {
                        mName.setText(userModel.getName());
                        mLocation.setText(userModel.getLocation());
                        mEmail.setText(userModel.getEmail());
                        mBio.setText(userModel.getBio());
                        publicRepos.setText(userModel.getPublic_repos());
                        publicGists.setText(userModel.getPublic_gists());
                        mFollowers.setText(userModel.getFollowers());
                        mFollowing.setText(userModel.getFollowing());
                        Picasso.with(MainActivity.this)
                                .load(userModel.getAvatar_url())
                                .placeholder(getResources().getDrawable(R.drawable.thug))
                                .into(profilePic, new Callback() {
                                    @Override
                                    public void onSuccess() {
                                        mProgress.setVisibility(View.GONE);
                                        userInfo.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onError() {

                                    }
                                });

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mProgress.setVisibility(View.GONE);
                        userInfo.setVisibility(View.GONE);

                        if (throwable instanceof HttpException) {
                            errorText.setText("No such user exists on github");
                        }
                        if (throwable instanceof IOException) {
                            errorText.setText("Please check your network connection");
                        }
                    }
                });
    }

    private void initViews() {
        userInfo = (ConstraintLayout) findViewById(R.id.user_info);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        githubUsername = (EditText) findViewById(R.id.username);
        searchForUser = (ImageView) findViewById(R.id.search);
        profilePic = (ImageView) findViewById(R.id.profile_pic);
        errorText = (TextView) findViewById(R.id.error_text);
        mName = (TextView) findViewById(R.id.name_value);
        mLocation = (TextView) findViewById(R.id.location_value);
        mEmail = (TextView) findViewById(R.id.email_value);
        mBio = (TextView) findViewById(R.id.bio_value);
        publicRepos = (TextView) findViewById(R.id.public_repos_value);
        publicGists = (TextView) findViewById(R.id.public_gists_value);
        mFollowers = (TextView) findViewById(R.id.followers_value);
        mFollowing = (TextView) findViewById(R.id.following_value);
    }
}
