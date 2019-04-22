package com.daothihang.demoviewpagerandmvp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daothihang.demoviewpagerandmvp.R;
import com.daothihang.demoviewpagerandmvp.models.Users;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private List<Users> arrayList;
    private int itemLayout;

    public AdapterRecyclerView(List<Users> arrayList, int itemLayout) {
        this.arrayList = arrayList;
        this.itemLayout = itemLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Users users = arrayList.get(i);
        viewHolder.tv_name.setText(users.getName());
        Glide.with(viewHolder.itemView)
                .load(users.getImage())
                .into(viewHolder.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)TextView tv_name;
        @BindView(R.id.img_avatar_url)ImageView imgAvatar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
