package com.test.githubapp.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.githubapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserViewHolder extends RecyclerView.ViewHolder
{
    public CircleImageView circleImageAvatar;
    public TextView textViewLogin;
    public RelativeLayout relativeLayout;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        circleImageAvatar = itemView.findViewById(R.id.search_item_avatar);
        textViewLogin = itemView.findViewById(R.id.search_item_login);
        relativeLayout = itemView.findViewById(R.id.search_item_container);
    }
}
