package com.nitheesh.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import com.nitheesh.test.Model.Entity;
import com.nitheesh.test.Model.EntityDetails;

/**
 * Created by 08468 on 5/24/2016.
 */
public class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.MyViewHolder> {

    private final Context context;
    private List<EntityDetails> entityDetails;
    private EnityItemClick itemClick;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public NetworkImageView mImageView;
        public TextView title;
        public LinearLayout mView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.listTextView);
            mView = (LinearLayout) view.findViewById(R.id.recyclermain);
            mImageView = (NetworkImageView) view.findViewById(R.id.image);
        }
    }


    public EntityAdapter(List<EntityDetails> entityDetails, Context context) {
        this.entityDetails = entityDetails;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entity_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final EntityDetails entityDetails = this.entityDetails.get(position);
        holder.title.setText(String.valueOf(entityDetails.getEntity().getDescritpion()));

        ImageLoader mImageLoader = CustomImageLoader.getInstance(context)
                .getImageLoader();

        final String url = entityDetails.getEntity().getThumbnail();

        mImageLoader.get(url, ImageLoader.getImageListener(holder.mImageView,
                0, android.R.drawable
                        .ic_dialog_alert));
        holder.mImageView.setImageUrl(url, mImageLoader);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClick != null) {
                    itemClick.onEnityItemClick(entityDetails.getEntity());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return entityDetails.size();
    }

    public void setOnItemClick(EnityItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface EnityItemClick {
        void onEnityItemClick(Entity entity);
    }
}
