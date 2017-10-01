package com.yavuzoktay.onlinequizz.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yavuzoktay.onlinequizz.Interface.ItemClickListener;
import com.yavuzoktay.onlinequizz.R;

/**
 * Created by Yavuz on 30.9.2017.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView category_name;
    public ImageView category_image ;

    private ItemClickListener itemClickListener ;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        category_image = itemView.findViewById(R.id.category_image);
        category_name=itemView.findViewById(R.id.category_name);

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
