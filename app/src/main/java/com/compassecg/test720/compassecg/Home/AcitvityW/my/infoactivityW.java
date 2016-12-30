package com.compassecg.test720.compassecg.Home.AcitvityW.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.bumptech.glide.Glide;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.Setfocus.SetupActivity;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.View.CircleImageView;
import com.compassecg.test720.compassecg.unitl.BarBaseActivity;
import com.compassecg.test720.compassecg.unitl.Connector;

public class infoactivityW extends BarBaseActivity {
    CircleImageView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoactivity);
        setTitleString("个人中心");

        getView(R.id.follow).setOnClickListener(this);//关注
        getView(R.id.Fans).setOnClickListener(this);//粉丝
        getView(R.id.information).setOnClickListener(this);//个人信息
        getView(R.id.mark).setOnClickListener(this);//个人主页
        getView(R.id.bought).setOnClickListener(this);//我的提问
        getView(R.id.Mydownload).setOnClickListener(this);//我的下载
        getView(R.id.Mycollection).setOnClickListener(this);//我的收藏
        getView(R.id.Sharegift).setOnClickListener(this);//分享有礼
        getView(R.id.Setfocus).setOnClickListener(this);//设置中心
        getView(R.id.integral).setOnClickListener(this);//积分
        header = getView(R.id.header);
        Glide.with(mContext)
                .load(Connector.lll + "k")
                .placeholder(R.drawable.index_head)
                .centerCrop()
                .into(header);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.Fans://粉丝

                startActivity(new Intent(this, FansActivityW.class));
                break;

            case R.id.follow://关注

                startActivity(new Intent(this, followActivityW.class));
                break;

            case R.id.information://个人信息
                startActivity(new Intent(this, informationActivity.class));
                break;

            case R.id.mark://个人主页
                startActivity(new Intent(this, markActivityW.class).putExtra("type", 1));
                break;
            case R.id.bought://我的提问
                startActivity(new Intent(this, boughtActivity.class).putExtra("type", 1));
                break;

            case R.id.Mydownload://我的下载
                startActivity(new Intent(this, MydownloadActivity.class));

                break;

            case R.id.Mycollection://我的收藏
                startActivity(new Intent(this, boughtActivity.class).putExtra("type", 2));
                break;

            case R.id.Sharegift://分享有礼

                break;

            case R.id.Setfocus://设置中心
                startActivity(new Intent(this, SetupActivity.class));
                break;

            case R.id.integral:

                startActivity(new Intent(this, integralActivity.class));
                break;
        }
    }
}
