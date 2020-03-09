package com.example.shops.interfaces.maintitle;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.maintitle.MainTitleBean;

public interface MainTitleConstract {
    interface View extends IBaseView{
        void getMainTitleDataReturn(MainTitleBean mainTitleBean);
    }
    interface Presenter extends IBasePersenter<View>{
        void getMainTitleData(int page,int size);
    }
}
