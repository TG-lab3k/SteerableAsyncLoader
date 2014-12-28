package com.steerableasyncloader.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by tony on 2014/12/27.
 */
public class SteerableAsyncLoaderActivity extends Activity{
    private SteerableAsyncLoaderActivityDelegate steerableAsyncLoaderActivityDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(null == steerableAsyncLoaderActivityDelegate){
            steerableAsyncLoaderActivityDelegate = new SteerableAsyncLoaderActivityDelegate(this);
        }
        steerableAsyncLoaderActivityDelegate.onCreate();
    }

    @Override
    @TargetApi(21)
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if(null == steerableAsyncLoaderActivityDelegate){
            steerableAsyncLoaderActivityDelegate = new SteerableAsyncLoaderActivityDelegate(this);
        }
        steerableAsyncLoaderActivityDelegate.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        steerableAsyncLoaderActivityDelegate.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        steerableAsyncLoaderActivityDelegate.onDestroy();
    }
    
    public SteerableLoaderManager getSteerableLoaderManager(){
        return steerableAsyncLoaderActivityDelegate.getSteerableLoaderManager();
    }
}
