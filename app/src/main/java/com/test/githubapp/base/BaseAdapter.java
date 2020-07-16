package com.test.githubapp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH>
{
    protected final List<T> items = new ArrayList<>();
    private int resId;

    public BaseAdapter(int resId)
    {
        this.resId = resId;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(resId, parent, false);
        return newVhInstance(view);
    }

    protected abstract VH newVhInstance(View view);

    @Override
    public int getItemCount() {
        return items.size();
    }
}
