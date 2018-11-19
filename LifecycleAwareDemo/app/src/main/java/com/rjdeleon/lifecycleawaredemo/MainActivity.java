package com.rjdeleon.lifecycleawaredemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Owner ON_CREATE");

        getLifecycle().addObserver(new MainActivityObserver());
    }
}
