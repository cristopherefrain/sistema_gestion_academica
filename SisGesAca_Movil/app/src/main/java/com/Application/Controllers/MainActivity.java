package com.Application.Controllers;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.Application.Models.ConstantesGlobales.CORTA_DURACION;
import static com.Application.Models.ConstantesGlobales.LARGA_DURACION;

public class MainActivity extends AppCompatActivity {

    public Intent intent;

    public void showToast(String msg, int lenght) {
        switch (lenght) {
            case LARGA_DURACION:
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                break;
            case CORTA_DURACION:
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }

    public Intent redirectActivityTo(Class<?> destinationClass) {
        return new Intent(getApplicationContext(), destinationClass);
    }
}
