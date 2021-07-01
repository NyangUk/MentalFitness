package com.company.mentalfitness.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.company.mentalfitness.Fragment.FragmentCalendar;
import com.company.mentalfitness.Fragment.FragmentCreate;
import com.company.mentalfitness.Fragment.FragmentFeed;
import com.company.mentalfitness.Fragment.FragmentNotice;
import com.company.mentalfitness.Fragment.FragmentSetting;
import com.company.mentalfitness.Fragment.FragmentStatistic;
import com.company.mentalfitness.Fragment.FragmentUser;
import com.company.mentalfitness.R;

//피드 부분 임
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bnt1 = findViewById(R.id.MFeedButton);
        Button bnt2 = findViewById(R.id.MCalendarButton);
        Button bnt3 = findViewById(R.id.MCreateButton);
        Button bnt4 = findViewById(R.id.MStatisticButton);
        Button bnt5 = findViewById(R.id.MUserButton);

        ImageView iv1 = findViewById(R.id.notice);
        ImageView iv2 = findViewById(R.id.setting);

        bnt1.setOnClickListener(fragmentListener);
        bnt2.setOnClickListener(fragmentListener);
        bnt3.setOnClickListener(fragmentListener);
        bnt4.setOnClickListener(fragmentListener);
        bnt5.setOnClickListener(fragmentListener);

        iv1.setOnClickListener(fragmentListener);
        iv2.setOnClickListener(fragmentListener);
    }
    View.OnClickListener fragmentListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (v.getId()) {
                case R.id.MFeedButton:
                    FragmentFeed fragmentFeed = new FragmentFeed();
                    transaction.replace(R.id.frame,fragmentFeed);
                    break;
                case R.id.MCalendarButton:
                    FragmentCalendar fragmentCalendar = new FragmentCalendar();
                    transaction.replace(R.id.frame,fragmentCalendar);
                    break;
                case R.id.MCreateButton:
                    FragmentCreate fragmentCreate = new FragmentCreate();
                    transaction.replace(R.id.frame,fragmentCreate);
                    break;
                case R.id.MStatisticButton:
                    FragmentStatistic fragmentStatistic = new FragmentStatistic();
                    transaction.replace(R.id.frame,fragmentStatistic);
                    break;
                case R.id.MUserButton:
                    FragmentUser fragmentUser = new FragmentUser();
                    transaction.replace(R.id.frame,fragmentUser);
                    break;
                case R.id.notice:
                    FragmentNotice fragmentNotice = new FragmentNotice();
                    transaction.replace(R.id.frame,fragmentNotice);
                    break;
                case R.id.setting:
                    FragmentSetting fragmentSetting = new FragmentSetting();
                    transaction.replace(R.id.frame,fragmentSetting);
                    break;

            }
            transaction.commit();
        }
    };
    public void GoCreate(View v){
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }
}