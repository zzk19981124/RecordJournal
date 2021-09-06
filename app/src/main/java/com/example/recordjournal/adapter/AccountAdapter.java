package com.example.recordjournal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recordjournal.R;
import com.example.recordjournal.db.AccountBean;

import java.util.Calendar;
import java.util.List;

public class AccountAdapter extends BaseAdapter {
    private List<AccountBean> mData;
    private Context mContext;
    LayoutInflater inflater;
    int year,month,day;

    public AccountAdapter(List<AccountBean> aDate, Context context) {
        this.mData = aDate;
        mContext = context;
        inflater = LayoutInflater.from(context);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_mainiv,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        AccountBean bean =mData.get(position);
        holder.typeIv.setImageResource(bean.getsImageId());
        holder.typeTv.setText(bean.getTypename());
        holder.beizhuTv.setText(bean.getBeizhu());
        holder.moneyTv.setText("￥ "+bean.getMoney());
        if (bean.getYear()==year&&bean.getMonth()==month&&bean.getDay()==day) {
            String time = bean.getTime().split(" ")[1];
            holder.timeTv.setText("今天 "+time);
        }else {
            holder.timeTv.setText(bean.getTime());
        }
        return convertView;
    }
    class ViewHolder{
        ImageView typeIv;
        TextView typeTv,beizhuTv,timeTv,moneyTv;
        public ViewHolder(View view){
            typeIv = view.findViewById(R.id.item_main_iv);
            typeTv = view.findViewById(R.id.item_mainlv_tv_title);
            timeTv = view.findViewById(R.id.item_mainlv_tv_time);
            beizhuTv = view.findViewById(R.id.item_mainlv_tv_beizhu);
            moneyTv = view.findViewById(R.id.item_mainlv_tv_money);
        }
    }
}
