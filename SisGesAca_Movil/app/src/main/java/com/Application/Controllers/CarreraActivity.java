package com.Application.Controllers;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.Application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Entities.Carrera;

import static com.Application.Data.ConstantesGlobales.MODO_AGREGAR;
import static com.Application.Data.ConstantesGlobales.MODO_EDITAR;

public class CarreraActivity extends MainActivity {

    private FloatingActionButton fab;
    private boolean editable;
    private EditText codigo_carrera_txtFld, nombre_txtFld, titulo_txtFld;
    private CoordinatorLayout coordinatorLayout;

    private void inicializarActividad() {
        fab = findViewById(R.id.fab);
        editable = false;
        codigo_carrera_txtFld = findViewById(R.id.codigo_carrera_txtFld);
        nombre_txtFld = findViewById(R.id.nombre_txtFld);
        titulo_txtFld = findViewById(R.id.titulo_txtFld);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        whiteNotificationBar(coordinatorLayout);
        resetTextFields();
        checkDataFromPrincipal();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicializarActividad();
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.LTGRAY);
        }
    }

    private void resetTextFields() {
        codigo_carrera_txtFld.setText("");
        nombre_txtFld.setText("");
        titulo_txtFld.setText("");
    }

    public void checkDataFromPrincipal() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            editable = extras.getBoolean("editable");
            if (editable) {
                setTextFields((Carrera) getIntent().getSerializableExtra("carrera"));
            }
            fab.setOnClickListener(view -> actionMode(editable ? MODO_EDITAR : MODO_AGREGAR));
        }
    }

    private void setTextFields(Carrera obj) {
        codigo_carrera_txtFld.setText(obj.getCodigo_carrera());
        codigo_carrera_txtFld.setEnabled(!editable);
        nombre_txtFld.setText(obj.getNombre());
        titulo_txtFld.setText(obj.getTitulo());
    }

    public void actionMode(int mode) {
        if (!checkErrors()) {
            Carrera obj = new Carrera(codigo_carrera_txtFld.getText().toString(), nombre_txtFld.getText().toString(), titulo_txtFld.getText().toString());
            intent = redirectActivityTo(PrincipalCarrerasActivity.class);
            intent.putExtra((mode == MODO_AGREGAR) ? "addCarrera" : (mode == MODO_EDITAR) ? "editCarrera" : "default", obj);
            startActivity(intent);
            finish();
        }
    }

    public Boolean checkErrors() {
        String codigo_carrera = codigo_carrera_txtFld.getText().toString();
        String nombre = nombre_txtFld.getText().toString();
        String titulo = titulo_txtFld.getText().toString();
//        Resetar los errores
        codigo_carrera_txtFld.setError(null);
        nombre_txtFld.setError(null);
        titulo_txtFld.setError(null);

        boolean errorCheck = false;

        if (TextUtils.isEmpty(codigo_carrera)) {
            codigo_carrera_txtFld.setError(getString(R.string.empty_codigo_carrera));
            errorCheck = true;
        }
        if (TextUtils.isEmpty(nombre)) {
            nombre_txtFld.setError(getString(R.string.empty_carrera_nombre));
            errorCheck = true;
        }
        if (TextUtils.isEmpty(titulo)) {
            titulo_txtFld.setError(getString(R.string.empty_carrera_titulo));
            errorCheck = true;
        }

        return errorCheck;
    }

}
