package com.Application.ui.carreras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CarrerasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CarrerasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Seccion de Carreras :v");
    }

    public LiveData<String> getText() {
        return mText;
    }
}