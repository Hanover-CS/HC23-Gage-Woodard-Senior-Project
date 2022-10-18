package com.example.senior_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Second_Screen extends AppCompatActivity implements View.OnClickListener {

    Button third_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        third_screen = findViewById(R.id.third_screen_button);
        third_screen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Second_Screen.this, Third_Screen.class);
        startActivity(intent);
    }
}
