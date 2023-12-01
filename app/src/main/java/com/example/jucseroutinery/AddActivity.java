package com.example.jucseroutinery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText day,t1,t2,t3,t4;
    Button add_button;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Routine");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        day = findViewById(R.id.day);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addroutine(day.getText().toString().trim(),
                        t1.getText().toString().trim(),
                        t2.getText().toString().trim(),
                        t3.getText().toString().trim(),
                        t4.getText().toString().trim());
            }
        });

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