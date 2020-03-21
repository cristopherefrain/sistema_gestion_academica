package com.Application.Controllers;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.Application.Entities.Carrera;
import com.Application.Helper.RecyclerItemTouchHelper;
import com.Application.Models.CarreraModel;
import com.Application.NavDrawerActivity;
import com.Application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static com.Application.Models.ConstantesGlobales.CORTA_DURACION;
import static com.Application.Models.ConstantesGlobales.LARGA_DURACION;

public class PrincipalCarrerasActivity extends MainActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, CarreraAdapter.CarreraAdapterListener {

    private RecyclerView mRecyclerView;
    private CarreraAdapter mAdapter;
    private List<Carrera> carreraList;
    private CoordinatorLayout coordinatorLayout;
    private SearchView searchView;
    private FloatingActionButton fab;
    private CarreraModel model;

    private void inicializarActividad() {
        mRecyclerView = findViewById(R.id.recycler_carrerasFld);
        carreraList = new ArrayList<>();
        model = new CarreraModel();
        try {
            carreraList = model.listar_carrera();
        } catch (Exception e) {
        }
        mAdapter = new CarreraAdapter(carreraList, this);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        fab = findViewById(R.id.fab);

        whiteNotificationBar(mRecyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        fab.setOnClickListener(view -> goToCarreraActivity());

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
                    for (Carrera carrera : carreraList) {
                        if (carrera.getCodigo_carrera().equals(aux.getCodigo_carrera())) {
                            carrera.setNombre(aux.getNombre());
                            carrera.setTitulo(aux.getTitulo());
                            founded = true;
                            break;
                        }
                    }
                    //check if exist
                    if (founded) {
                        showToast(aux.getNombre() + " editado correctamente!", LARGA_DURACION);
                    } else {
                        showToast(aux.getNombre() + " no encontrado :(", LARGA_DURACION);
                    }
                }
            } else {
                //found a new Carrera Object
                carreraList.add(aux);
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

                // save the index deleted
                final int deletedIndex = viewHolder.getAdapterPosition();
                // remove the item from recyclerView
                mAdapter.removeItem(viewHolder.getAdapterPosition());

                // showing snack bar with Undo option
                Snackbar snackbar = Snackbar.make(coordinatorLayout, name + " removido!", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", view -> {
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

}
