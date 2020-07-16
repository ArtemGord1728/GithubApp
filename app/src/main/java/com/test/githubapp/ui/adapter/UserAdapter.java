package com.test.githubapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.test.githubapp.base.BaseAdapter;
import com.test.githubapp.data.User;
import com.test.githubapp.ui.activity.user.UserInfoActivity;
import com.test.githubapp.util.AppConstants;
import com.test.githubapp.view.UserViewHolder;

import java.util.List;

public class UserAdapter
        extends BaseAdapter<User, UserViewHolder>
{

    public UserAdapter(int resId) {
        super(resId);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final Context context = holder.itemView.getContext();
        final User userItem = items.get(position);

        Glide.with(context)
                .load(userItem.getAvatarUrl())
                .into(holder.circleImageAvatar);

        holder.textViewLogin.setText(userItem.getLogin());

        holder.relativeLayout.setOnClickListener(v -> {
            Intent userActivity = new Intent(context, UserInfoActivity.class);
            userActivity.putExtra(AppConstants.EXTRA_USER, userItem);
            context.startActivity(userActivity);
        });
    }

    @Override
    protected UserViewHolder newVhInstance(View view) {
        return new UserViewHolder(view);
    }

    public void addItems(List<User> users) {
        final int start = items.size();
        items.addAll(users);
        notifyItemRangeChanged(start, items.size());
    }
}
