package com.compassecg.test720.compassecg.Home.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.compassecg.test720.compassecg.BigImage.ImageViewpagerActivity;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.View.CircleImageView;
import com.compassecg.test720.compassecg.View.NetworkImageAdapter;
import com.compassecg.test720.compassecg.View.NineGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anim on 2016/8/10.
 */

public class forum_list_adapterW extends BaseAdapter {
    private Context mContext;
    private Activity activity;
    String[] urls;
    private int current_posion;//当前position
    private Callback mCallback;
    List<String> lll = new ArrayList<>();

    public interface Callback {


        public void Clean(View v);
    }

    public forum_list_adapterW(Context mContext, String[] urls, Activity activity, Callback callback) {
        this.mContext = mContext;
        this.urls = urls;
        this.activity = activity;
        this.mCallback = callback;
        lll.add("http://img3.duitang.com/uploads/item/201609/15/20160915184656_TrwKP.thumb.700_0.jpeg");
        lll.add("http://image.tianjimedia.com/uploadImages/upload/20141119/330bwkzdvkjjpg.jpg");
        lll.add("http://v1.qzone.cc/avatar/201408/17/14/22/53f04a277d3dd110.jpg%21200x200.jpg");
        lll.add("http://v1.qzone.cc/avatar/201406/28/21/54/53aec923d05fe226.jpg!200x200.jpg");
    }

    @Override
    public int getCount() {
        return lll.size();
    }

    @Override
    public Object getItem(int position) {
        return lll.get(position);
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
            convertView = View.inflate(mContext, R.layout.item_forum_layout, null);
            indicator.htderde = (CircleImageView) convertView.findViewById(R.id.htderde);
            indicator.nicname = (TextView) convertView.findViewById(R.id.nicname);
            indicator.gallery = (NineGridView) convertView.findViewById(R.id.gallery);
            indicator.clean = (RelativeLayout) convertView.findViewById(R.id.clean);
            convertView.setTag(indicator);
        } else {
            indicator = (Indicator) convertView.getTag();
        }
        if (setisition == -1) {
            indicator.clean.setVisibility(View.INVISIBLE);
        } else {
            indicator.clean.setVisibility(View.VISIBLE);
        }
        NetworkImageAdapter adapter = new NetworkImageAdapter(activity, lll);
        indicator.gallery.setAdapter(adapter);
        indicator.gallery.setVisibility(View.VISIBLE);
        indicator.gallery.setEnabled(false);
        indicator.clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.Clean(v);
            }
        });

        indicator.gallery.setOnImageClickListener(new Nicgriadview(position));
//        if (list3.get(position).getPicture().size() == 0) {
//            indicator.gallery.setVisibility(View.GONE);
//        } else {
//            indicator.gallery.setVisibility(View.VISIBLE);
//            NetworkImageAdapter Gradview_Adapter = new NetworkImageAdapter(activity, list3.get(position).getPicture());
//            indicator.gallery.setAdapter(Gradview_Adapter);
//            indicator.gallery.setOnImageClickListener(new Nicgriadview(position));
//        }

        return convertView;
    }

    public class Indicator {
        CircleImageView htderde;
        TextView nicname;
        TextView lt_title;
        TextView lt_conuntext;
        TextView time;
        TextView lv_huiofuc;
        NineGridView gallery;
        RelativeLayout clean;
    }

    public void setVisition(int setisition) {
        this.setisition = setisition;
    }

    private int setisition = -1;

    public class Nicgriadview implements NineGridView.OnImageClickListener {
        private int posn;

        public Nicgriadview(int postion) {
            this.posn = postion;
        }

        @Override
        public void onImageCilcked(int position, View view) {
            current_posion = position;
            mContext.startActivity(new Intent(mContext, ImageViewpagerActivity.class).putExtra("type", current_posion));
            activity.overridePendingTransition(R.anim.umeng_socialize_fade_in, R.anim.umeng_socialize_fade_out);
        }

    }
}



