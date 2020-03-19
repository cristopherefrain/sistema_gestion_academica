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
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Application.Adapters.CursoAdapter;
import com.Application.Entities.Curso;
import com.Application.Helper.RecyclerItemTouchHelper;
import com.Application.Models.CursoModel;
import com.Application.NavDrawerActivity;
import com.Application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static com.Application.Models.ConstantesGlobales.LARGA_DURACION;

public class PrincipalCursosActivity extends MainActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, CursoAdapter.CursoAdapterListener {

    private RecyclerView mRecyclerView;
    private CursoAdapter mAdapter;
    private List<Curso> cursoList;
    private CoordinatorLayout coordinatorLayout;
    private SearchView searchView;
    private FloatingActionButton fab;
    private CursoModel model;

    private void inicializarActividad() {
        mRecyclerView = findViewById(R.id.recycler_cursosFld);
        cursoList = new ArrayList<>();
        model = new CursoModel();
        try {
            cursoList = model.listar_curso();
        } catch (Exception e) {
        }
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

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    private void goToCursoActivity() {
        intent = redirectActivityTo(CursoActivity.class);
        intent.putExtra("editable", false);
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
                    for (Curso curso : cursoList) {
                        if (curso.getCodigo_curso().equals(aux.getCodigo_curso())) {
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
                        showToast(aux.getNombre() + " editado correctamente!", LARGA_DURACION);
                    } else {
                        showToast(aux.getNombre() + " no encontrado :(", LARGA_DURACION);
                    }
                }
            } else {
                //found a new Curso Object
                cursoList.add(aux);
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
                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
            }
        } else {
            //If is editing a row object
            Curso aux = mAdapter.getSwipedItem(viewHolder.getAdapterPosition());
            //send data to Edit Activity
            intent = redirectActivityTo(CursoActivity.class);
            intent.putExtra("editable", true);
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
        Toast.makeText(getApplicationContext(), "Seleccion: " + curso.getCodigo_curso() + ", " + curso.getNombre(), Toast.LENGTH_LONG).show();
    }
}
