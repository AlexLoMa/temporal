package com.sam.samproject.personalbanker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.utils.Utils;

public class SignatureActivity extends BaseActivity implements View.OnClickListener {

    private Button clearButton;
    private Button doneButton;
    private SignaturePad signaturePad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTitle(Utils.getUserName() + " " + getString(R.string.dashboard));
        setContentView(R.layout.activity_signature);

        signaturePad = (SignaturePad) findViewById(R.id.sign_pad);
        clearButton = (Button) findViewById(R.id.b_clear);
        doneButton = (Button) findViewById(R.id.b_done);

        clearButton.setOnClickListener(this);
        doneButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_done:
                finish();
                break;
            case R.id.b_clear:
                signaturePad.clear();
                break;
        }
    }

}
