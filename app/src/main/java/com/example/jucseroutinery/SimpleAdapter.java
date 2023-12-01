package com.example.jucseroutinery;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SimpleAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<ClassInfo> classInfoList;
    private String[] timeArray;

    public SimpleAdapter(Context context, List<ClassInfo> classInfoList, String[] timeArray) {
        mContext = context;
        this.classInfoList = classInfoList;
        this.timeArray = timeArray;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return classInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return classInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (position < 0 || position >= classInfoList.size()) {
            return convertView;
        }


        ViewHolder viewHolder;


        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.day_routine_single_item, null);
            viewHolder = new ViewHolder();
            viewHolder.startTime = convertView.findViewById(R.id.tvTime1);
            viewHolder.endTime = convertView.findViewById(R.id.tvTime2);
            viewHolder.courseCode = convertView.findViewById(R.id.tvCourseCode);
            viewHolder.courseName = convertView.findViewById(R.id.tvCourseName);
            viewHolder.courseTeacher = convertView.findViewById(R.id.tvCourseTeacher);
            viewHolder.room = convertView.findViewById(R.id.tvRoom);
            viewHolder.alarmIcon = convertView.findViewById(R.id.alarmIcon);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ClassInfo classInfo = classInfoList.get(position);
        String timeString = timeArray[position];

        // Split the timeString using "-"
        String[] parts = timeString.split("-");

        if (parts.length == 2) {
            String startTime = parts[0];
            String endTime = parts[1];

            // Set the split values in the ViewHolder's TextViews
            viewHolder.startTime.setText(startTime);
            viewHolder.endTime.setText(endTime);

        }



        viewHolder.courseName.setText(classInfo.getCourseName());
        viewHolder.courseCode.setText(classInfo.getCourseCode());
        viewHolder.courseTeacher.setText(classInfo.getCourseTeacher());
        viewHolder.room.setText(classInfo.getRoomNumber());


        return convertView;
    }

    private static class ViewHolder {

        TextView  startTime,endTime,alarmIcon;
        TextView courseCode;
        TextView courseName;
        TextView courseTeacher;
        TextView room;
    }
}
