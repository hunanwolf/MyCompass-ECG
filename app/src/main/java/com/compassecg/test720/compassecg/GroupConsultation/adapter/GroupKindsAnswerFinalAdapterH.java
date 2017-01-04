package com.compassecg.test720.compassecg.GroupConsultation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.compassecg.test720.compassecg.GroupConsultation.activity.BrowsePicActivityH;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.markActivityW;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.View.NetworkImageAdapter;
import com.compassecg.test720.compassecg.View.NineGridView;
import com.compassecg.test720.compassecg.View.RoundImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 地址adapter
 * Created by Administrator on 2016/8/3 0003.
 */
public class GroupKindsAnswerFinalAdapterH extends BaseAdapter {
    private Context context;
    public GroupKindsAnswerFinalAdapterH(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item_for_group_kinds_answer_final,null);

            holder.imgIv = (RoundImageView) convertView.findViewById(R.id.iv1);
            holder.nameTv = (TextView) convertView.findViewById(R.id.tv1);
            holder.contentTv = (TextView) convertView.findViewById(R.id.tv2);
            holder.timeTv = (TextView) convertView.findViewById(R.id.tv5);

            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.imgIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, markActivityW.class).putExtra("type", 666));
            }
        });
         return convertView;

    }


    class ViewHolder{

        public TextView nameTv,contentTv,timeTv;
        public RoundImageView imgIv;
    }

}
