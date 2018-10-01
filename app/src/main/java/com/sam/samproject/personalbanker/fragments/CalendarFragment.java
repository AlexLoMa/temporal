package com.sam.samproject.personalbanker.fragments;

import android.view.View;
import android.widget.CalendarView;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseFragment;

public class CalendarFragment extends BaseFragment {
    @Override
    protected int layoutResource() {
        return R.layout.fragment_calendar;
    }


    @Override
    protected void initViews(View view) {
        super.initViews(view);
        CalendarView pb_calendar = view.findViewById(R.id.pb_calendar);
    }
}
