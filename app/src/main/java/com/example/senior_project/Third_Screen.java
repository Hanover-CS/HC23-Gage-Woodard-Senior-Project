package com.example.senior_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Third_Screen extends AppCompatActivity implements View.OnClickListener {

    private EditText dayText, lift1Text, lift2Text, lift3Text, lift4Text, lift5Text;
    private Button enterLift, viewLift, deleteLift, backChooseScreen, nextLiftPage;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        dayText = findViewById(R.id.insertDay);
        lift1Text = findViewById(R.id.insertLift1);
        lift2Text = findViewById(R.id.insertLift2);
        lift3Text = findViewById(R.id.insertLift3);
        lift4Text = findViewById(R.id.insertLift4);
        lift5Text = findViewById(R.id.insertLift5);

        enterLift = findViewById(R.id.btnEnter);
        viewLift = findViewById(R.id.btnView);
        deleteLift = findViewById(R.id.btnDelete);
        backChooseScreen = findViewById(R.id.choose_screen);
        nextLiftPage = findViewById(R.id.btnNextWorkout1);

        dbHelper = new DBHelper(Third_Screen.this);

        enterLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = dayText.getText().toString();
                String lift_1 = lift1Text.getText().toString();
                String lift_2 = lift2Text.getText().toString();
                String lift_3 = lift3Text.getText().toString();
                String lift_4 = lift4Text.getText().toString();
                String lift_5 = lift5Text.getText().toString();

                dbHelper.addNewLift(day, lift_1, lift_2, lift_3, lift_4, lift_5);

                Toast.makeText(Third_Screen.this, "Lift Added!", Toast.LENGTH_SHORT).show();
                dayText.setText("");
                lift1Text.setText("");
                lift2Text.setText("");
                lift3Text.setText("");
                lift4Text.setText("");
                lift5Text.setText("");

            }
        });

        viewLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor liftResult = dbHelper.getLiftingData();
                if(liftResult.getCount() == 0) {
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (liftResult.moveToNext()) {
                    buffer.append("Day :"+" "+liftResult.getString(1)+"\n");
                    buffer.append("Bench :"+" "+liftResult.getString(2)+"\n");
                    buffer.append("Row :"+" "+liftResult.getString(3)+"\n");
                    buffer.append("DB Bench :"+" "+liftResult.getString(4)+"\n");
                    buffer.append("Shrugs :"+" "+liftResult.getString(5)+"\n");
                    buffer.append("Curl :"+" "+liftResult.getString(6)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Third_Screen.this);
                builder.setCancelable(true);
                builder.setTitle("Previous Lifts");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        deleteLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String liftDelete = dayText.getText().toString();
                dbHelper.deleteLift(liftDelete);

                Toast.makeText(Third_Screen.this, "Lift Deleted!", Toast.LENGTH_SHORT).show();
                dayText.setText("");
            }
        });

        backChooseScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Third_Screen.this, Second_Screen.class);
                startActivity(intent);
            }
        });

        nextLiftPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Third_Screen.this, Fourth_Screen.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {}

}
