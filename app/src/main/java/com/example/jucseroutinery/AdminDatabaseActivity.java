package com.example.jucseroutinery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdminDatabaseActivity extends AppCompatActivity {

    TextView txtMSc,txt4th,txt3rd,txt2nd, txt1st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_database);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Manage Routine");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findViewById(R.id.txt4th).setOnClickListener(this::openTargetActivity);
        findViewById(R.id.txt1st).setOnClickListener(this::openTargetActivity2);

    }


    public void openTargetActivity(View view) {
        Intent intent = new Intent(AdminDatabaseActivity.this, Database_4_1_Activity.class);
        startActivity(intent);
    }
    public void openTargetActivity2(View view) {
        Intent intent = new Intent(AdminDatabaseActivity.this, Database_1_1_Activity.class);
        startActivity(intent);
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
            Intent intent = new Intent(AdminDatabaseActivity.this, Login.class);
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