/**
 * <summary> This is the home screen for the app when it opens.
 *     <para>
 *         This screen will always show when the app first opens.
 *         The next button takes you to the second screen of the app.
 *     </para>
 * </summary>
 */

package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {

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
        Intent intent = new Intent(MainScreen.this, LiftingOptions.class);
        startActivity(intent);
    }
}