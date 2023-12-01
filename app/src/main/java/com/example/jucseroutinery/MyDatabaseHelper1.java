package com.example.jucseroutinery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper1 extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Routine.db";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME= "class_routine";
    private static final String COLUMN_ID= "_id";
    private static final String DAY= "_day";
    private static final String TIME1= "_time1";
    private static final String TIME2= "_time2";
    private static final String TIME3= "_time3";
    private static final String TIME4= "_time4";
    // private static final String TIME5= "_time5";

    MyDatabaseHelper1(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DAY + " TEXT, " +
                TIME1 + " TEXT, " +
                TIME2 + " TEXT, " +
                TIME3 + " TEXT, " +
                TIME4 + " TEXT );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    void  addroutine (String day, String t1, String t2, String t3, String t4){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DAY,day);
        cv.put(TIME1,t1);
        cv.put(TIME2,t2);
        cv.put(TIME3,t3);
        cv.put(TIME4,t4);
        //cv.put(TIME5,t5);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result==-1)
        {
            Toast.makeText(context, "Failed!!",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added successfully!!",Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
    void  updateData(String row_id,String day, String t1, String t2, String t3, String t4){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DAY,day);
        cv.put(TIME1,t1);
        cv.put(TIME2,t2);
        cv.put(TIME3,t3);
        cv.put(TIME4,t4);

        long result= db.update(TABLE_NAME, cv,"_id=?",new String[]{row_id});

        Log.d("UpdateData", "Updating row_id: " + row_id);
        Log.d("UpdateData", "New values: day=" + day + ", t1=" + t1 + ", t2=" + t2 + ", t3=" + t3 + ", t4=" + t4);
        if (result==-1)
        {
            Toast.makeText(context, "Failed Update", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Update Successful!!", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteOneRow(String row_id){
        SQLiteDatabase db= this.getWritableDatabase();
        long result= db.delete(TABLE_NAME, "_id=?", new  String[]{row_id});
        if (result==-1)
        {
            Toast.makeText(context, "Failed to Delete", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }
    }
}
