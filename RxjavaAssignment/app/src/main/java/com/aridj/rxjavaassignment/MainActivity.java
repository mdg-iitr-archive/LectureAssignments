package com.aridj.rxjavaassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText userEditText;
    private Button searchButton;
    private TextView userNameTextView, bioTextView, repoSTextView, emailTextView, locationTextView;
    private ImageView profilePic;
    private ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        // Observable
        userEditText = (AppCompatEditText) findViewById(R.id.user_name_edit_text);
        searchButton = (Button) findViewById(R.id.search_button);

        //Subscriber
        userNameTextView = (TextView) findViewById(R.id.user_name_text_view);
        bioTextView = (TextView) findViewById(R.id.bio_text_view);
        repoSTextView = (TextView) findViewById(R.id.no_of_repos_text_view);
        emailTextView = (TextView) findViewById(R.id.email_text_view);
        locationTextView = (TextView) findViewById(R.id.location_text_view);
        profilePic = (ImageView) findViewById(R.id.user_image_view);

        bar = (ProgressBar) findViewById(R.id.loading_bar);


    }


    @Override
    protected void onStart() {
        super.onStart();

        Observable<String> myObservable = searchButtonObservable();
        myObservable
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        showProgressBar();
                        userNameTextView.setText("");
                        bioTextView.setText("");
                        locationTextView.setText("");
                        emailTextView.setText("");
                        repoSTextView.setText("");
                        profilePic.setImageDrawable(null);


                    }
                })
                .observeOn(Schedulers.io())
                .map(new Function<String, Observable<UserModel>>() {
                    @Override
                    public Observable<UserModel> apply(@NonNull String userName) throws Exception {
                        Retrofit retrofit = new Retrofit.Builder()
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .baseUrl("https://api.github.com/")
                                .build();

                        GithubApi githubService = retrofit.create(GithubApi.class);

                        return githubService.getUserInfo(userName);
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Observable<UserModel>>() {
                    @Override
                    public void accept(Observable<UserModel> result) throws Exception {
                        showResult(result);
                    }
                });

    }


    private Observable<String> searchButtonObservable(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<String> emitter) throws Exception {
                searchButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        emitter.onNext(userEditText.getText().toString());
                    }
                });

                emitter.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        searchButton.setOnClickListener(null);
                    }
                });
            }
        })
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(@NonNull String query) throws Exception {
                        return query.length()>0;
                    }
                });
    }

    private void showResult(final Observable<UserModel> result) {
        result.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserModel>() {
                    @Override
                    public void accept(UserModel userModel) throws Exception {
                        hideProgressBar();
                        userNameTextView.setText(userModel.getName());
                        bioTextView.setText(userModel.getBio());
                        locationTextView.setText(userModel.getLocation());
                        emailTextView.setText(userModel.getEmail());
                        repoSTextView.setText("No. of Public Repos : " + userModel.getPublicRepos());
                        Picasso.with(MainActivity.this)
                                .load(userModel.getAvatarUrl())
                                .placeholder(R.drawable.animated_placeholder)
                                .into(profilePic);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable error) throws Exception {
                        hideProgressBar();
                        // No User Found
                        if (error instanceof HttpException) {
                            Toast.makeText(MainActivity.this, "No User Found", Toast.LENGTH_SHORT).show();
                        }
                        // A network error happened
                        if (error instanceof IOException) {
                            Toast.makeText(MainActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void showProgressBar() {
        bar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        bar.setVisibility(View.GONE);
    }


}
