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

import Entities.Curso;

import static com.Application.Data.ConstantesGlobales.MODO_AGREGAR;
import static com.Application.Data.ConstantesGlobales.MODO_EDITAR;

public class CursoActivity extends MainActivity {

    private FloatingActionButton fab;
    private boolean editable;
    private EditText codigo_curso_txtFld, codigo_carrera_txtFld, no_ciclo_txtFld, nombre_txtFld, creditos_txtFld, horas_semanales_txtFld;
    private CoordinatorLayout coordinatorLayout;

    private void inicializarActividad() {
        fab = findViewById(R.id.fab);
        editable = false;
        codigo_curso_txtFld = findViewById(R.id.codigo_curso_txtFld);
        codigo_carrera_txtFld = findViewById(R.id.codigo_carrera_txtFld);
        no_ciclo_txtFld = findViewById(R.id.no_ciclo_txtFld);
        nombre_txtFld = findViewById(R.id.nombre_txtFld);
        creditos_txtFld = findViewById(R.id.creditos_txtFld);
        horas_semanales_txtFld = findViewById(R.id.horas_semanales_txtFld);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        whiteNotificationBar(coordinatorLayout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicializarActividad();
        resetTextFields();
        checkDataFromPrincipal();
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
        codigo_curso_txtFld.setText("");
        codigo_carrera_txtFld.setText("");
        no_ciclo_txtFld.setText("");
        nombre_txtFld.setText("");
        creditos_txtFld.setText("");
        horas_semanales_txtFld.setText("");
    }

    public void checkDataFromPrincipal() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            editable = extras.getBoolean("editable");
            if (editable) {
                setTextFields((Curso) getIntent().getSerializableExtra("curso"));
            }
            fab.setOnClickListener(view -> actionMode(editable ? MODO_EDITAR : MODO_AGREGAR));
        }
    }

    private void setTextFields(Curso obj) {
        codigo_curso_txtFld.setText(obj.getCodigo_curso());
        codigo_curso_txtFld.setEnabled(!editable);
        codigo_carrera_txtFld.setText(obj.getCodigo_carrera());
        no_ciclo_txtFld.setText(obj.getNo_ciclo());
        nombre_txtFld.setText(obj.getNombre());
        creditos_txtFld.setText(obj.getCreditos());
        horas_semanales_txtFld.setText(obj.getHoras_semanales());
    }

    public void actionMode(int mode) {
        if (!checkErrors()) {
            Curso obj = new Curso(codigo_curso_txtFld.getText().toString(), codigo_carrera_txtFld.getText().toString(), no_ciclo_txtFld.getText().toString(), nombre_txtFld.getText().toString(), creditos_txtFld.getText().toString(), horas_semanales_txtFld.getText().toString());
            intent = redirectActivityTo(PrincipalCursosActivity.class);
            intent.putExtra((mode == MODO_AGREGAR) ? "addCurso" : (mode == MODO_EDITAR) ? "editCurso" : "default", obj);
            finish();
            startActivity(intent);
        }
    }

    public Boolean checkErrors() {
        String codigo_curso = codigo_curso_txtFld.getText().toString();
        String codigo_carrera = codigo_carrera_txtFld.getText().toString();
        String no_ciclo = no_ciclo_txtFld.getText().toString();
        String nombre = nombre_txtFld.getText().toString();
        String creditos = creditos_txtFld.getText().toString();
        String horas_semanales = horas_semanales_txtFld.getText().toString();
//        Resetar los errores
        codigo_curso_txtFld.setError(null);
        codigo_carrera_txtFld.setError(null);
        no_ciclo_txtFld.setError(null);
        nombre_txtFld.setError(null);
        creditos_txtFld.setError(null);
        horas_semanales_txtFld.setError(null);

        boolean errorCheck = false;

        if (TextUtils.isEmpty(codigo_curso)) {
            codigo_curso_txtFld.setError(getString(R.string.empty_curso_codigo_curso));
            errorCheck = true;
        }
        if (TextUtils.isEmpty(codigo_carrera)) {
            codigo_carrera_txtFld.setError(getString(R.string.empty_curso_codigo_carrera));
            errorCheck = true;
        }
        if (TextUtils.isEmpty(no_ciclo)) {
            no_ciclo_txtFld.setError(getString(R.string.empty_curso_no_ciclo));
            errorCheck = true;
        }
        if (TextUtils.isEmpty(nombre)) {
            nombre_txtFld.setError(getString(R.string.empty_curso_nombre));
            errorCheck = true;
        }
        if (TextUtils.isEmpty(creditos)) {
            creditos_txtFld.setError(getString(R.string.empty_carrera_titulo));
            errorCheck = true;
        }
        if (TextUtils.isEmpty(horas_semanales)) {
            horas_semanales_txtFld.setError(getString(R.string.empty_carrera_titulo));
            errorCheck = true;
        }

        return errorCheck;
    }

}
