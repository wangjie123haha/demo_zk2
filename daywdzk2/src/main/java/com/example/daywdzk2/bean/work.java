package com.example.daywdzk2.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lenovo on 2018/9/9.
 */
@Entity
public class work {
    @Id(autoincrement = true)
    Long id;
    @Property
    String imgageurl;
    @Property
    String title1;
    @Generated(hash = 2110996042)
    public work(Long id, String imgageurl, String title1) {
        this.id = id;
        this.imgageurl = imgageurl;
        this.title1 = title1;
    }
    @Generated(hash = 1240973331)
    public work() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImgageurl() {
        return this.imgageurl;
    }
    public void setImgageurl(String imgageurl) {
        this.imgageurl = imgageurl;
    }
    public String getTitle1() {
        return this.title1;
    }
    public void setTitle1(String title1) {
        this.title1 = title1;
    }
}
