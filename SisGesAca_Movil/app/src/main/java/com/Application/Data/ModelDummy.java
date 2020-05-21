package com.Application.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Entities.Alumno;
import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Profesor;
import Entities.Usuario;

public class ModelDummy {
    private List<Alumno> alumnosList;
    private List<Carrera> carrerasList;
    private List<Ciclo> ciclosList;
    private List<Curso> cursosList;
    private static List<Usuario> usuariosList;
    private List<Profesor> profesoresList;
    private static ModelDummy uniqueInstance;

    private ModelDummy() {
        prepareAlumnoData();
        prepareCarreraData();
        prepareCicloData();
        prepareCursoData();
        prepareUsuarioData();
        prepareProfesorData();
    }

    public static ModelDummy getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ModelDummy();
        }
        return uniqueInstance;
    }

    private void prepareAlumnoData() {
        alumnosList = new ArrayList<>();
    }

    private void prepareCarreraData() {
        carrerasList = new ArrayList<>();
    }

    private void prepareCicloData() {
        ciclosList = new ArrayList<>();
    }

    private void prepareCursoData() {
        cursosList = new ArrayList<>();
    }

    private void prepareUsuarioData() {
        usuariosList = new ArrayList<>();
        usuariosList.add(new Usuario("system", "root", "SYS-DBA"));
    }

    private void prepareProfesorData() {
        profesoresList = new ArrayList<>();
    }

    public Boolean validateCredentials(final String cedula, final String clave) {
        ArrayList<Usuario> filtrado = new ArrayList(usuariosList.stream()
                .filter(user -> user.getCedula().equals(cedula) && user.getClave().equals(clave))
                .collect(Collectors.toList()));
        return !filtrado.isEmpty();
    }

    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public List<Carrera> getCarrerasList() {
        return carrerasList;
    }

    public void setCarrerasList(List<Carrera> carrerasList) {
        this.carrerasList = carrerasList;
    }

    public List<Ciclo> getCiclosList() {
        return ciclosList;
    }

    public void setCiclosList(List<Ciclo> ciclosList) {
        this.ciclosList = ciclosList;
    }

    public List<Curso> getCursosList() {
        return cursosList;
    }

    public void setCursosList(List<Curso> cursosList) {
        this.cursosList = cursosList;
    }

    public static List<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public static void setUsuariosList(List<Usuario> usuariosList) {
        ModelDummy.usuariosList = usuariosList;
    }

    public List<Profesor> getProfesoresList() {
        return profesoresList;
    }

    public void setProfesoresList(List<Profesor> profesoresList) {
        this.profesoresList = profesoresList;
    }
}
