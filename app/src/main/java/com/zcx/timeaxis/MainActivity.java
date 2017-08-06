package com.zcx.timeaxis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView timeaxitRecyclerView;
    private RecyclerViewAdapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeaxitRecyclerView= (RecyclerView) findViewById( R.id.timeaxitRecyclerView);
        timeaxitRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<TimeState>timeStateList = new ArrayList<>();
        TimeState state= new TimeState();
        state.setContent("签收人本人签收，感谢使用xx快递");
        state.setState("已签收");
        state.setTime("8月10日");
        state.setDetialTime("10:12:33");

        TimeState state2= new TimeState();
        state2.setContent("配送员已配送，请保持电话通畅");
        state2.setState("到达济南中转站");
        state2.setTime("8月10日");
        state2.setDetialTime("09:00:23");

        TimeState state3= new TimeState();
        state3.setContent("快件到达中转站，准备运往济南中转站");
        state3.setState("到达杭州中转站");
        state3.setTime("8月09日");
        state3.setDetialTime("05:00:40");

        TimeState state4= new TimeState();
        state4.setContent("等待运往浙江杭州中转站");
        state4.setState("已发货");
        state4.setTime("8月08日");
        state4.setDetialTime("21:02:42");

        TimeState state5= new TimeState();
        state5.setContent("等待商家发货");
        state5.setState("已付款");
        state5.setTime("8月08日");
        state5.setDetialTime("20:52:42");

        timeStateList.add(state);
        timeStateList.add(state2);
        timeStateList.add(state3);
        timeStateList.add(state4);
        timeStateList.add(state5);
        adapter= new RecyclerViewAdapter(this,timeStateList);
        timeaxitRecyclerView.addItemDecoration(new TimeAxisItemDecoration(timeStateList));
        timeaxitRecyclerView.setAdapter(adapter);
    }
}
