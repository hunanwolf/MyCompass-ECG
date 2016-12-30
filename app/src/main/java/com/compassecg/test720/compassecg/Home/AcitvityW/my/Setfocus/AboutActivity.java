package com.compassecg.test720.compassecg.Home.AcitvityW.my.Setfocus;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.compassecg.test720.compassecg.R;
import com.test720.auxiliary.Utils.NoBarBaseActivity;


public class AboutActivity extends NoBarBaseActivity {


    RelativeLayout back;

    ImageView logo;

    TextView version;

    TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_about);
        setview();
    }

    public void setview() {
        getView(R.id.back).setOnClickListener(this);
        logo = getView(R.id.logo);
        version = getView(R.id.version);
        detail = getView(R.id.detail);
        detail.setText("“石油桥”是石油行业专业软件移动服务平台。连接石油行业人员，分享石油行业专业人士的知识、技能和经验，盘活石油专业设备和资源、提高设备和资源的使用率，现主要提供二手租赁、人才招聘、项目发布、专业咨询、私密聊天等平台服务。其目的是以坚持以人为本、体验至上的原则，服务石油大产业，创造新价值！\n" +
                "\n" +
                "1、用户可以享受如下服务：\n" +
                "\n" +
                "（1）二手设备租赁；石油行业从勘探到开发，需要大量的钻采、物探、录井、定向、测井、射孔、压裂、酸化、石油专用管材、仪器仪表、油田化学的设备，而这些设备其中很多使用效率不高。“石油桥”提供该平台，让闲置设备二手租赁或盘活，提高使用效率，发挥更大作用。\n" +
                "\n" +
                "（2）招聘人才；只要您是石油人才，只要您想从事石油行业，或需要更大的职业平台，我们给您提供机会；只要您的企业需要人才，我们就提供合适的需要的人才；“石油桥”还设置了石油行业大学生实习服务功能，专门为实习生提供服务。\n" +
                "\n" +
                "（3）项目发布；石油勘探开发中，特别是钻井过程中的大小项目可通过“石油桥”及时发布，高效对接，提高效率，节约成本。\n" +
                "\n" +
                "（4）石油行业专业咨询；在勘探开发中，特别是钻井过程中，针对时间紧、任务重，需要钻井、泥浆、录井、定向、测井、钻井专业设备等方面的人及时知道救急。通过“石油桥”这个聚集了大量石油专业人才的平台，我们能及时提供周到、全面的服务，尽快解决钻井过程中出现的技术问题、难题和事故。\n" +
                "\n" +
                "（5）私密聊天；通过私密聊天功能，连接石油人。熟悉、信任彼此，达到扩大影响、扩大传播，利于“石油桥”线上对接供需。“石油桥”聊天功能应用最新的保密技术，保护隐私；无后台保留数据，让交流聊天不会外泄，无泄密隐患。\n" +
                "\n" +
                "（6）“石油桥”根据互联网和移动互联网平台规划随时增添的其他服务。");
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
