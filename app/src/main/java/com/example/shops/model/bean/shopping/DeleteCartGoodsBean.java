package com.example.shops.model.bean.shopping;

import java.util.List;

public class DeleteCartGoodsBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":114,"user_id":5,"session_id":"1","goods_id":1086015,"goods_sn":"1086015","product_id":103,"goods_name":"北欧极简直杆台灯","market_price":249,"retail_price":249,"number":1,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/d5c2ecfe0fb00cdd8b829975bab21a31.png"},{"id":117,"user_id":5,"session_id":"1","goods_id":1181000,"goods_sn":"Y100400","product_id":2,"goods_name":"母亲节礼物-舒适安睡组合","market_price":1500,"retail_price":1500,"number":1,"goods_specifition_name_value":"1.5m床垫*1+枕头*2;玛瑙红","goods_specifition_ids":"1_4","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png"},{"id":118,"user_id":5,"session_id":"1","goods_id":1147047,"goods_sn":"1147047","product_id":227,"goods_name":"简约知性系列居家地毯 蓝粉拼接","market_price":559,"retail_price":559,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/bda805b0a2464b6ec33c18981565e50e.png"},{"id":119,"user_id":5,"session_id":"1","goods_id":1147048,"goods_sn":"1147048","product_id":228,"goods_name":"简约知性系列居家地毯 蓝灰格","market_price":559,"retail_price":559,"number":11,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/fd7920a2eadd10fa10c0c03959a2abe0.png"},{"id":120,"user_id":5,"session_id":"1","goods_id":1147046,"goods_sn":"1147046","product_id":226,"goods_name":"清新趣粉系列居家地毯 条纹间粉","market_price":599,"retail_price":599,"number":7,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/655d718df8107f8e7fd1dc6140e29039.png"},{"id":121,"user_id":5,"session_id":"1","goods_id":1064022,"goods_sn":"1064022","product_id":79,"goods_name":"清欢日式可调节落地灯","market_price":299,"retail_price":299,"number":7,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/a9c155e26d09e3c92b623f0472ed674a.png"},{"id":122,"user_id":5,"session_id":"1","goods_id":1155000,"goods_sn":"1155000","product_id":241,"goods_name":"清新趣粉全棉四件套 条纹绿格","market_price":399,"retail_price":399,"number":5,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png"}],"cartTotal":{"goodsCount":35,"goodsAmount":17856,"checkedGoodsCount":0,"checkedGoodsAmount":0}}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cartList : [{"id":114,"user_id":5,"session_id":"1","goods_id":1086015,"goods_sn":"1086015","product_id":103,"goods_name":"北欧极简直杆台灯","market_price":249,"retail_price":249,"number":1,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/d5c2ecfe0fb00cdd8b829975bab21a31.png"},{"id":117,"user_id":5,"session_id":"1","goods_id":1181000,"goods_sn":"Y100400","product_id":2,"goods_name":"母亲节礼物-舒适安睡组合","market_price":1500,"retail_price":1500,"number":1,"goods_specifition_name_value":"1.5m床垫*1+枕头*2;玛瑙红","goods_specifition_ids":"1_4","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png"},{"id":118,"user_id":5,"session_id":"1","goods_id":1147047,"goods_sn":"1147047","product_id":227,"goods_name":"简约知性系列居家地毯 蓝粉拼接","market_price":559,"retail_price":559,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/bda805b0a2464b6ec33c18981565e50e.png"},{"id":119,"user_id":5,"session_id":"1","goods_id":1147048,"goods_sn":"1147048","product_id":228,"goods_name":"简约知性系列居家地毯 蓝灰格","market_price":559,"retail_price":559,"number":11,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/fd7920a2eadd10fa10c0c03959a2abe0.png"},{"id":120,"user_id":5,"session_id":"1","goods_id":1147046,"goods_sn":"1147046","product_id":226,"goods_name":"清新趣粉系列居家地毯 条纹间粉","market_price":599,"retail_price":599,"number":7,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/655d718df8107f8e7fd1dc6140e29039.png"},{"id":121,"user_id":5,"session_id":"1","goods_id":1064022,"goods_sn":"1064022","product_id":79,"goods_name":"清欢日式可调节落地灯","market_price":299,"retail_price":299,"number":7,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/a9c155e26d09e3c92b623f0472ed674a.png"},{"id":122,"user_id":5,"session_id":"1","goods_id":1155000,"goods_sn":"1155000","product_id":241,"goods_name":"清新趣粉全棉四件套 条纹绿格","market_price":399,"retail_price":399,"number":5,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png"}]
         * cartTotal : {"goodsCount":35,"goodsAmount":17856,"checkedGoodsCount":0,"checkedGoodsAmount":0}
         */

        private CartTotalBean cartTotal;
        private List<CartListBean> cartList;

        public CartTotalBean getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalBean cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListBean> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListBean> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalBean {
            /**
             * goodsCount : 35
             * goodsAmount : 17856
             * checkedGoodsCount : 0
             * checkedGoodsAmount : 0
             */

            private int goodsCount;
            private int goodsAmount;
            private int checkedGoodsCount;
            private int checkedGoodsAmount;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public int getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(int goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public int getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(int checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public int getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(int checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListBean {
            /**
             * id : 114
             * user_id : 5
             * session_id : 1
             * goods_id : 1086015
             * goods_sn : 1086015
             * product_id : 103
             * goods_name : 北欧极简直杆台灯
             * market_price : 249
             * retail_price : 249
             * number : 1
             * goods_specifition_name_value :
             * goods_specifition_ids :
             * checked : 0
             * list_pic_url : http://yanxuan.nosdn.127.net/d5c2ecfe0fb00cdd8b829975bab21a31.png
             */

            private int id;
            private int user_id;
            private String session_id;
            private int goods_id;
            private String goods_sn;
            private int product_id;
            private String goods_name;
            private int market_price;
            private int retail_price;
            private int number;
            private String goods_specifition_name_value;
            private String goods_specifition_ids;
            private int checked;
            private String list_pic_url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public int getMarket_price() {
                return market_price;
            }

            public void setMarket_price(int market_price) {
                this.market_price = market_price;
            }

            public int getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(int retail_price) {
                this.retail_price = retail_price;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getGoods_specifition_name_value() {
                return goods_specifition_name_value;
            }

            public void setGoods_specifition_name_value(String goods_specifition_name_value) {
                this.goods_specifition_name_value = goods_specifition_name_value;
            }

            public String getGoods_specifition_ids() {
                return goods_specifition_ids;
            }

            public void setGoods_specifition_ids(String goods_specifition_ids) {
                this.goods_specifition_ids = goods_specifition_ids;
            }

            public int getChecked() {
                return checked;
            }

            public void setChecked(int checked) {
                this.checked = checked;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }
        }
    }
}
