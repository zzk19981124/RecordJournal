package com.example.recordjournal.fragment_record;

import com.example.recordjournal.R;
import com.example.recordjournal.db.DBManager;
import com.example.recordjournal.db.TypeBean;

import java.util.List;

/**
 * @author hello word
 * @desc 支出
 * @date 2021/9/8
 */
public class OutcomeFragment extends BaseRecordFragment{
    @Override
    public void loadDataToGV() {
        super.loadDataToGV();
        //获取数据库当中的数据源
        List<TypeBean> outlist = DBManager.getTypeList(0);
        typeList.addAll(outlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("其他");
        typeIv.setImageResource(R.mipmap.ic_qita_fs);
    }
    @Override
    public void saveAccountToDB() {
        accountBean.setKind(0);
        DBManager.insertItemToAccounttb(accountBean);
    }


}
