package com.Application.Controllers;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.Application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Entities.Carrera;
import Entities.Curso;

import static com.Application.Data.ConstantesGlobales.MODO_AGREGAR;
import static com.Application.Data.ConstantesGlobales.MODO_EDITAR;
import static com.Application.Data.ConstantesGlobales.apiURL_getCarreras;
import static com.Application.Data.ConstantesGlobales.apiURL_getCiclos;

public class CursoActivity extends MainActivity {

    private FloatingActionButton fab;
    private boolean editable;
    private EditText codigo_curso_txtFld, nombre_txtFld, creditos_txtFld, horas_semanales_txtFld;
    private CoordinatorLayout coordinatorLayout;
    Spinner codigo_carrera_spinner, no_ciclo_spinner;
    private List<String> codigosCarreras;
    private List<String> no_ciclos;

    private void initSpinners() {
        ArrayAdapter<String> vcodCarAdapter = new ArrayAdapter(this, R.layout.item_list_spiner, codigosCarreras.toArray());
        codigo_carrera_spinner.setAdapter(vcodCarAdapter);

        ArrayAdapter<String> vnoCicloAdapter = new ArrayAdapter(this, R.layout.item_list_spiner, no_ciclos.toArray());
        no_ciclo_spinner.setAdapter(vnoCicloAdapter);
    }

    private void inicializarActividad() {
        fab = findViewById(R.id.fab);
        editable = false;
        codigo_curso_txtFld = findViewById(R.id.codigo_curso_txtFld);
        nombre_txtFld = findViewById(R.id.nombre_txtFld);
        creditos_txtFld = findViewById(R.id.creditos_txtFld);
        horas_semanales_txtFld = findViewById(R.id.horas_semanales_txtFld);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        codigo_carrera_spinner = findViewById(R.id.codigo_carrera_spinner);
        no_ciclo_spinner = findViewById(R.id.no_ciclo_spinner);
        codigosCarreras = new ArrayList<>();
        no_ciclos = new ArrayList<>();

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
        initSpinners();
    }

    @Override
    protected void onStart() {
        super.onStart();
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
        nombre_txtFld.setText("");
        creditos_txtFld.setText("");
        horas_semanales_txtFld.setText("");
    }

    public void checkDataFromPrincipal() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            editable = extras.getBoolean("editable");
            codigosCarreras = extras.getStringArrayList("spinnerCarreras");
            no_ciclos = extras.getStringArrayList("spinnerCiclos");
            if (editable) {
                setTextFields((Curso) getIntent().getSerializableExtra("curso"));
            }
            fab.setOnClickListener(view -> actionMode(editable ? MODO_EDITAR : MODO_AGREGAR));
        }
    }

    private void setTextFields(Curso obj) {
        codigo_curso_txtFld.setText(obj.getCodigo_curso());
        codigo_curso_txtFld.setEnabled(!editable);
        nombre_txtFld.setText(obj.getNombre());
        creditos_txtFld.setText(obj.getCreditos());
        horas_semanales_txtFld.setText(obj.getHoras_semanales());

        int vIndexcodCar = 0;
        for (String codigo : codigosCarreras) {
            vIndexcodCar++;
            if (codigo.equals(obj.getCodigo_carrera())) {
                break;
            }
        }
        int vIndexNoCic = 0;
        for (String ciclo : no_ciclos) {
            vIndexNoCic++;
            if (ciclo.equals(obj.getNo_ciclo())) {
                break;
            }
        }
        codigo_carrera_spinner.setSelection(vIndexcodCar);
        no_ciclo_spinner.setSelection(vIndexNoCic);
    }

    public void actionMode(int mode) {
        if (!checkErrors()) {
            Curso obj = new Curso(codigo_curso_txtFld.getText().toString(), (String) codigo_carrera_spinner.getSelectedItem(), (String) no_ciclo_spinner.getSelectedItem(), nombre_txtFld.getText().toString(), creditos_txtFld.getText().toString(), horas_semanales_txtFld.getText().toString());
            intent = redirectActivityTo(PrincipalCursosActivity.class);
            intent.putExtra((mode == MODO_AGREGAR) ? "addCurso" : (mode == MODO_EDITAR) ? "editCurso" : "default", obj);
            startActivity(intent);
            finish();
        }
    }

    public Boolean checkErrors() {
        String codigo_curso = codigo_curso_txtFld.getText().toString();
        String nombre = nombre_txtFld.getText().toString();
        String creditos = creditos_txtFld.getText().toString();
        String horas_semanales = horas_semanales_txtFld.getText().toString();
//        Resetar los errores
        codigo_curso_txtFld.setError(null);
        nombre_txtFld.setError(null);
        creditos_txtFld.setError(null);
        horas_semanales_txtFld.setError(null);

        boolean errorCheck = false;

        if (TextUtils.isEmpty(codigo_curso)) {
            codigo_curso_txtFld.setError(getString(R.string.empty_curso_codigo_curso));
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
