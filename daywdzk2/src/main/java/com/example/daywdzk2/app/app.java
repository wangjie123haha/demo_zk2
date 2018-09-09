package com.example.daywdzk2.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.daywdzk2.bean.DaoMaster;
import com.example.daywdzk2.bean.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by lenovo on 2018/9/9.
 */

public class app extends Application {
    private  static  app app;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        app =app.this;
        //获取数据库
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "beiw");
        //获取对象
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据
        DaoMaster daoMaster = new DaoMaster(db);
        //数据库的增删改查
        daoSession = daoMaster.newSession();
    }
    public  static  app getinstance(){
        if (app==null){
            app =new app();
        }
        return  app;
    }
    public DaoSession getdoasession(){
        return  daoSession;
    }
}
