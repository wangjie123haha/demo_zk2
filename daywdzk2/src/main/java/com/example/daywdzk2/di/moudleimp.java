package com.example.daywdzk2.di;

import com.example.daywdzk2.api.Api;
import com.example.daywdzk2.app.app;
import com.example.daywdzk2.bean.news;
import com.example.daywdzk2.bean.work;
import com.example.daywdzk2.bean.workDao;
import com.example.daywdzk2.constant.constant;
import com.example.daywdzk2.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/9/9.
 */

public class moudleimp implements  icontract.imoudle {
    @Override
    public void requestdata(final callisten callisten) {
        //获取数据库表
        final workDao workDao =  app.getinstance().getdoasession().getWorkDao();
        //进行全查
        final List<work> works = workDao.loadAll();
        //判断
        if (works.size()>0){
            //进行接口回传
            callisten.responsemsg(works);
            return;
        }
        //查不到进行网络请求
        HttpUtils httpUtils = HttpUtils.getinstance();
        //获取接口
        Api api = httpUtils.getpost(constant.BASE_URL);
        //获取接口中的方法
        Observable<news> observable = api.getresponse();
        //获取具体的参数
        observable
                //运行在io线程
                .subscribeOn(Schedulers.io())
                //回调在主线程
               .observeOn(AndroidSchedulers.mainThread())
                //进行不完全回调
               .subscribe(new Consumer<news>() {
                   //成功
                   @Override
                   public void accept(news news) throws Exception {
                        //获取具体的对象
                       List<com.example.daywdzk2.bean.news.DataBean> data = news.getData();
                       //创建新的集合进行回传
                       ArrayList<work> works1 = new ArrayList<>();
                       //进行遍历
                       for (int i = 0; i <data.size() ; i++) {
                           String title1 = data.get(i).getTitle();
                           String logo = data.get(i).getLogo();
                           //创建对象
                           work work = new work();
                           work.setTitle1(title1);
                           work.setImgageurl(logo);
                           works1.add(work);
                       }
                       callisten.responsemsg(works1);
                       workDao.insertInTx(works1);
                   }
               }, new Consumer<Throwable>() {
                   //失败
                   @Override
                   public void accept(Throwable throwable) throws Exception {
                       callisten.responsemsg(null);
                   }
               });

    }
}
