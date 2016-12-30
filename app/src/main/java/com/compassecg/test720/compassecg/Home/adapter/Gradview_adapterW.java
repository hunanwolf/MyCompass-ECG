package com.compassecg.test720.compassecg.Home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.View.CircleImageView;
import com.compassecg.test720.compassecg.unitl.Connector;

import java.util.List;

/**
 * Created by anim on 2016/8/9.
 */

public class Gradview_adapterW extends BaseAdapter {

//    private String list[] = {"待付抢单","待付款","待发货","待收货","待评价","异常订单"};
//    private int icon[] = {R.drawable.qiang_da,R.drawable.dai_fukuan,R.drawable.dai_fahuo,R.drawable.dai_shouhuo,R.drawable.dai_evaluate,R.drawable.yichang_dingdan};

    List<String> list;
    private Context mContext;
    private Callback mCallback;



    public interface Callback {


        public void Chouse(View v);
    }

    public Gradview_adapterW(Context mContext, List<String> list, Callback callback) {
        this.mContext = mContext;
        this.list = list;
        this.mCallback = callback;
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
            convertView = View.inflate(mContext, R.layout.item_search_gradview, null);
            indicator.name = (TextView) convertView.findViewById(R.id.name);
            indicator.textView = (TextView) convertView.findViewById(R.id.textView);
            indicator.iv_icon = (CircleImageView) convertView.findViewById(R.id.header);
            indicator.zhwei= (TextView) convertView.findViewById(R.id.zhwei);
            Glide.with(mContext)
                    .load(Connector.lll + "k")
                    .placeholder(R.drawable.index_head)
                    .centerCrop()
                    .into(indicator.iv_icon);
            convertView.setTag(indicator);
        } else {
            indicator = (Indicator) convertView.getTag();
        }
        indicator.name.setText(list.get(position));
//        indicator.iv_icon.setImageResource(icon[position]);
        indicator.textView.setTag(position);
        indicator.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.Chouse(v);
            }
        });
        return convertView;
    }

    public class Indicator {
        private TextView name;
        private CircleImageView iv_icon;
        private TextView textView;
        private TextView zhwei;
    }
}

