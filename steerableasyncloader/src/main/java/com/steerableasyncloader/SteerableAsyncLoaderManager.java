package com.steerableasyncloader;

import android.os.Bundle;

/**
 * Created by tony on 2014/12/28.
 */
public interface SteerableAsyncLoaderManager {
    public SteerableAsyncLoaderParams getSteerableAsyncLoaderParams();
    public void loadDataInManual(int id, Bundle args);
    
    public final class SteerableAsyncLoaderParams {
        private boolean isAutoLoad;
        private boolean isAutoCancel;
        private boolean isForceCancel;

        public SteerableAsyncLoaderParams(){
            isAutoLoad = true;
            isAutoCancel = true;
            isForceCancel = false;
        }

        public boolean isAutoLoad() {
            return isAutoLoad;
        }

        public SteerableAsyncLoaderParams setAutoLoad(boolean isAutoLoad) {
            this.isAutoLoad = isAutoLoad;
            return this;
        }

        public boolean isAutoCancel() {
            return isAutoCancel;
        }

        public SteerableAsyncLoaderParams setAutoCancel(boolean isAutoCancel) {
            this.isAutoCancel = isAutoCancel;
            return this;
        }

        public boolean isForceCancel() {
            return isForceCancel;
        }

        public SteerableAsyncLoaderParams setForceCancel(boolean isForceCancel) {
            this.isForceCancel = isForceCancel;
            return this;
        }
    }
}
