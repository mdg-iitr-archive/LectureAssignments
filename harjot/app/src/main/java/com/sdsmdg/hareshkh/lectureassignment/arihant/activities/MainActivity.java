package com.sdsmdg.hareshkh.lectureassignment.arihant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.sdsmdg.hareshkh.lectureassignment.R;

public class MainActivity extends AppCompatActivity {
    private Button rvBtn,corBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        rvBtn = (Button) findViewById(R.id.recycler_view_btn);
        rvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });
        corBtn = (Button) findViewById(R.id.cor_btn);
        corBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
            }
        });

    }
}
