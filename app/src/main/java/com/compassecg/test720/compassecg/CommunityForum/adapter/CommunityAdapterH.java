package com.compassecg.test720.compassecg.CommunityForum.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.compassecg.test720.compassecg.CommunityForum.bean.Problem;
import com.compassecg.test720.compassecg.CommunityForum.fragment.CommunityAllFragmentH;
import com.compassecg.test720.compassecg.GroupConsultation.activity.BrowsePicActivityH;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.markActivityW;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.View.NetworkImageAdapter;
import com.compassecg.test720.compassecg.View.NineGridView;
import com.compassecg.test720.compassecg.View.RoundImageView;
import com.compassecg.test720.compassecg.unitl.TimeUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.finalteam.toolsfinal.DateUtils;

/**
 * 地址adapter
 * Created by Administrator on 2016/8/3 0003.
 */
public class CommunityAdapterH extends BaseAdapter {
    private final Context context;
    List<Problem> list= new ArrayList<>();
    public CommunityAdapterH(Context context, List<Problem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
            convertView=View.inflate(context,R.layout.item_for_community,null);

            holder.imgIv = (RoundImageView) convertView.findViewById(R.id.iv1);
            holder.nameTv = (TextView) convertView.findViewById(R.id.tv1);
            holder.contentTv = (TextView) convertView.findViewById(R.id.tv2);
            holder.timeTv = (TextView) convertView.findViewById(R.id.tv3);
            holder.numTv = (TextView) convertView.findViewById(R.id.tv4);
            holder.content2Tv = (TextView) convertView.findViewById(R.id.tv5);
            holder.mNineGridView = (NineGridView) convertView.findViewById(R.id.mNineGridView);

            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }

        holder.nameTv.setText(list.get(position).getNickname());
        holder.contentTv.setText(list.get(position).getTitle());
        holder.content2Tv.setText(list.get(position).getContent());
        String time = DateUtils.getTimeInterval(getTime(Long.parseLong(list.get(position).getTime() + "000")));
        holder.timeTv.setText(time);
        holder.numTv.setText(list.get(position).getAsw_num());
        Glide.with(context).load(list.get(position).getPic()).into(holder.imgIv);


        holder.imgIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        context.startActivity(new Intent(context, markActivityW.class).putExtra("type", list.get(position).getId()));
            }
        });

        //GroupPicAdapter adapter = new GroupPicAdapter(context);
       /* list.clear();
        list.add("http://i.dimg.cc/8f/3c/9f/39/8e/48/0b/b4/ff/0d/a8/8a/62/22/f3/6a.jpg");
        list.add("http://i.dimg.cc/8f/3c/9f/39/8e/48/0b/b4/ff/0d/a8/8a/62/22/f3/6a.jpg");
        list.add("http://i.dimg.cc/8f/3c/9f/39/8e/48/0b/b4/ff/0d/a8/8a/62/22/f3/6a.jpg");
        list.add("http://i.dimg.cc/8f/3c/9f/39/8e/48/0b/b4/ff/0d/a8/8a/62/22/f3/6a.jpg");
        list.add("http://i.dimg.cc/8f/3c/9f/39/8e/48/0b/b4/ff/0d/a8/8a/62/22/f3/6a.jpg");*/
        NetworkImageAdapter adapter = new NetworkImageAdapter(context, list.get(position).getImg());
        holder.mNineGridView.setAdapter(adapter);
        holder.mNineGridView.setOnImageClickListener(new Nicgriadview(position));
         return convertView;

    }

    public class Nicgriadview implements NineGridView.OnImageClickListener {
        private int posn;

        public Nicgriadview(int postion) {
            this.posn = postion;
        }

        @Override
        public void onImageCilcked(int position, View view) {
            /*current_posion = position;
            setViewPager(list3.get(posn).getPicture());*/
            Intent intent=new Intent(context, BrowsePicActivityH.class);
            intent.putExtra("path", (Serializable) list);
            intent.putExtra("position",String.valueOf(position));
            context.startActivity(intent);
        }
    }

    class ViewHolder{

        public TextView nameTv,contentTv,content2Tv,timeTv,numTv;
        public RoundImageView imgIv;
        public NineGridView mNineGridView;
    }

    /**
     * 将毫秒转为yyyy-MM-dd HH:mm:ss的date格式
     * @param time
     * @return
     */
    private String getTime(Long time){
        //long time=System.currentTimeMillis();//long now = android.os.SystemClock.uptimeMillis();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1=new Date(time);
        String t1=format.format(d1);
        Log.e("msg", t1);
        return t1;
    }

}
