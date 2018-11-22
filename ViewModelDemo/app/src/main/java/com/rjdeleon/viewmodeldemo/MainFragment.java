package com.rjdeleon.viewmodeldemo;


import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private EditText valueField;
    private TextView convertedValue;
    private Button convertButton;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        valueField = getView().findViewById(R.id.valueField);
        convertedValue = getView().findViewById(R.id.convertedValue);
        convertButton = getView().findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!valueField.getText().toString().isEmpty()) {
                    mViewModel.setAmount(Float.valueOf(
                            valueField.getText().toString()
                    ));
                    convertedValue.setText(mViewModel.getResult().toString());
                } else {
                    convertedValue.setText("No Value");
                }
            }
        });
    }
}
