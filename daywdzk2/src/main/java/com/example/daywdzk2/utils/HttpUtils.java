package com.example.daywdzk2.utils;


import android.util.Log;

import com.example.daywdzk2.api.Api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2018/9/9.
 */

public class HttpUtils {

    private  static HttpUtils httpUtils;
    private  OkHttpClient okHttpClient;
    //有参
    private  HttpUtils(){
      okHttpClient  =  new  OkHttpClient.Builder()
                .addInterceptor(new longinterceptor())
                .build();
    }
    //创建拦截器
     class  longinterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //创建方法
            String method = request.method();
            //请求地址
            HttpUrl url = request.url();
            //打印日志信息
            Log.i("xxx",method+"===="+url);
            //响应
            Response response = chain.proceed(request);
            return response;
        }
    }
    //单例
    public  static  HttpUtils getinstance(){
        if (httpUtils==null){
            synchronized (HttpUtils.class){
                if (httpUtils==null){
                     httpUtils = new HttpUtils();
                }
            }
        }
        return  httpUtils;
    }
    //get方法
    public Api getpost(String base){
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                //拼接地址
                .baseUrl(base)
                //添加retrofit对rxjava的支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //添加一个gson对象
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //获取接口
        Api api = retrofit.create(Api.class);
        return api;
    }
}
