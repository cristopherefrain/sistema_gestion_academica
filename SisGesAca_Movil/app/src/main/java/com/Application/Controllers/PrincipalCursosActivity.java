package com.Application.Controllers;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Application.Adapters.CursoAdapter;
import com.Application.Data.ModelDummy;
import com.Application.Helper.RecyclerItemTouchHelper;
import com.Application.NavDrawerActivity;
import com.Application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import Entities.Curso;

import static com.Application.Data.ConstantesGlobales.CORTA_DURACION;
import static com.Application.Data.ConstantesGlobales.LARGA_DURACION;
import static com.Application.Data.ConstantesGlobales.apiURL_deleteCurso;
import static com.Application.Data.ConstantesGlobales.apiURL_getCarreras;
import static com.Application.Data.ConstantesGlobales.apiURL_getCiclos;
import static com.Application.Data.ConstantesGlobales.apiURL_getCursos;
import static com.Application.Data.ConstantesGlobales.apiURL_postCurso;
import static com.Application.Data.ConstantesGlobales.apiURL_putCurso;

public class PrincipalCursosActivity extends MainActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, CursoAdapter.CursoAdapterListener {

    private RecyclerView mRecyclerView;
    private CursoAdapter mAdapter;
    private List<Curso> cursoList;
    private CoordinatorLayout coordinatorLayout;
    private SearchView searchView;
    private FloatingActionButton fab;
    private ModelDummy model;
    private List<String> codigosCarreras;
    private List<String> no_ciclos;

    private void initCursosList() {
        // create object of MyAsyncTasks class and execute it
        getCursosTasks myAsyncTasks = new getCursosTasks();
        myAsyncTasks.execute();
    }

    private void initSpinners() {
        LoadCodigosCarrerasTasks myAsyncTasks1 = new LoadCodigosCarrerasTasks();
        myAsyncTasks1.execute();
        LoadNumeroCiclosTasks myAsyncTasks2 = new LoadNumeroCiclosTasks();
        myAsyncTasks2.execute();
    }

    private void addCurso(Curso curso) {
        insertCursoTasks myAsyncTasks = new insertCursoTasks();
        myAsyncTasks.execute(curso);
    }

    private void editCurso(Curso curso) {
        updateCursoTasks myAsyncTasks = new updateCursoTasks();
        myAsyncTasks.execute(curso);
    }

    private void deleteCurso(Curso curso) {
        deleteCursoTasks myAsyncTasks = new deleteCursoTasks();
        myAsyncTasks.execute(curso);
    }

