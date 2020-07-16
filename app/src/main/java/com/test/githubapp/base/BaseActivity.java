package com.test.githubapp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.test.githubapp.R;

public abstract class BaseActivity
    extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        initViews();
    }

    protected abstract void initViews();
    protected abstract int getLayoutRes();
}
