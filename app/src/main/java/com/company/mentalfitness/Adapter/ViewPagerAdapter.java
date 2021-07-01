package com.company.mentalfitness.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.company.mentalfitness.Fragment.FragmentCreate;
import com.company.mentalfitness.Fragment.ViewPager_1;
import com.company.mentalfitness.Fragment.ViewPager_2;
import com.company.mentalfitness.Fragment.ViewPager_3;
import com.company.mentalfitness.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentCreate fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return ViewPager_1.newinstance();
            case 1:
                return ViewPager_2.newinstance();
            case 2:
                return ViewPager_3.newinstance();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

