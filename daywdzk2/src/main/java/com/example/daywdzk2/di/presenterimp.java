package com.example.daywdzk2.di;

import com.example.daywdzk2.bean.work;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by lenovo on 2018/9/9.
 */

public class presenterimp implements  icontract.ipresenter<icontract.iview> {
    private  icontract.iview iview;
    private moudleimp moudleimp;
    private WeakReference<icontract.iview> iviewWeakReference;
    private WeakReference<icontract.imoudle> weakReference;

    @Override
    public void attachview(icontract.iview iview) {
         this.iview = iview;
         moudleimp = new moudleimp();
         //弱引用解绑
        iviewWeakReference = new WeakReference<>(iview);
        weakReference = new WeakReference<icontract.imoudle>(moudleimp);
    }

    @Override
    public void detachview(icontract.iview iview) {
       iviewWeakReference.clear();
       weakReference.clear();
    }

    @Override
    public void requestinfo() {
        //调用方法
       moudleimp.requestdata(new icontract.imoudle.callisten() {
           @Override
           public void responsemsg(List<work> works) {
               //调用view方法
                iview.showdata(works);
           }
       });
    }
}
