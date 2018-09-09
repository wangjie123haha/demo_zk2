package com.example.daywdzk2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daywdzk2.R;
import com.example.daywdzk2.adapter.myadapter;
import com.example.daywdzk2.bean.work;
import com.example.daywdzk2.di.icontract;
import com.example.daywdzk2.di.presenterimp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2018/9/9.
 */

public class frag1 extends Fragment implements icontract.iview {
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    Unbinder unbinder;
    private presenterimp presenterimp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenterimp = new presenterimp();
        //关联
        presenterimp.attachview(this);
        //请求
        presenterimp.requestinfo();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        //取消关联
        presenterimp.detachview(this);
    }
  //具体操作
    @Override
    public void showdata(List<work> works) {
         //创建布局管理器
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        //添加布局管理器
        recycleview.setLayoutManager(manager);
        //创建适配器
        myadapter myadapter = new myadapter(getActivity(),works);
        //设置适配器
        recycleview.setAdapter(myadapter);
    }
}
