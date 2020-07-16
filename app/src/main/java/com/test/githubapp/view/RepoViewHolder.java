package com.test.githubapp.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.githubapp.R;

public class RepoViewHolder extends RecyclerView.ViewHolder
{
    public TextView tv_name_repo;
    public TextView tv_description_repo;
    public TextView tv_lang_repo;

    public RepoViewHolder(@NonNull View itemView) {
        super(itemView);

        tv_name_repo = itemView.findViewById(R.id.repo_item_name);
        tv_description_repo = itemView.findViewById(R.id.repo_item_description);
        tv_lang_repo = itemView.findViewById(R.id.repo_item_lang);
    }
}
