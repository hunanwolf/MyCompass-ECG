package com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.compassecg.test720.compassecg.Home.AcitvityW.my.adapterW.hisgoup_list_adapterW;
import com.compassecg.test720.compassecg.R;
import com.test720.auxiliary.Utils.BaseFragment;

/**
 * Created by hp on 2016/12/14.
 */

public class HisGroupW extends BaseFragment implements hisgoup_list_adapterW.Callback{

    SwipeRefreshLayout swip;
    ListView list;
    hisgoup_list_adapterW adapter;
    String[] urls={""};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_hisgroup, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter=new hisgoup_list_adapterW(getContext(),urls,getActivity(),this);
        list=getView(R.id.list);
        swip=getView(R.id.swip);
        list.setAdapter(adapter);
    }

    @Override
    public void Invitationclick(View v) {

    }

    @Override
    public void follclick(View v) {
ShowToast("申请加入");
    }
}
