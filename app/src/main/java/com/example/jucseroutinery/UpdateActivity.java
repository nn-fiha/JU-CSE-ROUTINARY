package com.example.jucseroutinery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText day2,t12,t22,t32,t42;
    Button update_button,delete_button;
    String id1,day1,time11,time21,time31,time41;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Routine");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        day2 = findViewById(R.id.day2);
        t12 = findViewById(R.id.t12);
        t22 = findViewById(R.id.t22);
        t32 = findViewById(R.id.t32);
        t42 = findViewById(R.id.t42);
        update_button = findViewById(R.id.update_button);
        delete_button= findViewById(R.id.delete_button);
        //first we call this
        getAndSetIntentData();
        Log.d("UpdateData", "New values: day1=" + day1 + ", time1=" + time11 + ", time2=" + time21 + ", time3=" + time31 + ", time4=" + time41);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//and only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.updateData(id1,day1,time11,time21,time31,time41);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void  getAndSetIntentData(){
        if (getIntent().hasExtra("id1")&& getIntent().hasExtra("day1")&& getIntent().hasExtra("time11")
                && getIntent().hasExtra("time21")&& getIntent().hasExtra("time31")
                && getIntent().hasExtra("time41")){

            //getting data from intent
            id1 = getIntent().getStringExtra("id1");
            day1 = getIntent().getStringExtra("day1");
            time11 = getIntent().getStringExtra("time11");
            time21 = getIntent().getStringExtra("time21");
            time31 = getIntent().getStringExtra("time31");
            time41 = getIntent().getStringExtra("time41");
            Log.d("UpdateData", "New values: day1=" + day1 + ", time1=" + time11 + ", time2=" + time21 + ", time3=" + time31 + ", time4=" + time41);

            //setting intent data
            day2.setText(day1);
            t12.setText(time11);
            t22.setText(time21);
            t32.setText(time31);
            t42.setText(time41);

        }
        else {
            Toast.makeText(this,"No Data!!",Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete "+ day1 + " ?");
        builder.setMessage("Are you sure you want to delete "+ day1 + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id1);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.opt_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();
        if (itemId==R.id.opt_logout){
            Toast.makeText(this, "Logged Out!", Toast.LENGTH_SHORT).show();
        }
        else if (itemId==R.id.opt_noti){
            Toast.makeText(this, "No New Notification!", Toast.LENGTH_SHORT).show();
        }
        else{
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}