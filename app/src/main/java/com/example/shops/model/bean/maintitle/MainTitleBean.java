package com.example.shops.model.bean.maintitle;

import java.util.List;

public class MainTitleBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"count":20,"totalPages":1,"pageSize":20,"currentPage":1,"data":[{"id":314,"title":"关爱他成长的每一个足迹","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14943267735961674.jpg","subtitle":"专业运动品牌同厂，毛毛虫鞋买二送一"},{"id":313,"title":"一次解决5个节日送礼难题","price_info":59.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14942996754171334.jpg","subtitle":"这些就是他们想要的礼物清单"},{"id":300,"title":"秒杀化学洗涤剂的纯天然皂","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14939843143621089.jpg","subtitle":"前段时间有朋友跟我抱怨，和婆婆住到一起才发现生活理念有太多不和。别的不提，光是洗..."},{"id":299,"title":"买过的人都说它是差旅神器","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14938873919030679.jpg","subtitle":"许多人经历过旅途中内裤洗晾不便的烦恼，尤其与旅伴同居一室时，晾在卫生间里的内裤更..."},{"id":295,"title":"他们在严选遇见的新生活","price_info":35.8,"scene_pic_url":"https://yanxuan.nosdn.127.net/14938092956370380.jpg","subtitle":"多款商品直减中，最高直减400元"},{"id":294,"title":"这只锅，可以从祖母用到孙辈","price_info":149,"scene_pic_url":"https://yanxuan.nosdn.127.net/14937214454750141.jpg","subtitle":"买100年传世珐琅锅送迷你马卡龙色小锅"},{"id":291,"title":"舒适新主张","price_info":29,"scene_pic_url":"https://yanxuan.nosdn.127.net/14939496197300723.jpg","subtitle":"如何挑选适合自己的好物？"},{"id":289,"title":"专业运动袜也可以高性价比","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14932840600970609.jpg","subtitle":"越来越多运动人士意识到，运动鞋要购置好的，鞋里的运动袜也不可忽视。专业运动袜帮助..."},{"id":287,"title":"严选新式样板间","price_info":29.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14931970965550315.jpg","subtitle":"一种软装一个家"},{"id":286,"title":"无\u201c油\u201d无虑的甜蜜酥脆","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14931121822100127.jpg","subtitle":"大家都知道，饮食组是严选体重最重的一组，基本上每个新人都能在一个月之内迅速长胖。..."},{"id":281,"title":"条纹新风尚","price_info":29,"scene_pic_url":"https://yanxuan.nosdn.127.net/14926859849200826.jpg","subtitle":"经典百搭，时尚线条"},{"id":282,"title":"成就一室笋香","price_info":12,"scene_pic_url":"https://yanxuan.nosdn.127.net/14927695046601069.jpg","subtitle":"三石哥办公室常备小食推荐"},{"id":283,"title":"孩子成长中少不了的一双鞋","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14927748974441080.jpg","subtitle":"说起毛毛虫鞋，好处实在太多了，作为一个2岁孩子的宝妈选品员，按捺不住想告诉大家，..."},{"id":277,"title":"治愈生活的满怀柔软","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14926737925770587.jpg","subtitle":"太鼓抱枕的上架历程，是从失踪开始的。由于表面的绒感，最初它被安排在秋冬季上架。某..."},{"id":274,"title":"没有软木拖，怎么过夏天","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14925822213780237.jpg","subtitle":"刚入四月，杭州的气温就已升高至30度。店庆时买了软木拖的用户，陆续发回评价说，很..."},{"id":272,"title":"料理也要精细简单","price_info":69,"scene_pic_url":"https://yanxuan.nosdn.127.net/14925200530030186.jpg","subtitle":"享受天然的味道，日子每天都好新鲜"},{"id":271,"title":"选式新懒人","price_info":15,"scene_pic_url":"https://yanxuan.nosdn.127.net/14924199099661697.jpg","subtitle":"懒出格调，懒出好生活。"},{"id":268,"title":"米饭好吃的秘诀：会呼吸的锅","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14920623353130483.jpg","subtitle":"今年1月份，我们联系到了日本伊贺地区的长谷园，那里有着180年伊贺烧历史的窑厂。..."},{"id":266,"title":"一条丝巾就能提升时髦度","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14919007135160213.jpg","subtitle":"不知道大家对去年G20时，严选与国礼制造商一起推出的《凤凰于飞》等几款丝巾是否还..."},{"id":264,"title":"设计师们推荐的应季好物","price_info":29.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14918201901050274.jpg","subtitle":"原创设计春款系列上新"}]}
     */

    private int errno;
    private String errmsg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * count : 20
         * totalPages : 1
         * pageSize : 20
         * currentPage : 1
         * data : [{"id":314,"title":"关爱他成长的每一个足迹","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14943267735961674.jpg","subtitle":"专业运动品牌同厂，毛毛虫鞋买二送一"},{"id":313,"title":"一次解决5个节日送礼难题","price_info":59.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14942996754171334.jpg","subtitle":"这些就是他们想要的礼物清单"},{"id":300,"title":"秒杀化学洗涤剂的纯天然皂","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14939843143621089.jpg","subtitle":"前段时间有朋友跟我抱怨，和婆婆住到一起才发现生活理念有太多不和。别的不提，光是洗..."},{"id":299,"title":"买过的人都说它是差旅神器","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14938873919030679.jpg","subtitle":"许多人经历过旅途中内裤洗晾不便的烦恼，尤其与旅伴同居一室时，晾在卫生间里的内裤更..."},{"id":295,"title":"他们在严选遇见的新生活","price_info":35.8,"scene_pic_url":"https://yanxuan.nosdn.127.net/14938092956370380.jpg","subtitle":"多款商品直减中，最高直减400元"},{"id":294,"title":"这只锅，可以从祖母用到孙辈","price_info":149,"scene_pic_url":"https://yanxuan.nosdn.127.net/14937214454750141.jpg","subtitle":"买100年传世珐琅锅送迷你马卡龙色小锅"},{"id":291,"title":"舒适新主张","price_info":29,"scene_pic_url":"https://yanxuan.nosdn.127.net/14939496197300723.jpg","subtitle":"如何挑选适合自己的好物？"},{"id":289,"title":"专业运动袜也可以高性价比","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14932840600970609.jpg","subtitle":"越来越多运动人士意识到，运动鞋要购置好的，鞋里的运动袜也不可忽视。专业运动袜帮助..."},{"id":287,"title":"严选新式样板间","price_info":29.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14931970965550315.jpg","subtitle":"一种软装一个家"},{"id":286,"title":"无\u201c油\u201d无虑的甜蜜酥脆","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14931121822100127.jpg","subtitle":"大家都知道，饮食组是严选体重最重的一组，基本上每个新人都能在一个月之内迅速长胖。..."},{"id":281,"title":"条纹新风尚","price_info":29,"scene_pic_url":"https://yanxuan.nosdn.127.net/14926859849200826.jpg","subtitle":"经典百搭，时尚线条"},{"id":282,"title":"成就一室笋香","price_info":12,"scene_pic_url":"https://yanxuan.nosdn.127.net/14927695046601069.jpg","subtitle":"三石哥办公室常备小食推荐"},{"id":283,"title":"孩子成长中少不了的一双鞋","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14927748974441080.jpg","subtitle":"说起毛毛虫鞋，好处实在太多了，作为一个2岁孩子的宝妈选品员，按捺不住想告诉大家，..."},{"id":277,"title":"治愈生活的满怀柔软","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14926737925770587.jpg","subtitle":"太鼓抱枕的上架历程，是从失踪开始的。由于表面的绒感，最初它被安排在秋冬季上架。某..."},{"id":274,"title":"没有软木拖，怎么过夏天","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14925822213780237.jpg","subtitle":"刚入四月，杭州的气温就已升高至30度。店庆时买了软木拖的用户，陆续发回评价说，很..."},{"id":272,"title":"料理也要精细简单","price_info":69,"scene_pic_url":"https://yanxuan.nosdn.127.net/14925200530030186.jpg","subtitle":"享受天然的味道，日子每天都好新鲜"},{"id":271,"title":"选式新懒人","price_info":15,"scene_pic_url":"https://yanxuan.nosdn.127.net/14924199099661697.jpg","subtitle":"懒出格调，懒出好生活。"},{"id":268,"title":"米饭好吃的秘诀：会呼吸的锅","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14920623353130483.jpg","subtitle":"今年1月份，我们联系到了日本伊贺地区的长谷园，那里有着180年伊贺烧历史的窑厂。..."},{"id":266,"title":"一条丝巾就能提升时髦度","price_info":0,"scene_pic_url":"https://yanxuan.nosdn.127.net/14919007135160213.jpg","subtitle":"不知道大家对去年G20时，严选与国礼制造商一起推出的《凤凰于飞》等几款丝巾是否还..."},{"id":264,"title":"设计师们推荐的应季好物","price_info":29.9,"scene_pic_url":"https://yanxuan.nosdn.127.net/14918201901050274.jpg","subtitle":"原创设计春款系列上新"}]
         */

        private int count;
        private int totalPages;
        private int pageSize;
        private int currentPage;
        private List<DataBean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 314
             * title : 关爱他成长的每一个足迹
             * price_info : 0
             * scene_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
             * subtitle : 专业运动品牌同厂，毛毛虫鞋买二送一
             */

            private int id;
            private String title;
            private float price_info;
            private String scene_pic_url;
            private String subtitle;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public float getPrice_info() {
                return price_info;
            }

            public void setPrice_info(float price_info) {
                this.price_info = price_info;
            }

            public String getScene_pic_url() {
                return scene_pic_url;
            }

            public void setScene_pic_url(String scene_pic_url) {
                this.scene_pic_url = scene_pic_url;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }
        }
    }
}
