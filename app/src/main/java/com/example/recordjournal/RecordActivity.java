package com.example.recordjournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.recordjournal.adapter.RecordPagerAdapter;
import com.example.recordjournal.fragment_record.IncomeFragment;
import com.example.recordjournal.fragment_record.OutcomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecordActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        mTabLayout=findViewById(R.id.record_tabs);
        mViewPager=findViewById(R.id.record_vp);
        //设置viewPager加载页面
        initPager();
    }

    private void initPager() {
        //初始化ViewPager页面的集合
        List<Fragment> fragmentList = new ArrayList<>();
        //创建收入和支出页面，放置在Fragment当中
        OutcomeFragment out = new OutcomeFragment();//支出
        IncomeFragment in = new IncomeFragment();//收入

        fragmentList.add(out);
        fragmentList.add(in);
        //创建适配器
        RecordPagerAdapter pagerAdapter = new RecordPagerAdapter(getSupportFragmentManager(),fragmentList);
        //设置适配器
        mViewPager.setAdapter(pagerAdapter);
        //将TabLayout和ViewPager进行关联
        mTabLayout.setupWithViewPager(mViewPager);

    }

    /*image button*/
    public void closeActivity(View view) {
        finish();
    }
}