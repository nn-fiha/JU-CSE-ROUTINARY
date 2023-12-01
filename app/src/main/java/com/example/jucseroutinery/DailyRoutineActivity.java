package com.example.jucseroutinery;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import java.util.Calendar;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class DailyRoutineActivity extends AppCompatActivity {

    private MaterialTimePicker timePicker;
    private Calendar calendar;
     PendingIntent pendingIntent;
    AlarmManager alarmManager;
    private ListView listView;

    private static List<ClassInfo> PreferredDay = new ArrayList<>();
    public static String[] STime11,TTime11,ThTime11,WTime11;
    public static String[] STime41,MTime41,TTime41,WTime41,ThTime41;
    public static String[] STime21,MTime21,TTime21,WTime21,ThTime21;
    public static String[] STime31,ThTime31,MTime31,TTime31,WTime31;
    public static String[] PreferredTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_routine);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String callingActivity = getIntent().getStringExtra("calling_activity");


        if ("WholeRoutine_1_1_Activity".equals(callingActivity)) {

            getSupportActionBar().setTitle(WholeRoutine_1_1_Activity.sharedPreferences.getString(WholeRoutine_1_1_Activity.SE_DAY1,null));
        } else if ("WholeRoutine_2_1_Activity".equals(callingActivity)) {
            getSupportActionBar().setTitle(WholeRoutine_2_1_Activity.sharedPreferences.getString(WholeRoutine_2_1_Activity.SE_DAY2,null));
        } else if ("WholeRoutine_3_1_Activity".equals(callingActivity)) {
            getSupportActionBar().setTitle(WholeRoutine_3_1_Activity.sharedPreferences.getString(WholeRoutine_3_1_Activity.SE_DAY3,null));
        } else {
            getSupportActionBar().setTitle(BatchRoutineActivity2.sharedPreferences.getString(BatchRoutineActivity2.SE_DAY,null));
        }

        listView=(ListView) findViewById(R.id.list1);
        setupListView();
        SimpleAdapter simpleAdapter = new SimpleAdapter(DailyRoutineActivity.this, PreferredDay, PreferredTime);
        listView.setAdapter(simpleAdapter);

    }

    private void setupListView(){

        STime11=getResources().getStringArray(R.array.STime11);
        TTime11=getResources().getStringArray(R.array.TTime11);
        WTime11=getResources().getStringArray(R.array.WTime11);
        ThTime11=getResources().getStringArray(R.array.ThTime11);

        STime21=getResources().getStringArray(R.array.STime21);
        MTime21=getResources().getStringArray(R.array.MTime21);
        TTime21=getResources().getStringArray(R.array.TTime21);
        WTime21=getResources().getStringArray(R.array.WTime21);
        ThTime21=getResources().getStringArray(R.array.ThTime21);

        STime31=getResources().getStringArray(R.array.STime31);
        MTime31=getResources().getStringArray(R.array.MTime31);
        TTime31=getResources().getStringArray(R.array.TTime31);
        WTime31=getResources().getStringArray(R.array.WTime31);
        ThTime31=getResources().getStringArray(R.array.ThTime31);

        STime41=getResources().getStringArray(R.array.STime41);
        MTime41=getResources().getStringArray(R.array.MTime41);
        TTime41=getResources().getStringArray(R.array.TTime41);
        WTime41=getResources().getStringArray(R.array.WTime41);
        ThTime41=getResources().getStringArray(R.array.ThTime41);




        // In DailyRoutineActivity, check which activity started it
        String callingActivity = getIntent().getStringExtra("calling_activity");

// Then, retrieve the selected day accordingly
        String selected_day;

        if ("WholeRoutine_1_1_Activity".equals(callingActivity)) {

            Intent intent = getIntent();
            List<ClassInfo> sundayClasses = intent.getParcelableArrayListExtra("sundayClasses");
            List<ClassInfo> mondayClasses = intent.getParcelableArrayListExtra("mondayClasses");
            List<ClassInfo> tuesdayClasses = intent.getParcelableArrayListExtra("tuesdayClasses");
            List<ClassInfo> wdnsdayClasses = intent.getParcelableArrayListExtra("wdnsdayClasses");
            List<ClassInfo> thursdayClasses = intent.getParcelableArrayListExtra("thursdayClasses");
            selected_day = WholeRoutine_1_1_Activity.sharedPreferences.getString(WholeRoutine_1_1_Activity.SE_DAY1, null);
            PreferredTime=null;
            PreferredDay=null;

            if(selected_day.equalsIgnoreCase("Sunday")){
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : sundayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=STime11;
            } else if (selected_day.equalsIgnoreCase("Monday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : mondayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=STime11;
            } else if (selected_day.equalsIgnoreCase("Tuesday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : tuesdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=TTime11;
            }else if (selected_day.equalsIgnoreCase("Wednesday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : wdnsdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=WTime11;
            }else {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : thursdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=ThTime11;
            }
            createNotificationChannel();
            View customLayout = getLayoutInflater().inflate(R.layout.day_routine_single_item, null);
            TextView alarmIcon = customLayout.findViewById(R.id.alarmIcon);


            alarmIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("AlarmIconClick", "Alarm icon clicked");

                    timePicker = new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_12H)
                            .setHour(12)
                            .setMinute(0)
                            .setTitleText("Select Alarm Time")
                            .build();
                    Log.d("TimePicker", "TimePicker dialog is about to be shown");
                    timePicker .show(getSupportFragmentManager(), "androidknowledge");

                    timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (timePicker.getHour() > 12){
                                alarmIcon.setText(
                                        String.format("%02d",(timePicker .getHour()-12)) +":"+ String.format("%02d", timePicker.getMinute())+"PM"
                                );
                            } else {
                                alarmIcon.setText(timePicker .getHour()+":" + timePicker .getMinute()+ "AM");
                            }
                            calendar = Calendar.getInstance();
                            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                            calendar.set(Calendar.MINUTE, timePicker.getMinute());
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);

                        }
                    });
                }
            });
        } else if ("WholeRoutine_2_1_Activity".equals(callingActivity)) {
            selected_day = WholeRoutine_2_1_Activity.sharedPreferences.getString(WholeRoutine_2_1_Activity.SE_DAY2, null);
            Intent intent = getIntent();
            List<ClassInfo> sundayClasses = intent.getParcelableArrayListExtra("sundayClasses");
            List<ClassInfo> mondayClasses = intent.getParcelableArrayListExtra("mondayClasses");
            List<ClassInfo> tuesdayClasses = intent.getParcelableArrayListExtra("tuesdayClasses");
            List<ClassInfo> wdnsdayClasses = intent.getParcelableArrayListExtra("wdnsdayClasses");
            List<ClassInfo> thursdayClasses = intent.getParcelableArrayListExtra("thursdayClasses");


            PreferredTime=null;
            PreferredDay=null;

            if(selected_day.equalsIgnoreCase("Sunday")){
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : sundayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=STime21;
            } else if (selected_day.equalsIgnoreCase("Monday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : mondayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=MTime21;
            } else if (selected_day.equalsIgnoreCase("Tuesday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : tuesdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=TTime21;
            }else if (selected_day.equalsIgnoreCase("Wednesday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : wdnsdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=WTime21;
            }else {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : thursdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=ThTime21;
            }

            createNotificationChannel();
            View customLayout = getLayoutInflater().inflate(R.layout.day_routine_single_item, null);
            TextView alarmIcon = customLayout.findViewById(R.id.alarmIcon);


            alarmIcon.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.d("AlarmIconClick", "Alarm icon clicked");
                    timePicker = new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_12H)
                            .setHour(12)
                            .setMinute(0)
                            .setTitleText("Select Alarm Time")
                            .build();
                    Log.d("TimePicker", "TimePicker dialog is about to be shown");
                    timePicker.show(getSupportFragmentManager(), "androidknowledge");
                    timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (timePicker.getHour() > 12){
                                alarmIcon.setText(
                                        String.format("%02d",(timePicker.getHour()-12)) +":"+ String.format("%02d", timePicker.getMinute())+"PM"
                                );
                            } else {
                                alarmIcon.setText(timePicker.getHour()+":" + timePicker.getMinute()+ "AM");
                            }
                            calendar = Calendar.getInstance();
                            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                            calendar.set(Calendar.MINUTE, timePicker.getMinute());
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);

                        }
                    });
                }
            });
        } else if ("WholeRoutine_3_1_Activity".equals(callingActivity)) {
            selected_day = WholeRoutine_3_1_Activity.sharedPreferences.getString(WholeRoutine_3_1_Activity.SE_DAY3, null);
            Intent intent = getIntent();
            List<ClassInfo> sundayClasses = intent.getParcelableArrayListExtra("sundayClasses");
            List<ClassInfo> mondayClasses = intent.getParcelableArrayListExtra("mondayClasses");
            List<ClassInfo> tuesdayClasses = intent.getParcelableArrayListExtra("tuesdayClasses");
            List<ClassInfo> wdnsdayClasses = intent.getParcelableArrayListExtra("wdnsdayClasses");
            List<ClassInfo> thursdayClasses = intent.getParcelableArrayListExtra("thursdayClasses");

            PreferredTime=null;
            PreferredDay=null;
            if(selected_day.equalsIgnoreCase("Sunday")){
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : sundayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=STime31;
            } else if (selected_day.equalsIgnoreCase("Monday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : mondayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=MTime31;
            }else if (selected_day.equalsIgnoreCase("Tuesday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : tuesdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=TTime31;
            }else if (selected_day.equalsIgnoreCase("Wednesday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : wdnsdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=WTime31;
            }else {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : thursdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=ThTime31;
            }

            createNotificationChannel();
            View customLayout = getLayoutInflater().inflate(R.layout.day_routine_single_item, null);
            TextView alarmIcon = customLayout.findViewById(R.id.alarmIcon);
            alarmIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("AlarmIconClick", "Alarm icon clicked");
                    timePicker = new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_12H)
                            .setHour(12)
                            .setMinute(0)
                            .setTitleText("Select Alarm Time")
                            .build();
                    Log.d("TimePicker", "TimePicker dialog is about to be shown");
                    timePicker.show(getSupportFragmentManager(), "androidknowledge");
                    timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (timePicker.getHour() > 12){
                                alarmIcon.setText(
                                        String.format("%02d",(timePicker.getHour()-12)) +":"+ String.format("%02d", timePicker.getMinute())+"PM"
                                );
                            } else {
                                alarmIcon.setText(timePicker.getHour() + ":" + timePicker.getMinute() + "AM");
                            }
                            calendar = Calendar.getInstance();
                            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                            calendar.set(Calendar.MINUTE, timePicker.getMinute());
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);
                        }
                    });
                }
            });

}
        else {
            selected_day = BatchRoutineActivity2.sharedPreferences.getString(BatchRoutineActivity2.SE_DAY, null);
            Intent intent = getIntent();
            List<ClassInfo> sundayClasses = intent.getParcelableArrayListExtra("sundayClasses");
            List<ClassInfo> mondayClasses = intent.getParcelableArrayListExtra("mondayClasses");
            List<ClassInfo> tuesdayClasses = intent.getParcelableArrayListExtra("tuesdayClasses");
            List<ClassInfo> wdnsdayClasses = intent.getParcelableArrayListExtra("wdnsdayClasses");
            List<ClassInfo> thursdayClasses = intent.getParcelableArrayListExtra("thursdayClasses");

            PreferredTime=null;
            PreferredDay=null;
            if(selected_day.equalsIgnoreCase("Sunday")){
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : sundayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=STime41;
            } else if (selected_day.equalsIgnoreCase("Monday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : mondayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=MTime41;
            }else if (selected_day.equalsIgnoreCase("Tuesday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : tuesdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=TTime41;
            }else if (selected_day.equalsIgnoreCase("Wednesday")) {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : wdnsdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=WTime41;
            }else {
                List<ClassInfo> nonEmptyClasses = new ArrayList<>();
                for (ClassInfo classInfo : thursdayClasses) {
                    if (!classInfo.isEmpty()) {
                        nonEmptyClasses.add(classInfo);
                    }
                }
                PreferredDay=nonEmptyClasses;
                PreferredTime=ThTime41;
            }
            createNotificationChannel();
            View customLayout = getLayoutInflater().inflate(R.layout.day_routine_single_item, null);
            TextView alarmIcon = customLayout.findViewById(R.id.alarmIcon);

            alarmIcon.post(new Runnable() {
                @Override
                public void run() {
                    final Rect delegateArea = new Rect();
                    alarmIcon.getHitRect(delegateArea);
                    delegateArea.right += 50;  // Adjust the value as needed to expand the clickable area
                    delegateArea.bottom += 50; // Adjust the value as needed to expand the clickable area
                    TouchDelegate expandedArea = new TouchDelegate(delegateArea, alarmIcon);
                    if (View.class.isInstance(alarmIcon.getParent())) {
                        ((View) alarmIcon.getParent()).setTouchDelegate(expandedArea);
                    }
                }
            });

            alarmIcon.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.d("AlarmIconClick", "Alarm icon clicked");
                    timePicker = new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_12H)
                            .setHour(12)
                            .setMinute(0)
                            .setTitleText("Select Alarm Time")
                            .build();
                    Log.d("TimePicker", "TimePicker dialog is about to be shown");
                    timePicker.show(getSupportFragmentManager(), "androidknowledge");

                    timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (timePicker.getHour() > 12){
                                alarmIcon.setText(
                                        String.format("%02d",(timePicker.getHour()-12)) +":"+ String.format("%02d", timePicker.getMinute())+"PM"
                                );
                            } else {
                                alarmIcon.setText(timePicker.getHour()+":" + timePicker.getMinute()+ "AM");
                            }
                            calendar = Calendar.getInstance();
                            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                            calendar.set(Calendar.MINUTE, timePicker.getMinute());
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);

                        }
                    });
                }
            });
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.opt_menu1,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();
        if (itemId==R.id.opt_noti){
            Toast.makeText(this, "No New Notification!", Toast.LENGTH_SHORT).show();
        }
        else{
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "akchannel";
            String desc = "Channel for Alarm Manager";
            int imp = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("androidknowledge", name, imp);
            channel.setDescription(desc);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    public void OnToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            if (calendar != null) {
                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(DailyRoutineActivity.this, AlarmReciever.class);
                pendingIntent = PendingIntent.getBroadcast(DailyRoutineActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                Toast.makeText(DailyRoutineActivity.this, "Alarm Set", Toast.LENGTH_SHORT).show();
            } else {
                // Handle the case when the calendar is null (alarm time not set).
                Toast.makeText(DailyRoutineActivity.this, "Please set the alarm time first.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Intent intent = new Intent(DailyRoutineActivity.this, AlarmReciever.class);
            pendingIntent = PendingIntent.getBroadcast(DailyRoutineActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            if (alarmManager == null) {
                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            }
            alarmManager.cancel(pendingIntent);
            Toast.makeText(DailyRoutineActivity.this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
        }
    }

}





