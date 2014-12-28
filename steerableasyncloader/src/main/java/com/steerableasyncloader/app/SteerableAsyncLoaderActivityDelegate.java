package com.steerableasyncloader.app;

import android.app.Activity;

import com.steerableasyncloader.SteerableAsyncLoaderDelegate;
import com.steerableasyncloader.SteerableAsyncLoaderManager;
import com.steerableasyncloader.app.SteerableLoaderManager;

/**
 * Created by tony on 2014/12/27.
 */
public class SteerableAsyncLoaderActivityDelegate implements SteerableAsyncLoaderDelegate<SteerableLoaderManager> {
    private Activity activity;
    private SimSteerableLoaderManager steerableLoaderManager;
    
    public SteerableAsyncLoaderActivityDelegate(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onCreate() {
        //do nothing
    }

    @Override
    public void onStart() {
       if(null == steerableLoaderManager){
           return;
       }

       final boolean isAutoLoad = steerableLoaderManager.getSteerableAsyncLoaderParams().isAutoLoad();
       if(isAutoLoad && !steerableLoaderManager.isStarted){
            steerableLoaderManager.doStart();
       }
    }

    @Override
    public void onStop() {
        //do nothing
    }

    @Override
    public void onDestroy() {
        if(null == steerableLoaderManager){
            return;
        }
        
        final SteerableAsyncLoaderManager.SteerableAsyncLoaderParams params = steerableLoaderManager.getSteerableAsyncLoaderParams();
        if(params.isAutoCancel() && !steerableLoaderManager.isStarted){
            steerableLoaderManager.doCancel(params.isForceCancel());
        }
        steerableLoaderManager.doDestroy();
    }
    
    public SteerableLoaderManager getSteerableLoaderManager(){
        if(null != steerableLoaderManager){
            return steerableLoaderManager;
        }
        steerableLoaderManager = new SimSteerableLoaderManager();
        return steerableLoaderManager;
    }
}
