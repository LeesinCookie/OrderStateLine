package com.wpl.orderstateline.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wpl.orderstateline.R;

/**
 * author : Perry
 * time   : 2017/5/11
 * Q Q    : 917351143
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {
    private Context mContext;
    private String[] mData;

    private OnItemClickListener clickListener;

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public RvAdapter(Context context, String[] list) {
        this.mContext = context;
        this.mData = list;
    }

    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RvViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(final RvViewHolder holder, int position) {
        holder.tv.setText(mData[position]);
        if (clickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class RvViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        RvViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.rvTv);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
