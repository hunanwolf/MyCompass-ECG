package com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.unitl.Connector;
import com.test720.auxiliary.Utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2016/12/14.
 */

public class MagazineW extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    magazine_Grad_adapterW adapterW;
    SwipeRefreshLayout swip;
    GridView gridview;

    List<String> listll = new ArrayList<>();
    public static MagazineW maninfrag = null;
    int index = -1;

    public MagazineW(int i) {
        super();
        this.index = i;
    }

    List<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_magazine, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        maninfrag = this;
        gridview = getView(R.id.gridview);
        listll.clear();
        swip = getView(R.id.swip);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");

        adapterW = new magazine_Grad_adapterW(getActivity(), list);
        adapterW.setSelectItem(index);
        gridview.setAdapter(adapterW);

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked) {
            if (listll.contains(buttonView.getTag())) {
                listll.remove(buttonView.getTag());
                //已选中移除
                ShowToast("删除" + listll.size());
            }
        } else {
            if (!listll.contains(buttonView.getTag())) {
                //未选中添加
                listll.add((String) buttonView.getTag());

                ShowToast("添加" + listll.size());
            }
        }
    }

    public class magazine_Grad_adapterW extends BaseAdapter {

//    private String list[] = {"待付抢单","待付款","待发货","待收货","待评价","异常订单"};
//    private int icon[] = {R.drawable.qiang_da,R.drawable.dai_fukuan,R.drawable.dai_fahuo,R.drawable.dai_shouhuo,R.drawable.dai_evaluate,R.drawable.yichang_dingdan};

        List<String> list;
        private Context mContext;

        public magazine_Grad_adapterW(Context mContext, List<String> list) {
            this.mContext = mContext;
            this.list = list;

        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Indicator indicator = null;

            if (convertView == null) {
                indicator = new Indicator();
                convertView = View.inflate(mContext, R.layout.item_coureseware_gradview, null);
                indicator.title = (TextView) convertView.findViewById(R.id.title);
                indicator.img = (ImageView) convertView.findViewById(R.id.img);
                indicator.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
                indicator.checkBox.setOnCheckedChangeListener(MagazineW.maninfrag);
                Glide.with(mContext)
                        .load(Connector.lll + "k")
                        .placeholder(R.mipmap.kej)
                        .centerCrop()
                        .into(indicator.img);
                convertView.setTag(indicator);
            } else {
                indicator = (Indicator) convertView.getTag();
            }

            if (selectItem == -1) {
                indicator.checkBox.setVisibility(View.INVISIBLE);
            } else {
                indicator.checkBox.setVisibility(View.VISIBLE);
            }
            indicator.checkBox.setTag(list.get(position));
            indicator.checkBox.setChecked(listll.contains(list.get(position)));//重用

            indicator.title.setText(list.get(position));
//       indicator.img.setImageResource(icon[position]);

            return convertView;
        }

        public void setSelectItem(int selectItem) {
            this.selectItem = selectItem;
        }

        private int selectItem = -1;

        private class Indicator {
            private TextView title;
            private ImageView img;
            CheckBox checkBox;
        }
    }

    public void adapternoyicefiy(int i) {
        adapterW.setSelectItem(i);
        adapterW.notifyDataSetChanged();
    }


    public void changgede() {

        list.removeAll(listll);
        adapterW.setSelectItem(-1);
        adapterW.notifyDataSetChanged();
        listll.clear();
    }
    public void adachangge() {
        listll.clear();
        adapterW.setSelectItem(-1);
        adapterW.notifyDataSetChanged();
    }
}
