package com.example.daywdzk2.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.daywdzk2.R;
import com.example.daywdzk2.fragment.frag1;
import com.example.daywdzk2.fragment.frag2;
import com.example.daywdzk2.fragment.frag3;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragm)
    FrameLayout fragm;
    @BindView(R.id.rap)
    RadioGroup rap;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        ButterKnife.bind(this);
        //创建对象
        final frag1 frag1 = new frag1();
        final frag2 frag2 = new frag2();
        final frag3 frag3 = new frag3();
        // 事务提交
        manager = getSupportFragmentManager();
        //默认使用第一个
        manager.beginTransaction().replace(R.id.fragm,frag1).commit();
        //条目的监听事件
        rap.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //获取事务
                FragmentTransaction transaction = manager.beginTransaction();
                switch (i){
                    case R.id.rap1:
                      transaction.replace(R.id.fragm,frag1);
                      break;
                    case R.id.rap2:
                        transaction.replace(R.id.fragm,frag2);
                        break;
                    case R.id.rap3:
                        transaction.replace(R.id.fragm,frag3);
                        break;
                }
                //提交事务
                 transaction.commit();
            }
        });
    }
}
