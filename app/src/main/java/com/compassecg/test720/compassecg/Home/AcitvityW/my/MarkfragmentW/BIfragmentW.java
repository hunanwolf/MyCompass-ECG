package com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.View.CircleImageView;
import com.compassecg.test720.compassecg.unitl.Connector;
import com.test720.auxiliary.Utils.BaseFragment;

/**
 * Created by hp on 2016/12/14.
 */

public class BIfragmentW extends BaseFragment {
    CircleImageView img_header;
    TextView name;//名字
    TextView zhiwei;//职位
    TextView zhicheng;//职称
    TextView histoy;//医院
    TextView keshi;//科室
    TextView intro;//专长
    TextView textView7;//经历

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_introduction, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        img_header = getView(R.id.img_header);
        name = getView(R.id.name);
        zhiwei = getView(R.id.zhiwei);
        zhicheng = getView(R.id.zhicheng);
        histoy = getView(R.id.histoy);
        keshi = getView(R.id.keshi);
        intro=getView(R.id.intro);
        textView7=getView(R.id.textView7);
        Glide.with(getActivity())
                .load(Connector.lll + "k")
                .placeholder(R.drawable.index_head)
                .centerCrop()
                .into(img_header);
    }
}
