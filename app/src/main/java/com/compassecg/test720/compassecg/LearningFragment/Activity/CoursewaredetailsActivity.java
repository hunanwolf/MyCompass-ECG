package com.compassecg.test720.compassecg.LearningFragment.Activity;

import android.os.Bundle;
import android.widget.TextView;

import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.unitl.BarBaseActivity;

public class CoursewaredetailsActivity extends BarBaseActivity {
    TextView tv_contt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursewaredetails);
        switch (getIntent().getExtras().getInt("type")) {
            case 1:
                setTitleString("杂志详情");
                break;

            case 2:
                setTitleString("课件详情");
                break;
        }
        tv_contt = getView(R.id.tv_content);
        tv_contt.setText("百度翻译人工翻译\n" +
                "百度翻译手机版下载:\n" +
                "安卓手机 iPhone\n" +
                "fanyi.baidu.com  -\n" +
                "Google 翻译\n" +
                "Google 的免费翻译服务可提供简体中文和另外 100 多种语言之间的互译功能,可让您即时翻译字词、短语和网页内容。\n" +
                "translate.google.cn/  - 百度快照 - 568条评价\n" +
                "在线翻译_有道\n" +
                "\n" +
                "有道翻译提供即时免费的中、英、日、韩、法、俄、西班牙、葡萄牙文全文翻译、网页翻译服务。\n" +
                "fanyi.youdao.com/  - 百度快照 - 664条评价\n" +
                "在线翻译_在线词典_金山词霸_爱词霸英语\n" +
                "\n" +
                "爱词霸英语为广大网友提供在线翻译、在线词典、英语口语、英语学习资料、汉语词典,金山词霸下载等服务,致力于为您提供优质权威的在线英语服务,是5000万英语学习者的...\n" +
                "www.iciba.com/  - 百度快照 - 131条评价\n" +
                "翻译_百度百科\n" +
                "\n" +
                "翻译是在准确、通顺的基础上，把一种语言信息转变成另一种语言信息的行为。翻译是将一种相对陌生的表达方式，转换成相对熟悉的表达方式的过程。其内容有语言、文字、图形、符号...\n" +
                "概念 平台 形式 分类 要求 历史 翻译软件版 更多>>\n" +
                "查看“翻译”全部3个含义>>\n" +
                "baike.baidu.com/  -\n" +
                "翻译_最新招聘信息45930条_百度百聘");
    }
}
