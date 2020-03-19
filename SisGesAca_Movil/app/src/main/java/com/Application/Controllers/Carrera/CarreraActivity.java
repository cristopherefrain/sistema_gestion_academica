package com.Application.Controllers.Carrera;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

import com.Application.Controllers.MainActivity;
import com.Application.Entities.Carrera;
import com.Application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.Application.Models.ConstantesGlobales.MODO_AGREGAR;
import static com.Application.Models.ConstantesGlobales.MODO_EDITAR;

public class CarreraActivity extends MainActivity {

    private FloatingActionButton fab;
    private boolean editable;
    private EditText codigo_carrera_txtFld, nombre_txtFld, titulo_txtFld;

    private void inicializarActividad() {
        fab = findViewById(R.id.fab);
        editable = false;
        codigo_carrera_txtFld = findViewById(R.id.codigo_carrera_txtFld);
        nombre_txtFld = findViewById(R.id.nombre_txtFld);
        titulo_txtFld = findViewById(R.id.titulo_txtFld);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicializarActividad();
        resetTextFields();
        checkDataFromPrincipal();
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
            finish();
            startActivity(intent);
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
