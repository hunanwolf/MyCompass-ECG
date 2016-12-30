package com.compassecg.test720.compassecg.Home.AcitvityW.my;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW.AnswerW;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW.BIfragmentW;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW.CoursewareW;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW.HisGroupW;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW.MagazineW;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.adapterW.MarkPagerAdapterW;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.View.CustomViewPager;
import com.compassecg.test720.compassecg.unitl.BarBaseActivity;
import com.test720.auxiliary.Utils.T;

import java.util.ArrayList;
import java.util.List;


public class markActivityW extends BarBaseActivity {
    private List<Fragment> pagerContent = new ArrayList<>();
    private TabLayout tabs;
    LinearLayout elsel;
    private CustomViewPager pager;
    private MarkPagerAdapterW pagerAdapter;
    TextView intvtion;//邀请
    TextView farll;//关注
    TextView chat;//私聊

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);
        setTitleString("姓名");
        elsel = getView(R.id.elsel);
        switch (getIntent().getExtras().getInt("type")) {
            case 1:
                elsel.setVisibility(View.GONE);
                break;
            case 2:
                elsel.setVisibility(View.VISIBLE);
                break;
        }
        intvtion = getView(R.id.intvtion);
        getView(R.id.chat).setOnClickListener(this);
        getView(R.id.farll).setOnClickListener(this);
        initView();
    }


    public void initView() {

        tabs = getView(R.id.tabs);
        pager = getView(R.id.pager);
        pagerContent.add(new BIfragmentW());
        pagerContent.add(new HisGroupW());
        pagerContent.add(new AnswerW());
        pagerContent.add(new MagazineW(-1));
        pagerContent.add(new CoursewareW(-1));
//        tabs.setTabMode(TabLayout.MODE_FIXED);
        //1.MODE_SCROLLABLE模式
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

//        //2.MODE_FIXED模式
//        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.addTab(tabs.newTab().setText("简介"));
        tabs.addTab(tabs.newTab().setText("TA的组"));
        tabs.addTab(tabs.newTab().setText("回答"));
        tabs.addTab(tabs.newTab().setText("杂志"));
        tabs.addTab(tabs.newTab().setText("课件"));
        pagerAdapter = new MarkPagerAdapterW(getSupportFragmentManager(), pagerContent);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(0);
        pager.setPagingEnabled(false);
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                tabs.getTabAt(position).select();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        pager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.chat:
                T.showShort(mContext, "私聊");
                break;

            case R.id.farll:

                T.showShort(mContext, "邀请");
                break;

            case R.id.intvtion:
                T.showShort(mContext, "关注");
                intvtion.setText("已关注");
                break;
        }
    }
}
