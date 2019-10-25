package com.example.gridtest.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gridtest.GridActivity;
import com.example.gridtest.R;
import com.example.gridtest.domain.ProvinceBean;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private static final String TAG = "ItemAdapter";
    private List<ProvinceBean> provinceBeanList;
    private LayoutInflater layoutInflater;

    public ItemAdapter(Context context, List<ProvinceBean> provinceBeanList) {
        this.provinceBeanList = provinceBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return provinceBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return provinceBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.province_grid_item,null);
            holder = new ViewHolder();
            holder.text=(TextView)convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);  //保存视图，不重复加载
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        ProvinceBean provinceBean = provinceBeanList.get(position);
        if (provinceBean != null){
            //读取bean中的参数，对textView进行参数设置

            holder.text.setText(provinceBean.getName());  //TextView有setText方法
            holder.text.setTextColor(parent.getContext().getResources().getColor(provinceBean.getColor()));
        }

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"position:" + position);
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView text;   //TextView类型的view
    }


}
