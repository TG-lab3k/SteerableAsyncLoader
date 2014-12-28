package com.steerableasyncloader;

/**
 * Created by tony on 2014/12/28.
 */
public interface SteerableAsyncLoaderDelegate<M extends SteerableAsyncLoaderManager>{
    
    public void onCreate();
    
    public void onStart();
    
    public void onStop();
    
    public void onDestroy();
    
    public M getSteerableLoaderManager();
}
