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

    public ModelDummy() {
        prepareAlumnoData();
        prepareCarreraData();
        prepareCicloData();
        prepareCursoData();
        prepareUsuarioData();
        prepareProfesorData();
    }

    private void prepareAlumnoData() {
        alumnosList = new ArrayList<>();
        alumnosList.add(new Alumno("111111111", "Jose Daniel Murillo Mendez", "11111111", "correo1@email.com", "01/01/1985", "Ingenieria en Sistemas de Informacion"));
        alumnosList.add(new Alumno("222222222", "David Alvarez Carranza", "22222222", "correo2@email.com", "02/04/1985", "Ingenieria en Sistemas de Informacion"));
        alumnosList.add(new Alumno("333333333", "Miguel Diaz Gutierrez", "33333333", "correo3@email.com", "03/03/1985", "Ingenieria en Sistemas de Informacion"));
        alumnosList.add(new Alumno("444444444", "Gabriela Gutierrez", "44444444", "correo4@email.com", "04/02/1985", "Ingenieria en Sistemas de Informacion"));
        alumnosList.add(new Alumno("555555555", "Oscar Rios", "55555555", "correo5@email.com", "05/01/1985", "Ingenieria en Sistemas de Informacion"));
    }

    private void prepareCarreraData() {
        carrerasList = new ArrayList<>();
        carrerasList.add(new Carrera("ING", "Ingenieria en Sistemas de Informacion", "Informatica"));
        carrerasList.add(new Carrera("FIL", "Filosofia", "Escuela de Letras"));
        carrerasList.add(new Carrera("ADM", "Administracion de Empresas", "Ciencias Sociales"));
        carrerasList.add(new Carrera("PPS", "Promocion de la Salud", "Educacion Fisica"));
        carrerasList.add(new Carrera("FIS", "Fisica Teorica aplicada a la teoria de cuerdas", "Ciencias Exactas"));
    }

    private void prepareCicloData() {
        ciclosList = new ArrayList<>();
        ciclosList.add(new Ciclo("1", "2020", "1", "11/02/20", "11/04/20"));
        ciclosList.add(new Ciclo("2", "2020", "2", "11/06/20", "11/08/20"));
        ciclosList.add(new Ciclo("3", "2020", "3", "11/09/20", "11/12/20"));
    }

    private void prepareCursoData() {
        cursosList = new ArrayList<>();
        cursosList.add(new Curso("FUN", "ING", "1", "Fundamentos de la Programacion", "4", "6"));
        cursosList.add(new Curso("SEM", "FIL", "2", "Seminario de Platon", "3", "5"));
        cursosList.add(new Curso("CON", "ADM", "3", "Contabilidad I", "2", "4"));
        cursosList.add(new Curso("TEN", "PPS", "1", "Tennis", "2", "4"));
        cursosList.add(new Curso("TER", "FIS", "2", "Termodinamica", "7", "12"));
    }

    private void prepareUsuarioData() {
        usuariosList = new ArrayList<>();
        usuariosList.add(new Usuario("system", "root", "SYS-DBA"));
    }

    private void prepareProfesorData() {
        profesoresList = new ArrayList<>();
        profesoresList.add(new Profesor("111111111", "El Doctor", "11111111", "correo1@email.com"));
        profesoresList.add(new Profesor("222222222", "El Tigre", "22222222", "correo2@email.com"));
        profesoresList.add(new Profesor("333333333", "Cama Dios", "33333333", "correo3@email.com"));
        profesoresList.add(new Profesor("444444444", "Pepe Figuerez", "44444444", "correo4@email.com"));
        profesoresList.add(new Profesor("555555555", "Apu", "55555555", "correo5@email.com"));
    }

    public Boolean validateCredentials(final String cedula, final String clave) {
        ArrayList<Usuario> filtrado = new ArrayList(usuariosList.stream().filter(user -> user.getCedula().equals(cedula) && user.getClave().equals(clave)).collect(Collectors.toList()));
        return !filtrado.isEmpty();
    }

    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public List<Carrera> getCarrerasList() {
        return carrerasList;
    }

    public List<Ciclo> getCiclosList() {
        return ciclosList;
    }

    public List<Curso> getCursosList() {
        return cursosList;
    }

    public static List<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public List<Profesor> getProfesoresList() {
        return profesoresList;
    }
}
