package com.example.shops.ui.sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.shops.R;
import com.example.shops.base.BaseFragment;
import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.sort.SortConstract;
import com.example.shops.model.bean.sort.SortDataBean;
import com.example.shops.model.bean.sort.SortGoodsListBean;

public class SortFragment extends BaseFragment<SortConstract.Persenter> implements SortConstract.View {

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected SortConstract.Persenter createPersenter() {
        return null;
    }


    @Override
    public void getSortDataReturn(SortDataBean sortDataBean) {

    }

    @Override
    public void getSortGoodsListReturn(SortGoodsListBean sortGoodsListBean) {

    }
}
