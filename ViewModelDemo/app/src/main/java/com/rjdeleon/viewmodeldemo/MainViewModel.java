package com.rjdeleon.viewmodeldemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    private static final Float USD_TO_EU_RATE = 0.74F;

    private Float value = 0F;
    private Float result = 0F;

    public void setAmount(Float value) {
        this.value = value;
        result = value * USD_TO_EU_RATE;
    }

    public Float getResult()
    {
        return result;
    }
}
