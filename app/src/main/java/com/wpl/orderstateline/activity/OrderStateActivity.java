package com.wpl.orderstateline.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wpl.orderstateline.MainActivity;
import com.wpl.orderstateline.R;
import com.wpl.underline.UnderLineLayout;

/**
 * author : Perry
 * time   : 2017/5/11
 * Q Q    : 917351143
 */

public class OrderStateActivity extends AppCompatActivity {
    private UnderLineLayout underLineLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_state);
        initView();
    }

    private void initView() {
        int currentState = getIntent().getIntExtra("currentState", 0);
        setTitle("订单状态");
        underLineLayout = (UnderLineLayout) findViewById(R.id.underLineLayout);
        addItem(MainActivity.ORDER_STATE[0], MainActivity.ORDER_STATE_INFO[0], MainActivity.ORDER_STATE_TIME[0], currentState == 0, 0);
        for (int i = 0; i < currentState; i++) {
            addItem(MainActivity.ORDER_STATE[i + 1], MainActivity.ORDER_STATE_INFO[i + 1], MainActivity.ORDER_STATE_TIME[i + 1], i + 1 == currentState, i + 1);
        }
    }

    private void addItem(String title, String content, String time, boolean isDisplayContent, int currentState) {
        View v = LayoutInflater.from(this).inflate(R.layout.view_order_state_row, underLineLayout, false);
        TextView titleTv = (TextView) v.findViewById(R.id.orderState_title);
        TextView contentTv = (TextView) v.findViewById(R.id.orderState_content);
        TextView timeTv = (TextView) v.findViewById(R.id.orderState_time);
        RelativeLayout otherRl = (RelativeLayout) v.findViewById(R.id.orderState_other);

        titleTv.setText(title);
        timeTv.setText(time);
        contentTv.setVisibility(isDisplayContent ? View.VISIBLE : View.GONE);
        if (isDisplayContent) {
            contentTv.setText(content);
            titleTv.setTextAppearance(this, R.style.BoldText);
            titleTv.setTextColor(getResources().getColor(R.color.app_color));
            if (currentState >= 3 && currentState <= 5) {
                initOtherView(otherRl);
            }
        }
        underLineLayout.addView(v);
    }

    private void initOtherView(RelativeLayout container) {
        container.setVisibility(View.VISIBLE);
        ImageView iv = new ImageView(this);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.setImageResource(R.mipmap.pic_map);
        container.addView(iv);
    }

}
