package com.wpl.orderstateline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wpl.orderstateline.activity.OrderStateActivity;
import com.wpl.orderstateline.adapter.RvAdapter;
import com.wpl.orderstateline.utils.DividerItemDecoration;


/**
 * author : Perry
 * time   : 2017/5/11
 * Q Q    : 917351143
 */

public class MainActivity extends AppCompatActivity {

    public static final String[] ORDER_STATE = {"订单已提交", "支付成功", "商家已接单", "骑手正在赶往商家", "骑手已取货", "正在配送", "已送达", "订单已完成"};
    public static final String[] ORDER_STATE_INFO = {"等待支付", "正在等待商家接单", "正在等待骑手接单", "骑手已到店", "等待配送", "骑手正在路上", "请检查包装是否完整", "谢谢您的使用，期待再次光临"};
    public static final String[] ORDER_STATE_TIME = {"2017-05-11 10:00", "2017-05-11 11:00", "2017-05-11 12:00", "2017-05-11 13:00", "2017-05-11 14:00", "2017-05-11 15:00", "2017-05-11 16:00", "2017-05-11 17:00"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        this.setTitle("请选择当前订单状态");
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RvAdapter adapter = new RvAdapter(this, ORDER_STATE);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, OrderStateActivity.class);
                intent.putExtra("currentState", position);
                startActivity(intent);
            }
        });
    }
}
