package com.compassecg.test720.compassecg.LoginActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.compassecg.test720.compassecg.R;
import com.compassecg.test720.compassecg.unitl.BarBaseActivity;
import com.test720.auxiliary.Utils.L;
import com.test720.auxiliary.Utils.RegularUtil;

public class BinDingActivity extends BarBaseActivity {

    EditText phone;
    EditText pass;

    ImageView clear;
    TextView clear1;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin_ding);
        setTitleString("绑定手机");
        phone = getView(R.id.phone);
        pass = getView(R.id.pass);
        clear = getView(R.id.clear);
        clear1 = getView(R.id.clear1);
        clear.setOnClickListener(this);
        clear1.setOnClickListener(this);
        getView(R.id.ok).setOnClickListener(this);
        // 如果用户名改变，清空密码
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                L.e("phone",phone.getText().length()+"");
                if (phone.getText().length() == 0) {
                    clear.setVisibility(View.GONE);
                } else {
                    clear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.clear:
                phone.setText("");
                clear.setVisibility(View.GONE);
                break;

            case R.id.clear1:
                String phonel=phone.getText().toString();
                L.e("phonel",phonel);
                if (!RegularUtil.isPhone(phonel)) {
                    phone.setError("请正确输入手机号");
                    return;
                }
                clear1.setText("已发送");
                break;

            case R.id.ok:
                String phone2=phone.getText().toString();
                L.e("phone2",phone2);
                if (!RegularUtil.isPhone(phone2)) {
                    phone.setError("请正确输入手机号");
                    return;
                }
                if (pass.getText().length() == 0) {
                    pass.setError("请输入验证码");
                }
                break;
        }
    }
}
