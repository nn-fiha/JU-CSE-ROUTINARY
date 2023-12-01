package com.example.jucseroutinery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerLoginAdapter extends FragmentPagerAdapter {

    public viewPagerLoginAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new StudentFragment();
        } else{
            return new AdminFragment();

        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Student";
        } else{
            return "Admin";

        }
    }
}
