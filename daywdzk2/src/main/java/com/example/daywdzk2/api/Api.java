package com.example.daywdzk2.api;

import com.example.daywdzk2.bean.news;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2018/9/9.
 */

public interface Api {

    @GET("content_lists&version=1.7&token=&type=1&cat=&catid2=&page=1")
    Observable<news> getresponse();
}
