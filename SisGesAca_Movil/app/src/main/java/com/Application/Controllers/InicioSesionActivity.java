package com.Application.Controllers;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.Application.Data.ModelDummy;
import com.Application.NavDrawerActivity;
import com.Application.R;

public class InicioSesionActivity extends MainActivity {

    private ModelDummy model;
    private EditText usuario_txtFld, clave_txtFld;
    private Button iniciar_sesion_btn;
    private ProgressBar loadingProgressBar;

    private void inicializarActividad() {
        model = new ModelDummy();
        usuario_txtFld = findViewById(R.id.usuario_txtFld);
        clave_txtFld = findViewById(R.id.clave_pwdFld);
        iniciar_sesion_btn = findViewById(R.id.iniciar_sesion_btn);
        loadingProgressBar = findViewById(R.id.loading);

        getSupportActionBar().setTitle(getString(R.string.title_activity_inicio_sesion));

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkErrors();
            }
        };

        usuario_txtFld.addTextChangedListener(afterTextChangedListener);
        clave_txtFld.addTextChangedListener(afterTextChangedListener);
        clave_txtFld.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                checkErrors();
            }
            return false;
        });

        iniciar_sesion_btn.setOnClickListener(view -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            attemptLogin();
        });
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarActividad();
    }

    public Boolean checkErrors() {
        String usuario = usuario_txtFld.getText().toString();
        String clave = clave_txtFld.getText().toString();

//        Resetar los errores
        usuario_txtFld.setError(null);
        usuario_txtFld.setError(null);

        boolean errorCheck = false;

        if (TextUtils.isEmpty(usuario)) {
            usuario_txtFld.setError(getString(R.string.error_field_required));
            errorCheck = true;
        } else if (!isUserValid(usuario)) {
            usuario_txtFld.setError(getString(R.string.error_invalid_usuario));
            errorCheck = true;
        }

        if (TextUtils.isEmpty(clave)) {
            clave_txtFld.setError(getString(R.string.error_field_required));
            errorCheck = true;
        } else if (!isPasswordValid(clave)) {
            clave_txtFld.setError(getString(R.string.error_invalid_clave));
            errorCheck = true;
        }

        iniciar_sesion_btn.setEnabled(!errorCheck);

        return errorCheck;
    }

    private boolean isUserValid(String usuario) {
        return usuario.length() >= 4;
    }

    private boolean isPasswordValid(String clave) {
        return clave.length() >= 4;
    }

    public void attemptLogin() {
        String usuario = usuario_txtFld.getText().toString();
        String clave = clave_txtFld.getText().toString();
        if (!checkErrors()) {
            iniciarSesion(usuario, clave);
        }
    }

    public void iniciarSesion(String usuario, String clave) {
        if (model.validateCredentials(usuario, clave)) {
            intent = redirectActivityTo(NavDrawerActivity.class);
            startActivity(intent);
            finish();
        } else {
            loadingProgressBar.setVisibility(View.INVISIBLE);
            usuario_txtFld.setError(null);
            clave_txtFld.setError(null);
            usuario_txtFld.setError(getString(R.string.error_incorrect_usuario));
            clave_txtFld.setError(getString(R.string.error_incorrect_clave));
        }
    }
}
