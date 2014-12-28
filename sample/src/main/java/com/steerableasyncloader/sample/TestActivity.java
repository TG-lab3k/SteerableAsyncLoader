package com.steerableasyncloader.sample;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by tony on 2014/12/27.
 */
public class TestActivity extends Activity implements LoaderManager.LoaderCallbacks{
    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "@onCreate _____ __ _");
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);

        new android.os.AsyncTask(){
            @Override
            protected Object doInBackground(Object[] params) {
                
                return null;
            }
        }.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "@onDestroy _____ __ _");
        getLoaderManager().destroyLoader(0);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        AsyncTaskLoader loader = new AsyncTaskLoader(getApplicationContext()) {
            @Override
            public Object loadInBackground() {
                Log.d(TAG, "@loadInBackground _____ __ _");
                return null;
            }

            @Override
            protected void onStartLoading() {
                forceLoad();
            }

            @Override
            protected void onReset() {
                super.onReset();
                Log.d(TAG, "@onReset _____ __ _");
            }
        };
        return loader;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        Log.d(TAG, "@onLoadFinished _____ __ _");
    }

    @Override
    public void onLoaderReset(Loader loader) {
        Log.d(TAG, "@onLoaderReset _____ __ _");
    }
}
