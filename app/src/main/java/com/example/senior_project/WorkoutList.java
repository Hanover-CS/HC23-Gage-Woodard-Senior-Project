/**
 * <summary> This class helps display data to recyclerView for the user.
 *     <para>
 *         Set the lifting data to new ArrayList
 *         Display data to recycler for users to view data
 *     </para>
 * </summary>
 */

package com.example.senior_project;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WorkoutList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> day, lift1, lift2, lift3, lift4, lift5;
    DBHelper db;
    MyAdapter adapter;

    // recyclerView is created and layout is set for when we move to next screen to
    // display our data to the user
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_list);
        db = new DBHelper(this);
        day = new ArrayList<>();
        lift1 = new ArrayList<>();
        lift2 = new ArrayList<>();
        lift3 = new ArrayList<>();
        lift4 = new ArrayList<>();
        lift5 = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, day, lift1, lift2,
                lift3, lift4, lift5);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
        
    }

    // uses the cursor to move to next to populate and displayData
    private void displayData() {
        Cursor cursor = db.getLiftingData();
        while (cursor.moveToNext()) {
            day.add(cursor.getString(1));
            lift1.add(cursor.getString(2));
            lift2.add(cursor.getString(3));
            lift3.add(cursor.getString(4));
            lift4.add(cursor.getString(5));
            lift5.add(cursor.getString(6));
        }
    }

}
