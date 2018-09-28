package com.sam.samproject.base;

/**
 * Created by Alejandro Lopez on 23/09/2018.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends Fragment {
    protected abstract int layoutResource();
    protected  void initViews(View view){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(layoutResource(), container, false);
        initViews(view);
        return view;
    }
}

