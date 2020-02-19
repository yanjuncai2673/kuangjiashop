package com.example.shops.utils;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
//封装工具类切换线程
public class RxUtils {
    /**
     * rxjava 线程切换统一处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T,T> rxScheduler(){
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
