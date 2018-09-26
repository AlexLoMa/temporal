package com.sam.samproject.personalbanker.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sam.samproject.R;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

public class AccountOpenFragment extends Fragment {
    private Bitmap bitmap;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey("sign")) {
            byte[] byteArray = getArguments().getByteArray("sign");
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_form, container, false);
        if (bitmap != null)
            ((ImageView) view.findViewById(R.id.imgSign)).setImageBitmap(bitmap);

        view.findViewById(R.id.relSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PersonalBankerActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.activity_root, new SignatureFragment()).commit();
            }
        });
        return view;
    }

}
