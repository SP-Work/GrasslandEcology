package com.otitan.grasslandecology.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.bean.PicBitmap;
import com.otitan.grasslandecology.util.PicConversionUtil;

import java.util.List;

/**
 * Created by sp on 2019/7/30.
 * 植物查询记录
 */
public class PlantHistoryAdapter extends RecyclerView.Adapter<PlantHistoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<PicBitmap> mList;

    private MyItemClickListener mItemClickListener;

    public PlantHistoryAdapter(Context context, List<PicBitmap> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_plant_history, viewGroup, false), mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.mIv_plant.setImageBitmap(PicConversionUtil.stringToBitmap(mList.get(i).getBitmap()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mIv_plant;

        private MyItemClickListener mListener;

        MyViewHolder(@NonNull View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);

            mIv_plant = itemView.findViewById(R.id.iv_plant);

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
