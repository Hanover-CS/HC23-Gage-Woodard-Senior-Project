package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button second_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        second_screen = findViewById(R.id.second_screen_button);
        second_screen.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, LiftingOptions.class);
        startActivity(intent);
    }
}