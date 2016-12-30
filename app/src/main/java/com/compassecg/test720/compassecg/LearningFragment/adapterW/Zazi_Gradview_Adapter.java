package com.compassecg.test720.compassecg.LearningFragment.adapterW;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.compassecg.test720.compassecg.Home.AcitvityW.my.MarkfragmentW.MagazineW;
import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.unitl.Connector;

import java.util.List;

import static com.compassecg.test720.compassecg.R.id.img;

/**
 * Created by hp on 2016/12/20.
 */

public class Zazi_Gradview_Adapter extends BaseAdapter {
    String url[] = {"医生列表", "专家讲座", "直播", "杂志阅读", "课件下载", "模拟考试"};
    Context context;
    List<String> list;

    public Zazi_Gradview_Adapter(Context context, List<String> list) {
        this.context = context;
        this.list=list;
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
            convertView = View.inflate(context, R.layout.item_coureseware_gradview, null);
            indicator.title = (TextView) convertView.findViewById(R.id.title);
            indicator.img = (ImageView) convertView.findViewById(img);
            indicator.domwlod = (TextView) convertView.findViewById(R.id.domwlod);
            indicator.tureload = (ImageView) convertView.findViewById(R.id.tureload);
            indicator.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
            indicator.checkBox.setOnCheckedChangeListener(MagazineW.maninfrag);
            Glide.with(context)
                    .load(Connector.lll + "k")
                    .placeholder(R.mipmap.zazhi)
                    .centerCrop()
                    .into(indicator.img);
            convertView.setTag(indicator);
        } else {
            indicator = (Indicator) convertView.getTag();
        }
        indicator.title.setText(list.get(position));

        return convertView;
    }

    public class Indicator {
        private TextView title;
        private ImageView img;
        private ImageView tureload;
        private CheckBox checkBox;
        private TextView domwlod;
    }
}
