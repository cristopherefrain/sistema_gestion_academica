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

import com.Application.Adapters.CarreraAdapter;
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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import Entities.Carrera;

import static com.Application.Data.ConstantesGlobales.CORTA_DURACION;
import static com.Application.Data.ConstantesGlobales.LARGA_DURACION;
import static com.Application.Data.ConstantesGlobales.apiURL_deleteCarrera;
import static com.Application.Data.ConstantesGlobales.apiURL_getCarreras;
import static com.Application.Data.ConstantesGlobales.apiURL_postCarrera;
import static com.Application.Data.ConstantesGlobales.apiURL_putCarrera;

public class PrincipalCarrerasActivity extends MainActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, CarreraAdapter.CarreraAdapterListener {

    private RecyclerView mRecyclerView;
    private CarreraAdapter mAdapter;
    private List<Carrera> carreraList;
    private CoordinatorLayout coordinatorLayout;
    private SearchView searchView;
    private FloatingActionButton add, refresh, go_back;
    private ModelDummy model;

    private void initCarrerasList() {
        // create object of MyAsyncTasks class and execute it
        GetCarrerasTasks myAsyncTasks = new GetCarrerasTasks();
        myAsyncTasks.execute();
    }

    private void addCarrera(Carrera carrera) {
        insertCarreraTasks myAsyncTasks = new insertCarreraTasks();
        myAsyncTasks.execute(carrera);
    }

    private void editCarrera(Carrera carrera) {
        updateCarreraTasks myAsyncTasks = new updateCarreraTasks();
        myAsyncTasks.execute(carrera);
    }

    private void deleteCarrera(Carrera carrera) {
        deleteCarreraTasks myAsyncTasks = new deleteCarreraTasks();
        myAsyncTasks.execute(carrera);
    }

    private void inicializarActividad() {
        mRecyclerView = findViewById(R.id.recycler_carrerasFld);
        carreraList = new ArrayList<>();
        model = ModelDummy.getInstance();
        //initCarrerasList();

        mAdapter = new CarreraAdapter(carreraList, this);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        add = findViewById(R.id.add);
        refresh = findViewById(R.id.refresh);
        go_back = findViewById(R.id.go_back);

        whiteNotificationBar(mRecyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        add.setOnClickListener(view -> goToCarreraActivity());
        refresh.setOnClickListener(view -> initCarrerasList());
        go_back.setOnClickListener(view -> {
            intent = redirectActivityTo(NavDrawerActivity.class);
            startActivity(intent);
        });

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);

        checkIntentInformation();

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_carrera);
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

    private void goToCarreraActivity() {
        intent = redirectActivityTo(CarreraActivity.class);
        intent.putExtra("editable", false);
        startActivity(intent);
    }

    private void checkIntentInformation() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Carrera aux;
            aux = (Carrera) getIntent().getSerializableExtra("addCarrera");
            if (aux == null) {
                aux = (Carrera) getIntent().getSerializableExtra("editCarrera");
                if (aux != null) {
                    //found an item that can be updated
                    boolean founded = false;
                    for (Carrera carrera : model.getCarrerasList()) {
                        if (carrera.getCodigo_carrera().equals(aux.getCodigo_carrera())) {
                            editCarrera(carrera);
                            carrera.setNombre(aux.getNombre());
                            carrera.setTitulo(aux.getTitulo());
                            founded = true;
                            break;
                        }
                    }
                    //check if exist
                    if (founded) {
                        initCarrerasList();
                        showToast(aux.getNombre() + " editado correctamente!", LARGA_DURACION);
                    } else {
                        showToast(aux.getNombre() + " no encontrado :(", LARGA_DURACION);
                    }
                }
            } else {
                addCarrera(aux);
                //found a new Carrera Object
                initCarrerasList();
                showToast(aux.getNombre() + " agregado correctamente!", LARGA_DURACION);
            }
        }
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (direction == ItemTouchHelper.START) {
            if (viewHolder instanceof CarreraAdapter.MyViewHolder) {
                // get the removed item name to display it in snack bar
                String name = carreraList.get(viewHolder.getAdapterPosition()).getNombre();

                Carrera aux = carreraList.get(viewHolder.getAdapterPosition());
                deleteCarrera(aux);
                // save the index deleted
                final int deletedIndex = viewHolder.getAdapterPosition();
                // remove the item from recyclerView
                mAdapter.removeItem(viewHolder.getAdapterPosition());
                // showing snack bar with Undo option
                Snackbar snackbar = Snackbar.make(coordinatorLayout, name + " removido!", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", view -> {
                    addCarrera(aux);
                    // undo is selected, restore the deleted item from adapter
                    mAdapter.restoreItem(deletedIndex);
                });
                snackbar.setActionTextColor(Color.WHITE);
                snackbar.show();
            }
        } else {
            //If is editing a row object
            Carrera aux = mAdapter.getSwipedItem(viewHolder.getAdapterPosition());
            //send data to Edit Activity
            intent = redirectActivityTo(CarreraActivity.class);
            intent.putExtra("editable", true);
            intent.putExtra("carrera", aux);
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
    public void onContactSelected(Carrera carrera) { //TODO get the select item of recycleView
        showToast("Seleccion: " + carrera.getCodigo_carrera() + ", " + carrera.getNombre(), CORTA_DURACION);
    }

    public class insertCarreraTasks extends AsyncTask<Carrera, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCarrerasActivity.this);
            progressDialog.setMessage("Agregando Carrera (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Carrera... carreras) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_postCarrera);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    urlConnection.setDoOutput(true);

                    Bundle extras = getIntent().getExtras();
                    try (OutputStream os = urlConnection.getOutputStream()) {
                        byte[] input = carreras[0].toString().getBytes(StandardCharsets.UTF_8);
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

    public class updateCarreraTasks extends AsyncTask<Carrera, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCarrerasActivity.this);
            progressDialog.setMessage("Actualizando Carrera (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Carrera... carreras) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_putCarrera);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    urlConnection.setRequestMethod("PUT");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    urlConnection.setDoOutput(true);

                    try (OutputStream os = urlConnection.getOutputStream()) {
                        byte[] input = carreras[0].toString().getBytes(StandardCharsets.UTF_8);
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

    public class deleteCarreraTasks extends AsyncTask<Carrera, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCarrerasActivity.this);
            progressDialog.setMessage("Eliminando Carrera (:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Carrera... carreras) {
            // implement API in background and store the response in response variable
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiURL_deleteCarrera + carreras[0].getCodigo_carrera());
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

    public class GetCarrerasTasks extends AsyncTask<String, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(PrincipalCarrerasActivity.this);
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
                carreraList.clear();
                for (int i = 0; i < arrayList.length(); i++) {
                    object = arrayList.getJSONObject(i);
                    carreraList.add(new Carrera(object.getString("codigo_carrera"), object.getString("nombre"), object.getString("titulo")));
                }
                model.setCarrerasList(new ArrayList<>(carreraList));
                mAdapter.notifyDataSetChanged();
            } catch (JSONException ignored) {
            }
        }
    }

}
