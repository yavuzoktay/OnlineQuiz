package com.yavuzoktay.onlinequizz.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yavuzoktay.onlinequizz.Interface.ItemClickListener;
import com.yavuzoktay.onlinequizz.R;

/**
 * Created by Yavuz on 1.10.2017.
 */

public class RankingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txt_name , txt_score ;

    private ItemClickListener itemClickListener ;



    public RankingViewHolder(View itemView) {
        super(itemView);
        txt_name= itemView.findViewById(R.id.txt_name);
        txt_score=itemView.findViewById(R.id.txt_score);

        itemView.setOnClickListener(this);
    }


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
