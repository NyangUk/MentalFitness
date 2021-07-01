package com.company.mentalfitness.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.company.mentalfitness.Activity.MainActivity;
import com.company.mentalfitness.Adapter.ViewPagerAdapter;
import com.company.mentalfitness.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FragmentCreate extends Fragment {
    private FragmentPagerAdapter fragmentPagerAdapter;
    public FragmentCreate(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_create,container,false);
        TabLayout tabLayout = v.findViewById(R.id.tab_layout);
        ViewPager2 viewPager =v.findViewById(R.id.viewpager);

        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(FragmentCreate.this);
        viewPager.setAdapter(vpAdapter);

        final List<String> tabElement = Arrays.asList("1","2","3");
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView tv = new TextView(container.getContext());
                tv.setText(tabElement.get(position));
                tab.setCustomView(tv);
//                TextView tv2 = v.findViewById(R.id.item2);
//                TextView tv3 = v.findViewById(R.id.item3);
//                switch (position){
//                    case 0:
//                        tv1.setText("1");
//                        break;
//                    case 1:
//                        tv2.setText("2");
//                        break;
//                    case 2:
//                        tv3.setText();
//                        break;
//                }
            }
        }).attach();


        return v;
    }
}

