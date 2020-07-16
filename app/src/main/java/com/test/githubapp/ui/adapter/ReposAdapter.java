package com.test.githubapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.githubapp.R;
import com.test.githubapp.base.BaseAdapter;
import com.test.githubapp.data.Repo;
import com.test.githubapp.view.RepoViewHolder;

import java.util.List;

public class ReposAdapter
        extends BaseAdapter<Repo, RepoViewHolder>
{
    public ReposAdapter(int resId) {
        super(resId);
    }


    @Override
    protected RepoViewHolder newVhInstance(View view) {
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        final Repo repoItem = items.get(position);

        holder.tv_name_repo.setText(repoItem.getName());
        holder.tv_description_repo.setText(repoItem.getDescription());
        holder.tv_lang_repo.setText(repoItem.getProgrammingLanguage());
    }


    public void addItems(List<Repo> repos) {
        items.addAll(repos);
        notifyDataSetChanged();
    }
}
