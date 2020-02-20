package com.example.shops.ui.sort;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseFragment;
import com.example.shops.interfaces.sort.SortConstract;
import com.example.shops.model.bean.sort.SortDataBean;
import com.example.shops.model.bean.sort.SortGoodsListBean;
import com.example.shops.persenter.sort.SortPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public  class SortFragment extends BaseFragment<SortConstract.Persenter> implements SortConstract.View
        ,VerticalTabLayout.OnTabSelectedListener {

    @BindView(R.id.sort_vertab)
    VerticalTabLayout sortVertab;
    @BindView(R.id.sort_tab)
    ConstraintLayout sortTab;
    @BindView(R.id.v_bg)
    View vBg;
    @BindView(R.id.iv_title)
    ImageView ivTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rv_sort)
    RecyclerView rvSort;

     ArrayList<String> titles;
     ArrayList<SortGoodsListBean.DataBean.CurrentCategoryBean.SubCategoryListBean> sortgoodslist;
     SortGoodsListAdapter sortGoodsListAdapter;
     List<SortDataBean.DataBean.CategoryListBean> sortlist;


    @Override
    protected int getLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    protected void initData() {
persenter.getSortDatas();
    }

    @Override
    protected void initView() {
        titles = new ArrayList<>();
        sortVertab.addOnTabSelectedListener(this);
        sortgoodslist = new ArrayList<>();
        sortGoodsListAdapter = new SortGoodsListAdapter(sortgoodslist, context);
        rvSort.setLayoutManager(new GridLayoutManager(context,3));
        rvSort.setAdapter(sortGoodsListAdapter);
    }

    @Override
    protected SortConstract.Persenter createPersenter() {
        return new SortPersenter();
    }

    //创建竖导航的TabAdapter
    TabAdapter tabAdapter = new TabAdapter() {
        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public ITabView.TabBadge getBadge(int position) {
            return null;
        }

        @Override
        public ITabView.TabIcon getIcon(int position) {
            return null;
        }

        @Override
        public ITabView.TabTitle getTitle(int position) {
            ITabView.TabTitle title = new QTabView.TabTitle.Builder()
                    .setContent(titles.get(position))////设置数据   也有设置字体颜色的方法
                    .build();
            return title;
        }

        @Override
        public int getBackground(int position) {
            return Color.parseColor("#D81B60");
        }
    };

    @Override
    public void getSortDataReturn(SortDataBean sortDataBean) {
        sortlist = sortDataBean.getData().getCategoryList();
        titles.clear();
        //筛选竖导航标题
        for (SortDataBean.DataBean.CategoryListBean item:sortDataBean.getData().getCategoryList()) {
            titles.add(item.getName());
        }
        sortVertab.setTabAdapter(tabAdapter);
        //更新数据
        updataInfo(sortDataBean.getData().getCurrentCategory().getImg_url(),
                sortDataBean.getData().getCurrentCategory().getFront_desc(),
                sortDataBean.getData().getCurrentCategory().getName());
        List<SortGoodsListBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list = new ArrayList<>();
        for(SortDataBean.DataBean.CurrentCategoryBean.SubCategoryListBean item:sortDataBean.getData().getCurrentCategory().getSubCategoryList()){
            SortGoodsListBean.DataBean.CurrentCategoryBean.SubCategoryListBean object = new SortGoodsListBean.DataBean.CurrentCategoryBean.SubCategoryListBean();
            object.setFront_name(item.getName());
            object.setFront_desc(item.getFront_desc());
            object.setId(item.getId());
            object.setImg_url(item.getImg_url());
            list.add(object);
        }
        sortGoodsListAdapter.updata(list);
    }

    private void updataInfo(String img_url, String front_desc, String name){
        Glide.with(context).load(img_url).into(ivTitle);
        tvTitle.setText(front_desc);
        tvName.setText(name);
    };

    @Override
    public void getSortGoodsListReturn(SortGoodsListBean sortGoodsListBean) {
        sortgoodslist.clear();
        sortgoodslist.addAll(sortGoodsListBean.getData().getCurrentCategory().getSubCategoryList());
        sortGoodsListAdapter.updata(sortgoodslist);
    }

    @Override
    public void onTabSelected(TabView tab, int position) {
        if(position < sortlist.size()){
            int id = sortlist.get(position).getId();
            persenter.getSortGoodsList(id);
        }
    }

    @Override
    public void onTabReselected(TabView tab, int position) {

    }
}
