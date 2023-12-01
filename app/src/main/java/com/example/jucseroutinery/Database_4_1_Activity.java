package com.example.jucseroutinery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Database_4_1_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnAdd;

    MyDatabaseHelper myDB;
    ArrayList<String> ID, DAY, TIME1, TIME2, TIME3, TIME4;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database41);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("View 4-1 Routine");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Database_4_1_Activity.this, AddActivity.class );
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(Database_4_1_Activity.this);
        ID = new ArrayList<>();
        DAY = new ArrayList<>();
        TIME1 = new ArrayList<>();
        TIME2 = new ArrayList<>();
        TIME3 = new ArrayList<>();
        TIME4 = new ArrayList<>();
        storeDataInArrays();
        customAdapter = new CustomAdapter(Database_4_1_Activity.this, ID, DAY, TIME1, TIME2, TIME3, TIME4);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Database_4_1_Activity.this));
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount()==0)
        {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                DAY.add(cursor.getString(1));
                TIME1.add(cursor.getString(2));
                TIME2.add(cursor.getString(3));
                TIME3.add(cursor.getString(4));
                TIME4.add(cursor.getString(5));
            }
        }
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
            Intent intent = new Intent(Database_4_1_Activity.this, Login.class);
            startActivity(intent);
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