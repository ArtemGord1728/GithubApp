package com.test.githubapp.http;

import android.content.Context;
import android.widget.Toast;

public interface HttpLoader<T>
{
    void loadResult(T items);
    void handleError(Throwable e);
}
