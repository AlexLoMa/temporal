package com.sam.samproject.personalbanker.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import com.sam.samproject.R;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

public class CautionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button noButton;
    private Button yesButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cautiondilaog_layout,container,false);
        noButton = view.findViewById(R.id.no_button);
        yesButton = view.findViewById(R.id.yes_button);
        noButton.setOnClickListener(this);
        yesButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        getDialog().getWindow().setGravity(Gravity.CENTER);
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = 1400;
        params.height = 900;
        getDialog().getWindow().setAttributes(params);
        super.onStart();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.no_button:
                getDialog().dismiss();
                break;
            case R.id.yes_button:
                Intent intent = new Intent(getContext(), PersonalBankerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

        }
    }
}
