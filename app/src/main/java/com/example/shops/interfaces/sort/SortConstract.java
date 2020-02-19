package com.example.shops.interfaces.sort;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.sort.SortDataBean;
import com.example.shops.model.bean.sort.SortGoodsListBean;

//分类里的契约类  用于返回数据及绑定p  v
public interface SortConstract {
    interface View extends IBaseView{
        //将View层分类数据返回
        void getSortDataReturn(SortDataBean sortDataBean);
        //将分类详细数据返回
        void getSortGoodsListReturn(SortGoodsListBean sortGoodsListBean);
    }

    //将p和view 关联获取数据
    interface Persenter extends IBasePersenter<View>{
        //获取分类数据
        void getSortDatas();
        //获取分类
        void getSortGoodsList(int id);
    }
}
