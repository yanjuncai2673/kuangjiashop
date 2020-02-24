package com.example.shops.interfaces.sort.cart;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.sort.cart.SortDetailItemBean;

public interface CartConstart {
    interface View extends IBaseView{
        void getSortDetailItemDataReturn(SortDetailItemBean sortDetailItemBean);
    }
    interface  Persenter extends IBasePersenter<View>{
        void getSortDetailItemData(int id);
    }
}
