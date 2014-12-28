package com.steerableasyncloader.app;

import android.app.LoaderManager;
import android.os.Bundle;
import android.content.Loader;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by tony on 2014/12/28.
 */
/*package*/ class SimSteerableLoaderManager extends SteerableLoaderManager{
    /*package*/ boolean isStarted;
    
    final class LoaderInfo implements Loader.OnLoadCompleteListener{
        final int id;
        Bundle args;
        LoaderManager.LoaderCallbacks<Object> callbacks;
        Loader<Object> loader;
        
        /*package*/ LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks){
            this.id = id;
            this.args = args;
            this.callbacks = callbacks;
        }
        
        /*package*/ void start(){
            if(isStarted){
                return;
            }

            isStarted = true;
            if(null == loader && null != callbacks){
                loader = callbacks.onCreateLoader(id, args);
                loader.registerListener(id, this);
            }
            
            if(null != loader){
                loader.startLoading();
            }
        }
        
        @Override
        public void onLoadComplete(Loader loader, Object data) {
            
        }
    }

    @Override
    public void loadDataInManual(int id, Bundle args) {
        
    }

    @Override
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderCallbacks<D> callback) {
        return null;
    }

    @Override
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderCallbacks<D> callback) {
        return null;
    }

    @Override
    public void destroyLoader(int id) {

    }

    @Override
    public <D> Loader<D> getLoader(int id) {
        return null;
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        //TODO
        //do nothing
    }
    
    /*package*/ void doStart(){
        
    }
    
    /*package*/ void doDestroy(){
        
    }
    
    /*package*/ void doCancel(boolean isForceCancel){
        
    }
}
