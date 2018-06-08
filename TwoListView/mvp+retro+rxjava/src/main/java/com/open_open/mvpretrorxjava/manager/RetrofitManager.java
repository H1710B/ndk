package com.open_open.mvpretrorxjava.manager;


import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/1.
 */
public class RetrofitManager {
    //地址
    private String BaseURL ="http://123.57.133.62:8180/lifeshop/";



    private static OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;

    /**
     * 构建Retrofit
     *
     * @return
     */
    public Retrofit build() {
        initOkHttpClient();
        initRetrofit();
        return mRetrofit;
    }

    public RetrofitManager() {

    }

    protected void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    private void initOkHttpClient() {
        //拦截器，用于输出网络请求和结果的 Log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //初始化OkHttpClient
        mOkHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .build();


    }



}
