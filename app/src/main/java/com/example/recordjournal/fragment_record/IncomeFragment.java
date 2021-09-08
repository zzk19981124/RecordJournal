package com.example.recordjournal.fragment_record;

import com.example.recordjournal.R;
import com.example.recordjournal.db.DBManager;
import com.example.recordjournal.db.TypeBean;

import java.util.List;

/**
 * @author hello word
 * @desc 收入页面
 * @date 2021/9/8
 */
public class IncomeFragment extends BaseRecordFragment{

    @Override
    public void loadDataToGV() {
        super.loadDataToGV();
        List<TypeBean> inList = DBManager.getTypeList(1);
        typeList.addAll(inList);
        adapter.notifyDataSetChanged();
        typeTv.setText("其他");
        typeIv.setImageResource(R.mipmap.in_qt_fs);
    }

    @Override
    public void saveAccountToDB() {
        accountBean.setKind(1);
        DBManager.insertItemToAccounttb(accountBean);
    }
}
