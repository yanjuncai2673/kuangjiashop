package com.example.shops.ui.sort.activity.cart;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.sort.cart.CartConstart;
import com.example.shops.model.bean.sort.cart.SortDetailItemBean;
import com.example.shops.persenter.sort.cart.CartPersenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsSortDetailActivity extends BaseActivity<CartConstart.Persenter> implements CartConstart.View {


    @BindView(R.id.baner_sortDetailItem)
    Banner banerSortDetailItem;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.txt_pri)
    TextView txtPri;
    @BindView(R.id.tv_nums)
    TextView tvNums;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.con_nums)
    ConstraintLayout conNums;
    @BindView(R.id.txt_param)
    TextView txtParam;
    @BindView(R.id.txt_size)
    TextView txtSize;
    @BindView(R.id.con_meterial)
    ConstraintLayout conMeterial;
    @BindView(R.id.txt_color)
    TextView txtColor;
    @BindView(R.id.con_color)
    ConstraintLayout conColor;
    @BindView(R.id.txt_caizhi)
    TextView txtCaizhi;
    @BindView(R.id.con_caizhi)
    ConstraintLayout conCaizhi;
    @BindView(R.id.txt_adds)
    TextView txtAdds;
    @BindView(R.id.con_adds)
    ConstraintLayout conAdds;
    @BindView(R.id.web_sortitem)
    WebView webSortitem;
    @BindView(R.id.con_quest)
    ConstraintLayout conQuest;
    @BindView(R.id.rv_sortItem)
    RecyclerView rvSortItem;
    @BindView(R.id.scro)
    ScrollView scro;
    @BindView(R.id.iv_collect)
    ImageView ivCollect;
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_liji)
    TextView tvLiji;
    @BindView(R.id.tv_job)
    TextView tvJob;
    @BindView(R.id.txt_standerd)
    TextView txtStanderd;
    @BindView(R.id.con_standerd)
    ConstraintLayout conStanderd;
    private ArrayList<SortDetailItemBean.DataBeanX.GalleryBean> banners;

    @Override
    protected void initData() {
        int sortDetailId = getIntent().getIntExtra("sortDetailId", 0);
        persenter.getSortDetailItemData(sortDetailId);

    }

    @Override
    protected CartConstart.Persenter createPersenter() {
        return new CartPersenter();
    }

    @Override
    protected void initView() {
        WebSettings webSettings = webSortitem.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_goodscart_sort_detail;
    }

    @Override
    public void getSortDetailItemDataReturn(SortDetailItemBean sortDetailItemBean) {
//更新banner数据
        updataBanner(sortDetailItemBean.getData().getGallery());

        String price = getResources().getString(R.string.price_news_model).replace("$", String.valueOf(sortDetailItemBean.getData().getInfo().getRetail_price()));
        //更新条目标题 详情 价格 
        updataItemTitle(sortDetailItemBean.getData().getInfo().getName(),
                sortDetailItemBean.getData().getInfo().getGoods_brief(),
                price);
        //更新web数据
        updataWebs(sortDetailItemBean.getData().getInfo());

        //规格数据
        updataParam(sortDetailItemBean.getData().getAttribute());
    }

    //商品参数
    private void updataParam(List<SortDetailItemBean.DataBeanX.AttributeBean> attribute) {


        if (attribute != null) {

        }
    }

    //对WebViews进行渲染数据
    private void updataWebs(SortDetailItemBean.DataBeanX.InfoBean info) {
        //商品介绍描述信息
        String cs = getResources().getString(R.string.cs_goods);
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head>");
        builder.append("<style>" + cs + "</style></head></body>");
        builder.append(info.getGoods_desc() + "</body></html>");
        webSortitem.loadData(builder.toString(), "text/html", "utf-8");
    }

    //对条目商品赋值
    private void updataItemTitle(String name, String goods_brief, String price) {
        txtTitle.setText(name);
        txtDesc.setText(goods_brief);
        txtPri.setText(price);
    }

    private void updataBanner(List<SortDetailItemBean.DataBeanX.GalleryBean> sortDetailItemBean) {
        List<String> imgs = new ArrayList<>();
        for (int i = 0; i < sortDetailItemBean.size(); i++) {
            SortDetailItemBean.DataBeanX.GalleryBean galleryBean = sortDetailItemBean.get(i);
            String img = galleryBean.getImg_url();
            imgs.add(img);
        }
        banerSortDetailItem.setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImages(imgs)
                .setImageLoader(new GlidImageLoad())
                .start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
