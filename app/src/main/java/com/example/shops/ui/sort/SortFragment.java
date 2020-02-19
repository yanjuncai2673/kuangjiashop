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

public class SortFragment extends BaseFragment {

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
    protected IBasePersenter createPersenter() {
        return null;
    }
}
