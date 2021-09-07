package com.example.recordjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.recordjournal.adapter.AccountAdapter;
import com.example.recordjournal.db.AccountBean;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
    AccountAdapter adapter;
    //头布局相关
    private View headerView;
    private TextView topOutTv, topInTv, topbudgetTv, topConTv;
    private ImageView topShowIv;
    SharedPreferences preferences;
    int year, month, day;
    //用于明文、密文切换
    boolean isShow = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTime();
        initView();
        preferences = getSharedPreferences("budget", MODE_PRIVATE);
        //添加ListView的头布局
        addLVHeaderView();
        mDatas=new ArrayList<>();
        adapter=new AccountAdapter(mDatas,this);
        todayLv.setAdapter(adapter);
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
        //将布局转换成View对象
        headerView = getLayoutInflater().inflate(R.layout.item_mainlv_top,null);
        todayLv.addHeaderView(headerView);
        Log.d(TAG, "addLVHeaderView: "+(headerView==null?false:true));
        //查找头布局可用控件
        topOutTv = headerView.findViewById(R.id.item_mainlv_top_tv_out);
        topInTv = headerView.findViewById(R.id.item_mainlv_top_tv_in);
        topbudgetTv = headerView.findViewById(R.id.item_mainlv_top_tv_budget);
        topConTv = headerView.findViewById(R.id.item_mainlv_top_tv_day);
        topShowIv = headerView.findViewById(R.id.item_mainlv_top_iv_hide);

        topShowIv.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setTopShow();
    }
    /* 设置头布局当中文本内容的显示*/
    private void setTopShow() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_mainlv_top_iv_hide://明文、密文转换
                toggleShow();
                break;
            case R.id.main_btn_edit: // 记一笔
                Intent intent = new Intent(this,RecordActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


/**
 * 点击头布局中的眼睛时，如果原来是明文就加密，如果原来是密文就显示出来
 */
    private void toggleShow(){
        //private TextView topOutTv, topInTv, topbudgetTv, topConTv;
        if (isShow){  //明文——> 密文
            PasswordTransformationMethod passwordMethod =PasswordTransformationMethod.getInstance();
            topOutTv.setTransformationMethod(passwordMethod);
            topInTv.setTransformationMethod(passwordMethod);
            topbudgetTv.setTransformationMethod(passwordMethod);
            topShowIv.setImageResource(R.mipmap.ih_hide);
            isShow=false;
        }else{//密文——> 明文
            HideReturnsTransformationMethod hideMethod = HideReturnsTransformationMethod.getInstance();
            topOutTv.setTransformationMethod(hideMethod);
            topInTv.setTransformationMethod(hideMethod);
            topbudgetTv.setTransformationMethod(hideMethod);
            topShowIv.setImageResource(R.mipmap.ih_show);
            isShow=true;
        }
    }
}