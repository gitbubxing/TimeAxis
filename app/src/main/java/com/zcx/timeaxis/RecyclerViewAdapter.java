package com.zcx.timeaxis;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private List<TimeState> timeStateList;
    //构造方法
    public RecyclerViewAdapter(Context context ,List timeStateList){
           this.timeStateList= timeStateList;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ViewHolder  holderV= (ViewHolder) holder;
        if (position==0){
            holderV.getState().setTextColor(Color.RED);
            holderV.getContent().setTextColor(Color.RED);
        }else {
            holderV.getState().setTextColor(Color.GRAY);
            holderV.getContent().setTextColor(Color.GRAY);
        }
        TimeState  state= timeStateList.get(position);
        holderV.getContent().setText(state.getContent());
        holderV.getState().setText(state.getState());

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_timeaxis,null));
    }

    @Override
    public int getItemCount() {
        return timeStateList.size();
    }
    class ViewHolder extends  RecyclerView.ViewHolder{
     private    TextView  content,state;

        public ViewHolder(View itemView) {
            super(itemView);
            content= (TextView) itemView.findViewById(R.id.content);
            state= (TextView) itemView.findViewById(R.id.state);
        }


        public TextView getContent() {
            return content;
        }

        public TextView getState() {
            return state;
        }

    }
}
