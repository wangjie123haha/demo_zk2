package com.example.daywdzk2.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daywdzk2.R;
import com.example.daywdzk2.bean.work;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by lenovo on 2018/9/9.
 */

public class myadapter extends RecyclerView.Adapter<myadapter.oneholder> {
    private Context context;
    private  List<work> list;

    public myadapter(Context context, List<work> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public oneholder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.include1, null);
         oneholder oneholder = new oneholder(view);
         return oneholder;
    }

    @Override
    public void onBindViewHolder(oneholder holder, int position) {
         holder.title1.setText(list.get(position).getTitle1());
        Uri uri = Uri.parse(list.get(position).getImgageurl());
        holder.my_image_view.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //创建视图
    class  oneholder extends  RecyclerView.ViewHolder{

        private final SimpleDraweeView my_image_view;
        private final TextView title1;

        public oneholder(View itemView) {
            super(itemView);
            //初始化
            my_image_view = itemView.findViewById(R.id.my_image_view);
            title1 = itemView.findViewById(R.id.title1);
        }
    }
}
