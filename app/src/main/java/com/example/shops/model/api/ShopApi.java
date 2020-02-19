package com.example.shops.model.api;

import com.example.shops.model.bean.BrandBean;
import com.example.shops.model.bean.BrandGoodsBean;
import com.example.shops.model.bean.HomeIndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
//Api接口类
public interface ShopApi {
    //首页接口Api
    @GET("index")
    Flowable<HomeIndexBean> getIndexData();

    //品牌直供的详情页数据接口
    @GET("brand/detail")
    Flowable<BrandBean> getBrandInfo(@Query("id") String id);
    //品牌直供详情的商品列表数据接口
    @GET("goods/list")
    Flowable<BrandGoodsBean> getBrandGoods(@Query("brandId") String brandId, @Query("page") int page, @Query("size") int size);

}
