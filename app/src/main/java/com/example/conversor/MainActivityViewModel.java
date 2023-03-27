package com.example.conversor;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
private Context context;
private MutableLiveData<String> conversion;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }
    public LiveData<String> getResultado(){
        if(conversion==null){
            this.conversion=new MutableLiveData<>();
        }
        return conversion;
    }
public void Conversion (String dolar,String euro){
try {
    if (dolar.equals("") && !euro.equals("")) {
        Double eu = Double.valueOf(euro);
        conversion.setValue(eu * 1.8 + "");
    }
    if (euro.equals("") && !dolar.equals("")) {
        Double dol = Double.valueOf(dolar);
        conversion.setValue(dol * 0.8 + "");
    }
} catch (Exception e) {
    throw new RuntimeException(e);
}
}
}
