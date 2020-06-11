package com.Application;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.Application.Controllers.InicioSesionActivity;
import com.Application.Controllers.MainActivity;
import com.Application.Controllers.PrincipalCarrerasActivity;
import com.Application.Controllers.PrincipalCursosActivity;
import com.google.android.material.navigation.NavigationView;

import static com.Application.Data.ConstantesGlobales.CORTA_DURACION;


public class NavDrawerActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        Mostrar Navigation
//        drawer.openDrawer(GravityCompat.START);
//        showToast("Bienvenido a SisGesAca (:", CORTA_DURACION);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            this.moveTaskToBack(true);
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            showToast("Creado por: Cristopher Aguilar Bastos.", CORTA_DURACION);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int item_id = item.getItemId();
        String msj = null;
        Class<?> destinationClass = NavDrawerActivity.class;
        switch (item_id) {
            case R.id.nav_carrera:
                msj = "";
                destinationClass = PrincipalCarrerasActivity.class;
                break;
            case R.id.nav_curso:
                msj = "";
                destinationClass = PrincipalCursosActivity.class;
                break;
            case R.id.nav_profesor:
                break;
            case R.id.nav_alumno:
                break;
            case R.id.nav_cerrar_sesion:
//                msj = "Hasta Luego (:";
                msj = "";
                destinationClass = InicioSesionActivity.class;
                break;
            default:
                break;
        }
        redirectTo(msj, destinationClass);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void redirectTo(String msj, Class<?> destinationClass) {
        if (msj != null && destinationClass != NavDrawerActivity.class) {
            intent = redirectActivityTo(destinationClass);
            startActivity(intent);
            if (!msj.isEmpty()) {
                showToast(msj, CORTA_DURACION);
            }
            if (destinationClass == InicioSesionActivity.class) {
                finish();
            }
        }
    }
}
