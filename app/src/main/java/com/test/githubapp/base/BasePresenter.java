package com.test.githubapp.base;

import android.util.Log;

import androidx.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V>
{
    private V view;
    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();


    public void attachView(V view)
    {
        this.view = view;
    }

    public void detachView()
    {
        view = null;
        compositeDisposable.clear();
    }

    public V getView()
    {
        return view;
    }
}
