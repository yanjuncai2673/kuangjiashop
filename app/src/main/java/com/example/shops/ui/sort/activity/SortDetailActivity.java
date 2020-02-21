package com.example.shops.ui.sort.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.common.RecycleGridDivider;
import com.example.shops.interfaces.sort.SortConstract;
import com.example.shops.model.bean.sort.SortDetailDataBean;
import com.example.shops.model.bean.sort.SortDetailTabBean;
import com.example.shops.persenter.sort.SortDetailPersenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SortDetailActivity extends BaseActivity<SortConstract.SortDetailPersenter> implements SortConstract.SortDetailView, TabLayout.BaseOnTabSelectedListener {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.tab_sortDetail)
    TabLayout tabSortDetail;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_descDetail)
    TextView tvDescDetail;
    @BindView(R.id.des_info)
    ConstraintLayout desInfo;
    @BindView(R.id.rv_sortDetail)
    RecyclerView rvSortDetail;

    List<SortDetailTabBean.DataBean.BrotherCategoryBean> tabs;
    List<SortDetailDataBean.DataBeanX.GoodsListBean> details;
    SortDetailDataAdapter sortDetailDataAdapter;

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra("id", 0);
        persenter.getSortDetailTabDatas(id);
    }

    @Override
    protected SortConstract.SortDetailPersenter createPersenter() {
        return new SortDetailPersenter();
    }

    @Override
    protected void initView() {
        tabSortDetail.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabSortDetail.addOnTabSelectedListener(this);
        details = new ArrayList<>();
        sortDetailDataAdapter = new SortDetailDataAdapter(details, this);
        rvSortDetail.setLayoutManager(new GridLayoutManager(this, 2));
        rvSortDetail.setAdapter(sortDetailDataAdapter);
        rvSortDetail.addItemDecoration(new RecycleGridDivider());
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_sort_detail;
    }

    @Override
    public void getSortDetailTabReturn(SortDetailTabBean sortDetailTabBean) {
        int position = -1;
        tabs = sortDetailTabBean.getData().getBrotherCategory();
//动态添加tab导航
        for (int i = 0; i <sortDetailTabBean.getData().getBrotherCategory().size() ; i++) {
            SortDetailTabBean.DataBean.BrotherCategoryBean bean = sortDetailTabBean.getData().getBrotherCategory().get(i);
            TabLayout.Tab tab = tabSortDetail.newTab();
            tab.setText(bean.getName());
            tab.setTag(bean.getId());
            tabSortDetail.addTab(tab);

            if (sortDetailTabBean.getData().getCurrentCategory().getId() == bean.getId()) {
                position = i;
            }
        }
        if (position >=0) {
            tabSortDetail.getTabAt(position).select();
        }
    }

    @Override
    public void getSortDetailDataReturn(SortDetailDataBean sortDetailDataBean) {
        sortDetailDataAdapter.updata(sortDetailDataBean.getData().getGoodsList());

    }



    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        SortDetailTabBean.DataBean.BrotherCategoryBean categoryBean = tabs.get(tab.getPosition());
        tvDesc.setText(categoryBean.getFront_name());
        tvDescDetail.setText(categoryBean.getFront_desc());
        int id = (int) tab.getTag();
        //获取分类详情商品列表数据
        persenter.getSortDetailDatas(id,1,1000);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
