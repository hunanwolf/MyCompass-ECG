package com.compassecg.test720.compassecg.Home.AcitvityW.my;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.compassecg.test720.compassecg.R;
import com.test720.auxiliary.Utils.NoBarBaseActivity;

public class profileActivityW extends NoBarBaseActivity {

    ImageView back;
    TextView xingwe, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_w);
        xingwe = getView(R.id.xingwe);
        xingwe.setText("保存");
        getView(R.id.back).setOnClickListener(this);
        title = getView(R.id.title);
        title.setText("个人简介");
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.back:

                finish();
                break;

            case R.id.xingwe:
                ShowToast("保存");
                break;
        }

    }
}
