package com.example.recordjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.recordjournal.db.AccountBean;

import java.util.Calendar;
import java.util.List;

/**
 * author:   ak
 * app name: 简约记账
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private ListView todayLv;  //展示今日收支情况的ListView
    private ImageView searchIv;
    private Button editBtn;
    private ImageButton moreBtn;
    //声明数据源
    List<AccountBean> mDatas;
    //AccountAdapter adapter;


    //头布局相关
    private View headerView;
    private TextView topOutTv, topInTv, topbudgetTv, topConTv;
    private ImageView topShowIv;
    SharedPreferences preferences;

    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTime();
        initView();
        preferences = getSharedPreferences("budget", MODE_PRIVATE);
        //添加ListView的头布局
        addLVHeaderView();
    }


    /**
     * 初始化自带的View的方法
     */
    private void initView() {
        todayLv = findViewById(R.id.main_lv);
        editBtn = findViewById(R.id.main_btn_edit);
        moreBtn = findViewById(R.id.main_btn_more);
        searchIv = findViewById(R.id.main_iv_search);
        editBtn.setOnClickListener(this);
        moreBtn.setOnClickListener(this);
        searchIv.setOnClickListener(this);
        setLVLongClickListener();
    }

    /**
     * 设置listView的长按事件
     */
    private void setLVLongClickListener() {

    }

    /**
     * 获取今日的具体时间
     */
    private void initTime() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        Log.d(TAG, "initTime:out :" + year + "/" + month + "/" + day);
    }

    /**
     * 给ListView添加头布局的方法
     */
    private void addLVHeaderView() {

    }

    @Override
    public void onClick(View v) {

    }
}