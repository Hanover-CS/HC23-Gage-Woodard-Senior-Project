package com.example.senior_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LiftingOptions extends AppCompatActivity implements View.OnClickListener {

    Button home_screen, power_lifting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        power_lifting = findViewById(R.id.power_lifting_screen);
        power_lifting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LiftingOptions.this, UpperBodyWorkout.class);
                startActivity(intent);
            }
        });

        home_screen = findViewById(R.id.home_screen_button);
        home_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LiftingOptions.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
