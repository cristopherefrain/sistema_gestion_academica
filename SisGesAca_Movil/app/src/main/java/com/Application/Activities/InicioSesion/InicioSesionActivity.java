package com.Application.Activities.InicioSesion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Application.Activities.MainActivity;
import com.Application.Entities.Usuario;
import com.Application.Models.InicioSesionModel;
import com.Application.NavDrawerActivity;
import com.Application.R;

public class InicioSesionActivity extends MainActivity {

    private InicioSesionModel model;
    private EditText usuario_txtFld, clave_txtFld;
    private Button iniciar_sesion_btn;

    private void inicializarActividad() {
        model = new InicioSesionModel();
        usuario_txtFld = (EditText) findViewById(R.id.usuario_txtFld);
        clave_txtFld = (EditText) findViewById(R.id.clave_pwdFld);
        iniciar_sesion_btn = (Button) findViewById(R.id.iniciar_sesion_btn);

        iniciar_sesion_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        inicializarActividad();
    }

    public void attemptLogin() {
        String usuario = usuario_txtFld.getText().toString();
        String clave = clave_txtFld.getText().toString();

//        Resetar los errores
        usuario_txtFld.setError(null);
        usuario_txtFld.setError(null);

        boolean errorCheck = false;
        View focusView = null;

        if (TextUtils.isEmpty(usuario)) {
            usuario_txtFld.setError(getString(R.string.error_field_required));
            focusView = usuario_txtFld;
            errorCheck = true;
        } else if (!isUserValid(usuario)) {
            usuario_txtFld.setError(getString(R.string.error_invalid_usuario));
            focusView = usuario_txtFld;
            errorCheck = true;
        }

        if (TextUtils.isEmpty(clave)) {
            clave_txtFld.setError(getString(R.string.error_field_required));
            focusView = clave_txtFld;
            errorCheck = true;
        } else if (!isPasswordValid(clave)) {
            clave_txtFld.setError(getString(R.string.error_invalid_clave));
            focusView = clave_txtFld;
            errorCheck = true;
        }

        if (errorCheck) {
            focusView.requestFocus();
        } else {
            iniciarSesion(usuario, clave);
        }

    }

    private boolean isUserValid(String usuario) {
        //TODO: Replace this with your own logic
        return usuario.length() >= 4;
    }

    private boolean isPasswordValid(String clave) {
        //TODO: Replace this with your own logic
        return clave.length() >= 4;
    }

    public void iniciarSesion(String usuario, String clave) {
        if (model.iniciarSesion(new Usuario(usuario, clave, "SYS-DBA"))) {
            finish();
            intent = redirectActivityTo(NavDrawerActivity.class);
            startActivity(intent);
        }
    }
}
