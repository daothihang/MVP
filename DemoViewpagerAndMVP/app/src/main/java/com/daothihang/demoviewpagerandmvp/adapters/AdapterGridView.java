package com.daothihang.demoviewpagerandmvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daothihang.demoviewpagerandmvp.R;
import com.daothihang.demoviewpagerandmvp.models.Users;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterGridView extends BaseAdapter {
    private List<Users> usersList;
    private int itemLayout;
    private Context context;

    public AdapterGridView(Context context, List<Users> usersList, int itemLayout) {
        this.usersList = usersList;
        this.context = context;
        this.itemLayout = itemLayout;
    }

    @Override
    public int getCount() {
        return usersList.size();
    }

    @Override
    public Object getItem(int position) {
        return usersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class viewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.img_avatar_url)
        ImageView imageUrl;
    }

    ;

    @Override
    public View getView(int position, View viewRow, ViewGroup parent) {

        ButterKnife.bind(this, viewRow);

        if (viewRow == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater != null) {
                viewRow = inflater.inflate(itemLayout, parent, false);
            }
            viewHolder holder = new viewHolder();
            if (viewRow != null) {
                holder.tvName = viewRow.findViewById(R.id.tv_name);
            }
            if (viewRow != null) {
                holder.imageUrl = viewRow.findViewById(R.id.img_avatar_url);
            }
            if (viewRow != null) {
                viewRow.setTag(holder);
            }
        }
        final Users users = usersList.get(position);
        viewHolder holder = null;
        if (viewRow != null) {
            holder = (viewHolder) viewRow.getTag();
        }
        if (holder != null) {
            holder.tvName.setText(users.getName());
        }
        if (holder != null) {
            Glide.with(viewRow).load(users.getImage()).into(holder.imageUrl);
        }
        return viewRow;
    }
}
