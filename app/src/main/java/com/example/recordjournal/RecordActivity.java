package com.example.recordjournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

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

    }

    /*image button*/
    public void closeActivity(View view) {
        finish();
    }
}