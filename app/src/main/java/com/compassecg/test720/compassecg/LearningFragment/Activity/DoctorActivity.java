package com.compassecg.test720.compassecg.LearningFragment.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.compassecg.test720.compassecg.Home.AcitvityW.my.adapterW.Fans_list_adapterW;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.markActivityW;
import com.compassecg.test720.compassecg.Home.seach.search_activity;
import com.compassecg.test720.compassecg.R;
import com.test720.auxiliary.Utils.NoBarBaseActivity;

import static com.compassecg.test720.compassecg.Home.seach.search_activity.JNLAKNGANGALKM;

public class DoctorActivity extends NoBarBaseActivity implements Fans_list_adapterW.Callback {
    ListView listView;
    SwipeRefreshLayout swip;
    Fans_list_adapterW adapter;
    String[] urls = {};
    RelativeLayout back;
    RelativeLayout search;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        listView = getView(R.id.list);
        swip = getView(R.id.swip);
        tv_title = getView(R.id.tv_title);
        search = getView(R.id.search);

        getView(R.id.back).setOnClickListener(this);
        getView(R.id.search).setOnClickListener(this);

        if("成员".equals(getIntent().getStringExtra("type"))){
            tv_title.setText("成员列表");
            search.setVisibility(View.GONE);
            adapter = new Fans_list_adapterW(this, urls, this, this,1);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    //startActivity(new Intent(DoctorActivity.this, markActivityW.class).putExtra("type", 2));
                }
            });
        }else if("医生".equals(getIntent().getStringExtra("type"))) {
            tv_title.setText("医生列表");
            adapter = new Fans_list_adapterW(this, urls, this, this,2);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    startActivity(new Intent(DoctorActivity.this, markActivityW.class).putExtra("type", 2));
                }
            });
        }
    }

    @Override
    public void Invitationclick(View v) {
        ShowToast("邀请");
    }

    @Override
    public void follclick(View v) {
        ShowToast("关注");
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.search: //搜索


                startActivity(new Intent(this,search_activity.class).putExtra("type",JNLAKNGANGALKM));
                break;
        }
    }
}
