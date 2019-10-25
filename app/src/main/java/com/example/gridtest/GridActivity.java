package com.example.gridtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.gridtest.Adapters.ItemAdapter;
import com.example.gridtest.domain.ProvinceBean;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView mGridView;
    private ItemAdapter mItemAdapter;
    private String[] provinceNames = new String[]{"北京", "上海", "广东", "广西", "天津", "重庆", "湖北", "湖南", "河北", "河南", "山东"};
    private int[] bgColor = new int[]{R.color.color_00ff00, R.color.color_ff0000, R.color.color_ff0000, R.color.color_ffff00,
            R.color.color_8e35ef, R.color.color_303F9F, R.color.color_00ff00, R.color.color_ff0000, R.color.color_ff0000,
            R.color.color_ffff00, R.color.color_8e35ef};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initView();
    }

    private void initView() {
        mGridView = (GridView) this.findViewById(R.id.grid_view);
        List<ProvinceBean> provinceBeanList = new ArrayList<>();
        for (int i = 0; i < provinceNames.length; i++) {
            ProvinceBean provinceBean = new ProvinceBean();
            provinceBean.setName(provinceNames[i]);
            provinceBean.setColor(bgColor[i]);
            provinceBeanList.add(provinceBean);
        }
        mItemAdapter = new ItemAdapter(this,provinceBeanList);
        mGridView.setAdapter(mItemAdapter);



    }
}
