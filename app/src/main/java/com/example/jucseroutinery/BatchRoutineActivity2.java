package com.example.jucseroutinery;

import static com.example.jucseroutinery.R.id.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BatchRoutineActivity2 extends AppCompatActivity implements HorizontalScroll.ScrollViewListener, VerticalScroll.ScrollViewListener{

    HorizontalScroll horizontalScrollViewB,horizontalScrollViewD;
    VerticalScroll scrollViewC,scrollViewD;

    public static SharedPreferences sharedPreferences;

    public static final String SE_DAY = "selected_day";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_routine2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("4th year 1st Semester");




        sharedPreferences = getSharedPreferences("MY_DAY", MODE_PRIVATE);

        horizontalScrollViewB = (HorizontalScroll) findViewById(R.id.horizontalView1);
        horizontalScrollViewD = (HorizontalScroll) findViewById(R.id.horizontalView2);
        scrollViewC = (VerticalScroll) findViewById(R.id.scrollView1);
        scrollViewD = (VerticalScroll) findViewById(R.id.scrollView2);

        horizontalScrollViewB.setScrollViewListener(this);
        horizontalScrollViewD.setScrollViewListener(this);
        scrollViewC.setScrollViewListener(this);
        scrollViewD.setScrollViewListener(this);

        TableLayout tableLayout = findViewById(R.id.tL4);
        TableLayout tableLayout3 = findViewById(R.id.tL3);
        String[] week = getResources().getStringArray(R.array.Week);



        List<ClassInfo> sundayClasses = new ArrayList<>();
        List<ClassInfo> mondayClasses = new ArrayList<>();
        List<ClassInfo> tuesdayClasses = new ArrayList<>();
        List<ClassInfo> wdnsdayClasses = new ArrayList<>();
        List<ClassInfo> thursdayClasses = new ArrayList<>();

        sundayClasses.add(new ClassInfo("", "", "", ""));
        sundayClasses.add(new ClassInfo("Wireless Network", "CSE-407", "Imdadul Islam", "Room 101"));
        sundayClasses.add(new ClassInfo("Software Engineering", "CSE-403", "Humayun Kabir", "Room 102"));
        sundayClasses.add(new ClassInfo("Theory of Computation", "CSE-401", "Amena Khatun", "Room 101"));
        sundayClasses.add(new ClassInfo("", "", "", ""));

        mondayClasses.add(new ClassInfo("Theory of Computation", "CSE-401", "Amena Khatun", "Room 101"));
        mondayClasses.add(new ClassInfo("Wireless Network", "CSE-407", "Imdadul Islam", "Room 101"));
        mondayClasses.add(new ClassInfo("", "", "", ""));
        mondayClasses.add(new ClassInfo("", "", "", ""));
        mondayClasses.add(new ClassInfo("", "", "", ""));


        tuesdayClasses.add(new ClassInfo("Mobile App Laboratory", "CSE-410", "Ezharul Islam & Anup Majumder", "Room 302"));
        tuesdayClasses.add(new ClassInfo("Digital Image Processing", "CSE-405", "Liton Jude Rozario", "Room 101"));
        tuesdayClasses.add(new ClassInfo("Software Engineering", "CSE-403", "Humayun Kabir", "Room 102"));
        tuesdayClasses.add(new ClassInfo("", "", "", ""));


        wdnsdayClasses.add(new ClassInfo("", "", "", ""));
        wdnsdayClasses.add(new ClassInfo("Digital Image Processing Lab", "CSE-406", "Liton Jude Rozario & Golam Moazzem", "Room 203"));
        wdnsdayClasses.add(new ClassInfo("Digital Image Processing", "CSE-405", "Liton Jude Rozario", "Room 101"));
        wdnsdayClasses.add(new ClassInfo("", "", "", ""));

        thursdayClasses.add(new ClassInfo("Software Engineering Lab", "CSE-404", "Humayun Kabir & Mohammad Zahidur Rahman", "Room 102"));
        thursdayClasses.add(new ClassInfo("", "", "", ""));
        thursdayClasses.add(new ClassInfo("", "", "", ""));
        thursdayClasses.add(new ClassInfo("", "", "", ""));



        for (int i = 0; i < tableLayout3.getChildCount(); i++) {
            if (tableLayout3.getChildAt(i) instanceof TableRow) {
                TableRow row = (TableRow) tableLayout3.getChildAt(i);
                for (int j = 0; j < row.getChildCount(); j++) {
                    if (row.getChildAt(j) instanceof TextView) {
                        TextView textView = (TextView) row.getChildAt(j);
                        textView.setText(week[i]);

                        int finalI = i;

                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String dayText = textView.getText().toString();
                                Toast.makeText(getApplicationContext(), "Clicked: " + dayText, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(BatchRoutineActivity2.this, DailyRoutineActivity.class);
                                intent.putExtra("calling_activity", "BatchRoutineActivity2");
                                intent.putParcelableArrayListExtra("sundayClasses", (ArrayList<ClassInfo>) sundayClasses);
                                intent.putParcelableArrayListExtra("mondayClasses", (ArrayList<ClassInfo>) mondayClasses);
                                intent.putParcelableArrayListExtra("tuesdayClasses", (ArrayList<ClassInfo>) tuesdayClasses);
                                intent.putParcelableArrayListExtra("wdnsdayClasses", (ArrayList<ClassInfo>) wdnsdayClasses);
                                intent.putParcelableArrayListExtra("thursdayClasses", (ArrayList<ClassInfo>) thursdayClasses);
                                if ( week[finalI] != null) {
                                    sharedPreferences.edit().putString(SE_DAY.toString(), week[finalI]).apply();
                                }
// Start Activity2
                                startActivity(intent);


                            }
                        });
                    }
                }
            }
        }

        int flag = 0;

        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            if (tableLayout.getChildAt(i) instanceof TableRow) {
                TableRow row = (TableRow) tableLayout.getChildAt(i);

                for (int j = 0; j < row.getChildCount(); j++) {
                    if (row.getChildAt(j) instanceof TextView) {
                        TextView textView = (TextView) row.getChildAt(j);
                        List<ClassInfo> classesForDay;
                        switch (flag) {
                            case 0:
                                classesForDay = sundayClasses;
                                break;
                            case 1:
                                classesForDay = mondayClasses;
                                break;
                            case 2:
                                classesForDay = tuesdayClasses;
                                break;
                            case 3:
                                classesForDay = wdnsdayClasses;
                                break;
                            case 4:
                                classesForDay = thursdayClasses;
                                break;
                            default:
                                classesForDay = new ArrayList<>();
                                break;
                        }

                        if (flag >= 0 && flag < 5 && j < classesForDay.size()) {
                            // Set the course code from the appropriate day's classes
                            String courseCode = classesForDay.get(j).getCourseCode();
                            String Room = classesForDay.get(j).getRoomNumber();
                            textView.setText(courseCode+"\n"+Room);

                        } else {

                            textView.setText("");
                        }
                    }
                }

                flag++;
            }
        }


    }
    @Override
    public void onScrollChanged(HorizontalScroll scrollView, int x, int y, int oldx, int oldy) {
        if (scrollView == horizontalScrollViewB) {
            horizontalScrollViewD.scrollTo(x, y);
        } else if (scrollView == horizontalScrollViewD) {
            horizontalScrollViewB.scrollTo(x, y);
        }
    }

    @Override
    public void onScrollChanged(VerticalScroll scrollView, int x, int y, int oldx, int oldy) {
        if (scrollView == scrollViewC) {
            scrollViewD.scrollTo(x, y);
        } else if (scrollView == scrollViewD) {
            scrollViewC.scrollTo(x, y);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();
        if (itemId==android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}