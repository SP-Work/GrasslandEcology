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
import com.otitan.grasslandecology.bean.BaikePlant;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sp on 2019/7/22.
 * 植物识别
 */
public class BaikePlantAdapter extends RecyclerView.Adapter<BaikePlantAdapter.MyViewHolder> {

    private Context mContext;
    private List<BaikePlant.Result> mList;

    private MyItemClickListener mItemClickListener;

    public BaikePlantAdapter(Context context, List<BaikePlant.Result> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_plant_result, viewGroup, false), mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Picasso.with(mContext).load(mList.get(i).getBaike_info().getImage_url()).into(myViewHolder.mIv_plant);
        myViewHolder.mTv_name.setText(mList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mIv_plant;
        private final TextView mTv_name;

        private MyItemClickListener mListener;

        MyViewHolder(@NonNull View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);

            mIv_plant = itemView.findViewById(R.id.iv_plant);
            mTv_name = itemView.findViewById(R.id.tv_name);

            this.mListener = myItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(view, getPosition());
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
