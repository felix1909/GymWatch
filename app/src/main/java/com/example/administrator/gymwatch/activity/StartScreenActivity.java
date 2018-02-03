package com.example.administrator.gymwatch.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.gymwatch.R;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }

    public void screenTapped(View view) {
        Intent i = new Intent(StartScreenActivity.this, MainActivity.class);
        startActivity(i);
    }
}