    private void inicializarActividad() {
        mRecyclerView = findViewById(R.id.recycler_cursosFld);
        cursoList = new ArrayList<>();
        codigosCarreras = new ArrayList<>();
        no_ciclos = new ArrayList<>();
        model = ModelDummy.getInstance();
        initCursosList();
        initSpinners();

        mAdapter = new CursoAdapter(cursoList, this);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        fab = findViewById(R.id.fab);

        whiteNotificationBar(mRecyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        fab.setOnClickListener(view -> goToCursoActivity());

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);

        checkIntentInformation();

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_curso);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicializarActividad();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.LTGRAY);
        }
    }

    private void goToCursoActivity() {
        intent = redirectActivityTo(CursoActivity.class);
        intent.putExtra("editable", false);
        intent.putStringArrayListExtra("spinnerCarreras", (ArrayList<String>) codigosCarreras);
        intent.putStringArrayListExtra("spinnerCiclos", (ArrayList<String>) no_ciclos);
        startActivity(intent);
    }

    private void checkIntentInformation() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Curso aux;
            aux = (Curso) getIntent().getSerializableExtra("addCurso");
            if (aux == null) {
                aux = (Curso) getIntent().getSerializableExtra("editCurso");
                if (aux != null) {
                    //found an item that can be updated
                    boolean founded = false;
                    for (Curso curso : model.getCursosList()) {
                        if (curso.getCodigo_curso().equals(aux.getCodigo_curso())) {
                            editCurso(curso);
                            curso.setCodigo_carrera(aux.getCodigo_carrera());
                            curso.setNo_ciclo(aux.getNo_ciclo());
                            curso.setNombre(aux.getNombre());
                            curso.setCreditos(aux.getCreditos());
                            curso.setHoras_semanales(aux.getHoras_semanales());
                            founded = true;
                            break;
                        }
                    }
                    //check if exist
                    if (founded) {
                        initCursosList();
                        showToast(aux.getNombre() + " editado correctamente!", LARGA_DURACION);
                    } else {
                        showToast(aux.getNombre() + " no encontrado :(", LARGA_DURACION);
                    }
                }
            } else {
                addCurso(aux);
                //found a new Curso Object
                initCursosList();
                showToast(aux.getNombre() + " agregado correctamente!", LARGA_DURACION);
            }
        }
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (direction == ItemTouchHelper.START) {
            if (viewHolder instanceof CursoAdapter.MyViewHolder) {
                // get the removed item name to display it in snack bar
                String name = cursoList.get(viewHolder.getAdapterPosition()).getNombre();

                Curso aux = cursoList.get(viewHolder.getAdapterPosition());
                deleteCurso(aux);
                // save the index deleted
                final int deletedIndex = viewHolder.getAdapterPosition();
                // remove the item from recyclerView
                mAdapter.removeItem(viewHolder.getAdapterPosition());

                // showing snack bar with Undo option
                Snackbar snackbar = Snackbar.make(coordinatorLayout, name + " removido!", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", view -> {
                    addCurso(aux);
                    // undo is selected, restore the deleted item from adapter
                    mAdapter.restoreItem(deletedIndex);
                });
                snackbar.setActionTextColor(Color.WHITE);
                snackbar.show();
            }
        } else {
            //If is editing a row object
            Curso aux = mAdapter.getSwipedItem(viewHolder.getAdapterPosition());
            //send data to Edit Activity
            intent = redirectActivityTo(CursoActivity.class);
            intent.putExtra("editable", true);
            intent.putStringArrayListExtra("spinnerCarreras", (ArrayList<String>) codigosCarreras);
            intent.putStringArrayListExtra("spinnerCiclos", (ArrayList<String>) no_ciclos);
            intent.putExtra("curso", aux);
            mAdapter.notifyDataSetChanged(); //restart left swipe view
            startActivity(intent);
        }
    }

    @Override
    public void onItemMove(int source, int target) {
        mAdapter.onItemMove(source, target);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds carreraList to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);

        // Associate searchable configuration with the SearchView   !IMPORTANT
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change, every type on input
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                mAdapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() { //TODO it's not working yet
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        Intent a = new Intent(this, NavDrawerActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
        super.onBackPressed();
    }

    @Override
    public void onContactSelected(Curso curso) { //TODO get the select item of recycleView
        showToast("Seleccion: " + curso.getCodigo_curso() + ", " + curso.getNombre(), CORTA_DURACION);
    }


    public class insertCursoTasks extends AsyncTask<Curso, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCursosActivity.this);
            progressDialog.setMessage("Agregando Curso (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Curso... cursos) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_postCurso);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    urlConnection.setDoOutput(true);

                    Bundle extras = getIntent().getExtras();
                    try (OutputStream os = urlConnection.getOutputStream()) {
                        byte[] input = cursos[0].toString().getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int code = urlConnection.getResponseCode();
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        return code + response.toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String response) {
            // dismiss the progress dialog after receiving data from API
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    public class updateCursoTasks extends AsyncTask<Curso, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCursosActivity.this);
            progressDialog.setMessage("Actualizando Carrera (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Curso... cursos) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_putCurso);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    urlConnection.setRequestMethod("PUT");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    urlConnection.setDoOutput(true);

                    try (OutputStream os = urlConnection.getOutputStream()) {
                        byte[] input = cursos[0].toString().getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int code = urlConnection.getResponseCode();
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        return code + response.toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String response) {
            // dismiss the progress dialog after receiving data from API
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    public class deleteCursoTasks extends AsyncTask<Curso, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCursosActivity.this);
            progressDialog.setMessage("Eliminando Carrera (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Curso... cursos) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_deleteCurso + cursos[0].getCodigo_curso());
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("DELETE");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Accept", "application/json");

                    int code = urlConnection.getResponseCode();
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        return code + response.toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String response) {
            // dismiss the progress dialog after receiving data from API
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    public class getCursosTasks extends AsyncTask<String, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCursosActivity.this);
            progressDialog.setMessage("Cargando todos las Cursos (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_getCursos);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        return response.toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String response) {
            // dismiss the progress dialog after receiving data from API
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            try {
                JSONArray arrayList = new JSONArray(response);
                JSONObject object;
                cursoList.clear();
                for (int i = 0; i < arrayList.length(); i++) {
                    object = arrayList.getJSONObject(i);
                    cursoList.add(new Curso(object.getString("codigo_curso"), object.getString("codigo_carrera"), object.getString("no_ciclo"),
                            object.getString("nombre"), object.getString("creditos"), object.getString("horas_semanales")));
                }
                model.setCursosList(new ArrayList<>(cursoList));
                mAdapter.notifyDataSetChanged();
            } catch (JSONException ignored) {
            }
        }
    }

    public class LoadCodigosCarrerasTasks extends AsyncTask<String, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCursosActivity.this);
            progressDialog.setMessage("Cargando todas las Carreras (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_getCarreras);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        return response.toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String response) {
            // dismiss the progress dialog after receiving data from API
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            try {
                JSONArray arrayList = new JSONArray(response);
                JSONObject object;
                for (int i = 0; i < arrayList.length(); i++) {
                    object = arrayList.getJSONObject(i);
                    codigosCarreras.add(object.getString("codigo_carrera"));
                }
            } catch (JSONException ignored) {
            }
        }
    }


    public class LoadNumeroCiclosTasks extends AsyncTask<String, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCursosActivity.this);
            progressDialog.setMessage("Cargando todos los Ciclos (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_getCiclos);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        return response.toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String response) {
            // dismiss the progress dialog after receiving data from API
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            try {
                JSONArray arrayList = new JSONArray(response);
                JSONObject object;
                for (int i = 0; i < arrayList.length(); i++) {
                    object = arrayList.getJSONObject(i);
                    no_ciclos.add(object.getString("no_ciclo"));
                }
            } catch (JSONException ignored) {
            }
        }
    }
}
