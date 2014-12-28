package com.steerableasyncloader.support;

import android.os.Bundle;
import android.support.v4.content.Loader;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by tony on 2014/12/28.
 */
/*package*/ class SimSteerableLoaderManager extends SteerableLoaderManager{

    @Override
    public void loadDataInManual(int id, Bundle args) {

    }

    @Override
    public SteerableAsyncLoaderParams getSteerableAsyncLoaderParams() {
        return null;
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

    }
}
