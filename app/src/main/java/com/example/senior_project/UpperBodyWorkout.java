/**
 * <summary> This class allows users to enter, view, and delete lifts that they record.
 *     <para>
 *         Enter button allows for the data for each lift to be put into database.
 *         View button shows a screen of all lifts currently in database.
 *         Delete button will delete a lift based on the day you put in.
 *         Back button takes you back to the lifting options.
 *         Next button takes you to your next lift.
 *     </para>
 * </summary>
 */


package com.example.senior_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpperBodyWorkout extends AppCompatActivity implements View.OnClickListener {

    private EditText dayText, lift1Text, lift2Text, lift3Text, lift4Text, lift5Text;
    private Button enterLift, viewLift, deleteLift, backChooseScreen, nextLiftPage;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper);

        getUserInput();
        getButtonID();

        dbHelper = new DBHelper(this);

        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"Bench: 3x5", "BB Row: 3x5", "DB Bench: 3x5", "DB Shrugs: 3x5", "DB Curls: 3x5"};
        ArrayAdapter<String> adpt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adpt);


        enterLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewLiftToDBHelper();
                clearText();

            }
        });

        viewLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UpperBodyWorkout.this, WorkoutList.class));
            }
        });

        deleteLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String liftDelete = dayText.getText().toString();
                dbHelper.deleteLift(liftDelete);
                dayText.setText("");
            }
        });

        backChooseScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpperBodyWorkout.this, LiftingOptions.class);
                startActivity(intent);
            }
        });

        nextLiftPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpperBodyWorkout.this, LowerBodyWorkout.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {}

    public void getButtonID() {
        enterLift = findViewById(R.id.btnEnter);
        viewLift = findViewById(R.id.btnView);
        deleteLift = findViewById(R.id.btnDelete);
        backChooseScreen = findViewById(R.id.choose_screen);
        nextLiftPage = findViewById(R.id.btnNextWorkout1);
    }

    public void getUserInput() {
        dayText = findViewById(R.id.insertDay);
        lift1Text = findViewById(R.id.insertLift1);
        lift2Text = findViewById(R.id.insertLift2);
        lift3Text = findViewById(R.id.insertLift3);
        lift4Text = findViewById(R.id.insertLift4);
        lift5Text = findViewById(R.id.insertLift5);
    }

    public void addNewLiftToDBHelper() {
        String day = dayText.getText().toString();
        String lift_1 = lift1Text.getText().toString();
        String lift_2 = lift2Text.getText().toString();
        String lift_3 = lift3Text.getText().toString();
        String lift_4 = lift4Text.getText().toString();
        String lift_5 = lift5Text.getText().toString();
        dbHelper.addNewLift(day, lift_1, lift_2, lift_3, lift_4, lift_5);
    }

    public void clearText() {
        dayText.setText("");
        lift1Text.setText("");
        lift2Text.setText("");
        lift3Text.setText("");
        lift4Text.setText("");
        lift5Text.setText("");
    }

}
