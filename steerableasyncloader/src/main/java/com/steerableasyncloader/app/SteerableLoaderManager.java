package com.steerableasyncloader.app;

import android.app.LoaderManager;
import com.steerableasyncloader.SteerableAsyncLoaderManager;

/**
 * Created by tony on 2014/12/28.
 */
public abstract class SteerableLoaderManager extends LoaderManager implements SteerableAsyncLoaderManager{
    private final SteerableAsyncLoaderParams config = new SteerableAsyncLoaderParams();
    
    @Override
    public SteerableAsyncLoaderParams getSteerableAsyncLoaderParams() {
        return config;
    }
}
