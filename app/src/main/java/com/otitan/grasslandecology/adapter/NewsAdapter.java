package com.otitan.grasslandecology.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.otitan.grasslandecology.R;

import java.util.List;

/**
 * Created by sp on 2019/7/20.
 * 新闻
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mList;

    private MyItemClickListener mItemClickListener;

    public NewsAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_news, viewGroup, false), mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mTv_title;
        private final TextView mTv_read;
        private final TextView mTv_time;
        private final ImageView mIv_news;

        private MyItemClickListener mListener;

        MyViewHolder(@NonNull View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);

            mTv_title = itemView.findViewById(R.id.tv_title);
            mTv_read = itemView.findViewById(R.id.tv_read);
            mTv_time = itemView.findViewById(R.id.tv_time);
            mIv_news = itemView.findViewById(R.id.iv_news);

            this.mListener = myItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
//                mListener.onItemClick(view, getPosition());
                mListener.onItemClick(view, getLayoutPosition());
            }
        }
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setItemClickListener(MyItemClickListener myItemClickListener) {
        this.mItemClickListener = myItemClickListener;
    }
}
