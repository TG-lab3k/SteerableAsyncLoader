package com.steerableasyncloader.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Build;

import com.steerableasyncloader.OperationCanceledException;

/**
 * Created by tony on 2014/12/28.
 */
public abstract class SteerableAsyncTaskLoader<D> extends Loader<D>{
    final class LoadTask extends AsyncTask<Void, Void, D>{
        @Override
        protected D doInBackground(Void... params) {
            try{
                D data = SteerableAsyncTaskLoader.this.onLoadInBackground();
                return data;
            }catch(OperationCanceledException e){
                if(!isCancelled()){
                    throw e;
                }
                return null;
            }
        }

        @Override
        protected void onPostExecute(D d) {
            SteerableAsyncTaskLoader.this.dispatchOnLoadComplete(this, d);
        }

        @Override
        protected void onCancelled(D d) {
            SteerableAsyncTaskLoader.this.dispatchOnCancelled(this, d);
        }
    }

    public SteerableAsyncTaskLoader(Context context) {
        super(context);
    }
    
    /*package*/ void dispatchOnLoadComplete(LoadTask task, D data){
        
    }
    
    /*package*/ void dispatchOnCancelled(LoadTask task, D data){
        
    }

    @TargetApi(16)
    public boolean cancelLoad() {
        boolean isCancel;
        if(16 < Build.VERSION.SDK_INT){
            isCancel = super.cancelLoad();
        }else{
            isCancel = onCancelLoad();
        }
        return isCancel;
    }

    @Override
    protected boolean onCancelLoad() {
        
        return false;
    }

    protected D onLoadInBackground(){
        return loadInBackground();
    }
    
    public abstract D loadInBackground();
}
