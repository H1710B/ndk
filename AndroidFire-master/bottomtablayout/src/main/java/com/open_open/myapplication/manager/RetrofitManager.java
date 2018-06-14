package com.open_open.myapplication.manager;

import com.google.gson.Gson;
import com.open_open.myapplication.contents.Contents;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/******************************************
 * 类名称：RetrofitManager
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class RetrofitManager {
    //地址
    private String BaseURL = Contents.BASEURL;
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
