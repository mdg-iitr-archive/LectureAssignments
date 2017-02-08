package com.sdsmdg.hareshkh.lectureassignment.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sdsmdg.hareshkh.lectureassignment.R;

public class MainActivity extends AppCompatActivity {
    private Button rvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvBtn = (Button) findViewById(R.id.recycler_view_btn);
        rvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });
    }
}
