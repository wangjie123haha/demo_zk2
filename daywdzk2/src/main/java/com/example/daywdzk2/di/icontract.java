package com.example.daywdzk2.di;

import com.example.daywdzk2.bean.work;

import java.util.List;

/**
 * Created by lenovo on 2018/9/9.
 */

public interface icontract {
    /**
     * iview层
     */
    public  interface  iview{

        //显示方法
        void  showdata(List<work> works);
    }
    /**
     * ipresenter
     */
    public  interface  ipresenter<iview>{
        //关联
        void  attachview(iview iview);
        //取消
        void  detachview(iview iview);
        //逻辑
        void  requestinfo();
    }
    /**
     * imoudle
     *
     */
    public  interface  imoudle{
        //接口回调
        public  interface  callisten{
            //信息回显
            void  responsemsg(List<work> works);
        }
        void  requestdata(callisten callisten);
    }
}
