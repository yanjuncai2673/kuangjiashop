package com.example.shops.interfaces.sort;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.sort.SortDataBean;
import com.example.shops.model.bean.sort.SortDetailDataBean;
import com.example.shops.model.bean.sort.SortDetailTabBean;
import com.example.shops.model.bean.sort.SortGoodsListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

//分类里的契约类  用于返回数据及绑定p  v
public interface SortConstract {
    interface View extends IBaseView{//v层数据加载成功后返回
        //将View层分类tab数据返回
        void getSortDataReturn(SortDataBean sortDataBean);
        //将分类网格布局数据返回
        void getSortGoodsListReturn(SortGoodsListBean sortGoodsListBean);
    }

    //将p和view 关联获取数据
    interface Persenter extends IBasePersenter<View>{//p层获取加载数据方法
        //获取分类数据
        void getSortDatas();
        //获取分类
        void getSortGoodsList(int id);
    }

    interface SortDetailView extends IBaseView{//将分类详情页面数据返回
        void getSortDetailTabReturn(SortDetailTabBean sortDetailTabBean);
        void getSortDetailDataReturn(SortDetailDataBean sortDetailDataBean);
    }

    interface  SortDetailPersenter extends IBasePersenter<SortDetailView>{//获取对应的数据
        void getSortDetailTabDatas(int id);
        void getSortDetailDatas(int catagoryId,int page,int size);
    }
}
