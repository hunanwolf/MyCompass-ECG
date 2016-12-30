package com.compassecg.test720.compassecg.Home.AcitvityW.my.adapterW;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.compassecg.test720.compassecg.R;

/**
 * Created by anim on 2016/8/10.
 */

public class hisgoup_list_adapterW extends BaseAdapter {
    private Context mContext;
    private Activity activity;
    String[] urls;
    private Callback mCallback;

    public interface Callback {
        public void Invitationclick(View v);

        public void follclick(View v);
    }

    public hisgoup_list_adapterW(Context mContext, String[] urls, Activity activity, Callback callback) {
        this.mContext = mContext;
        this.urls = urls;
        this.activity = activity;
        this.mCallback = callback;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return 20;
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
            convertView = View.inflate(mContext, R.layout.item_hisgoup_list, null);
            indicator.lm_img = (ImageView) convertView.findViewById(R.id.lm_img);
            indicator.iv_name = (TextView) convertView.findViewById(R.id.iv_name);
            indicator.lv_position = (TextView) convertView.findViewById(R.id.lv_position);
            indicator.follow = (TextView) convertView.findViewById(R.id.follow);
//
            convertView.setTag(indicator);
        } else {
            indicator = (Indicator) convertView.getTag();
        }

        indicator.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.follclick(v);
            }
        });//申请

        return convertView;
    }

    public class Indicator {
        ImageView lm_img;
        TextView iv_name;
        TextView lv_position;
        TextView follow;


    }
}



