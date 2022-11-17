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

public class LowerBodyWorkout extends AppCompatActivity implements View.OnClickListener {

    private DBHelper dbHelper;
    private Button enterLift, viewLift, deleteLift, backScreen, nextScreen;
    private EditText dayText, lift1Text, lift2Text, lift3Text, lift4Text, lift5Text;
    private AlertDialog.Builder builder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower);

        dbHelper = new DBHelper(LowerBodyWorkout.this);

        getButtonID();
        getUserInput();

        enterLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewLiftToDBHelper();
                Toast.makeText(LowerBodyWorkout.this, "Lift Added!", Toast.LENGTH_SHORT).show();
                clearEditText();
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
                while(liftResult.moveToNext()) {
                    addLiftingData(buffer, liftResult);
                }
                showPreviousLifts(buffer);
            }
        });

        deleteLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String liftDelete = dayText.getText().toString();
                dbHelper.deleteLift(liftDelete);
                Toast.makeText(LowerBodyWorkout.this, "Lift Deleted!", Toast.LENGTH_SHORT).show();
                clearEditText();
            }
        });

        backScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LowerBodyWorkout.this, UpperBodyWorkout.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {}

    public void getButtonID() {
        enterLift = findViewById(R.id.btnEnterWorkout2);
        viewLift = findViewById(R.id.btnViewWorkout2);
        deleteLift = findViewById(R.id.btnDeleteWorkout2);
        backScreen = findViewById(R.id.previousWorkout);
        nextScreen = findViewById(R.id.btnNextWorkout2);
    }

    public void getUserInput() {
        dayText = findViewById(R.id.insertDay2);
        lift1Text = findViewById(R.id.insertLift1day2);
        lift2Text = findViewById(R.id.insertLift2day2);
        lift3Text = findViewById(R.id.insertLift3day2);
        lift4Text = findViewById(R.id.insertLift4day2);
        lift5Text = findViewById(R.id.insertLift5day2);
    }

    public void addNewLiftToDBHelper() {
        String day2 = dayText.getText().toString();
        String lift1 = lift1Text.getText().toString();
        String lift2 = lift2Text.getText().toString();
        String lift3 = lift3Text.getText().toString();
        String lift4 = lift4Text.getText().toString();
        String lift5 = lift5Text.getText().toString();
        dbHelper.addNewLift(day2, lift1, lift2, lift3, lift4, lift5);
    }

    public void clearEditText() {
        dayText.setText("");
        lift1Text.setText("");
        lift2Text.setText("");
        lift3Text.setText("");
        lift4Text.setText("");
        lift5Text.setText("");
    }

    public void addLiftingData(StringBuffer buffer, Cursor liftResult) {
        buffer.append("Day: "+" "+liftResult.getString(1)+"\n");
        buffer.append("Squat: "+" "+liftResult.getString(2)+"\n");
        buffer.append("DeadLift: "+" "+liftResult.getString(3)+"\n");
        buffer.append("RDL: "+" "+liftResult.getString(4)+"\n");
        buffer.append("Extension: "+" "+liftResult.getString(5)+"\n");
        buffer.append("Curl: "+" "+liftResult.getString(6)+"\n\n");
    }

    public void showPreviousLifts(StringBuffer buffer) {
        builder = new AlertDialog.Builder(LowerBodyWorkout.this);
        builder.setCancelable(true);
        builder.setTitle("Previous Lifts");
        builder.setMessage(buffer.toString());
        builder.show();
    }

}
