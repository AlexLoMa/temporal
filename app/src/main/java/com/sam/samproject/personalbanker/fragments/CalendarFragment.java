package com.sam.samproject.personalbanker.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CalendarView;

import com.sam.samproject.R;
import com.sam.samproject.adapters.TimeSlotAdapter;
import com.sam.samproject.base.BaseFragment;

import java.util.ArrayList;

public class CalendarFragment extends BaseFragment {
    @Override
    protected int layoutResource() {
        return R.layout.fragment_calendar;
    }


    @Override
    protected void initViews(View view) {
        super.initViews(view);
        CalendarView pb_calendar = view.findViewById(R.id.pb_calendar);
        RecyclerView recyclerView = view.findViewById(R.id.rlMeeting);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        TimeSlotAdapter timeSlotAdapter = new TimeSlotAdapter();
        timeSlotAdapter.setTimes(getTimeSlots());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(timeSlotAdapter);
    }

    private ArrayList<String> getTimeSlots(){
        ArrayList<String> times = new ArrayList<>();
        times.add("6am - 7am");
        times.add("7am - 8am");
        times.add("8am - 9am");
        times.add("9am - 10am");
        times.add("10am - 11am");
        times.add("11am - 12pm");
        times.add("12pm - 1pm");
        times.add("1pm - 2pm");
        times.add("2pm - 3pm");
        times.add("3pm - 4pm");
        times.add("4pm - 5pm");
        times.add("5pm - 6pm");
        times.add("6pm - 7pm");
        times.add("7pm - 8pm");
        times.add("8pm - 9pm");
        times.add("9pm - 10pm");
        return times;
    }

}
