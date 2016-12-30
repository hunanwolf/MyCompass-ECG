package com.compassecg.test720.compassecg.Home.AcitvityW.my;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.compassecg.test720.compassecg.R;
import com.test720.auxiliary.Utils.NoBarBaseActivity;
import com.test720.auxiliary.Utils.RegularUtil;
import com.test720.auxiliary.Utils.T;


public class PassChangeActivityW extends NoBarBaseActivity {


    RelativeLayout back;

    EditText pass;

    EditText passNew;

    EditText passNewCon;
    RelativeLayout baotun;
    TextView btntext;
    int SATAT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_change);
        initView();
    }


    public void initView() {

        pass = getView(R.id.pass);
        passNew = getView(R.id.pass_new);
        passNewCon = getView(R.id.pass_new_con);
        baotun = getView(R.id.baotun);
        btntext=getView(R.id.btntext);
        baotun.setOnClickListener(this);
        back = getView(R.id.back);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.baotun:
//                getDatae();
                ShowToast("保存");
                break;
        }
    }

    //修改密码
    public void getDatae() {


        String skil = pass.getText().toString();
        String ski_new = passNew.getText().toString();
        String skil_con = passNewCon.getText().toString();

        if (passNew.getText().length() < 6) {
            passNew.setError("请输入6位数密码");
            ShowToast("请输入6位数密码");
            return;
        }
        if (passNewCon.getText().length() < 6) {
            passNewCon.setError("请输入6位数密码");
            ShowToast("请输入6位数密码");
            return;
        }

        if (!passNew.getText().toString().equals(passNewCon.getText().toString())) {
            ShowToast("两次密码不一致！");
            return;
        }
        if (RegularUtil.isHaveChinese(passNew.getText().toString())) {
            Toast.makeText(this, "不能输入中文！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!skil.equals("") && !ski_new.equals("") && !skil_con.equals("")) {
            if (ski_new.equals(skil_con)) {
//                RequestParams params = new RequestParams();
//                params.put("uid", APP.uuid);
//                params.put("pwd", skil);
//                params.put("password", skil_con);
//                Post(Connector.password, params, SATAT);

            } else {
                passNewCon.setError("请重新输入密码");
            }
        } else {
            T.showShort(getApplicationContext(), "请填写您的信息");
        }
    }

    @Override
    public void Getsuccess(JSONObject jsonObject, int what) {
        super.Getsuccess(jsonObject, what);
        int msg = jsonObject.getIntValue("msg");
        if (msg == 1) {
            T.showShort(this, "修改成功");
            finish();
        } else if (msg == 0) {
            T.showShort(this, "修改失败");
        } else
            T.showLong(this, "原密码错误！请重新设置");
    }
}
