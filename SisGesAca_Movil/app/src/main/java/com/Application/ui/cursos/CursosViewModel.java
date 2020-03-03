package com.Application.ui.cursos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CursosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CursosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Seccion de Cursos :v");
    }

    public LiveData<String> getText() {
        return mText;
    }
}