package com.example.jucseroutinery;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ClassInfo implements Parcelable {
    private String courseName;
    private String courseCode;
    private String courseTeacher;
    private String roomNumber;

    public ClassInfo(String courseName, String courseCode, String courseTeacher, String roomNumber) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseTeacher = courseTeacher;
        this.roomNumber = roomNumber;
    }

    // Getters and setters for each property
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(courseName);
        dest.writeString(courseCode);
        dest.writeString(courseTeacher);
        dest.writeString(roomNumber);
    }

    public static final Parcelable.Creator<ClassInfo> CREATOR = new Parcelable.Creator<ClassInfo>() {
        @Override
        public ClassInfo createFromParcel(Parcel in) {
            return new ClassInfo(in);
        }

        @Override
        public ClassInfo[] newArray(int size) {
            return new ClassInfo[size];
        }
    };

    private ClassInfo(Parcel in) {
        courseName = in.readString();
        courseCode = in.readString();
        courseTeacher = in.readString();
        roomNumber = in.readString();
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(courseName) && TextUtils.isEmpty(courseCode) &&
                TextUtils.isEmpty(courseTeacher) && TextUtils.isEmpty(roomNumber);
    }
}

