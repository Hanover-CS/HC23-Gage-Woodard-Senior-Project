/**
 * <summary> This class creates the DataBase table we need to store user data.
 *     <para>
 *         addNewLift function allows for user input into table.
 *         getLiftingData allows for us to view lifts from lifting screens.
 *         deleteLift searches for the day entered and deletes it from DB if it is there.
 *     </para>
 * </summary>
 */


package com.example.senior_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_Name = "userData.db";
    private static final int DB_Version = 1;
    private static final String Table_Name = "Previous_Lifts";

    private static final String ID_COL = "id";
    private static final String Day_COL = "day";
    private static final String Lift_1_COL = "lift_1";
    private static final String Lift_2_COL = "lift_2";
    private static final String Lift_3_COL = "lift_3";
    private static final String Lift_4_COL = "lift_4";
    private static final String Lift_5_COL = "lift_5";

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Table_Name + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Day_COL + " TEXT,"
                + Lift_1_COL + " TEXT,"
                + Lift_2_COL + " TEXT,"
                + Lift_3_COL + " TEXT,"
                + Lift_4_COL + " TEXT,"
                + Lift_5_COL + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    public void addNewLift(String day, String lift1, String lift2, String lift3, String lift4, String lift5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Day_COL, day);
        values.put(Lift_1_COL, lift1);
        values.put(Lift_2_COL, lift2);
        values.put(Lift_3_COL, lift3);
        values.put(Lift_4_COL, lift4);
        values.put(Lift_5_COL, lift5);

        db.insert(Table_Name, null, values);
        db.close();
    }

    public Cursor getLiftingData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Table_Name, null);
        return cursor;
    }

    public void deleteLift(String day_COL) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Table_Name, null);
        if(cursor.getCount() > 0) {
            long liftData = db.delete(Table_Name, "day=?", new String[]{day_COL});
            if(liftData == -1) {
            } else {
            }
        } else {
        }
    }

}
