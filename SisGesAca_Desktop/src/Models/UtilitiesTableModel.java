package Models;

import Entities.Alumno;
import Entities.Carrera;
import Entities.Curso;
import Entities.Profesor;

/**
 *
 * @author wizard
 */
public class UtilitiesTableModel {

    //  Alumno
    private static final int ALUMNO_CEDULA = 0;
    private static final int ALUMNO_NOMBRE = 1;
    private static final int ALUMNO_TELEFONO = 2;
    private static final int ALUMNO_EMAIL = 3;
    private static final int ALUMNO_FECHA_NACIMIENTO = 4;
    private static final int ALUMNO_CARRERA = 5;

    //  Carrera
    private static final int CARRERA_CODIGO = 0;
    private static final int CARRERA_NOMBRE = 1;
    private static final int CARRERA_TITULO = 2;

    //  Curso
    private static final int CURSO_CODIGO = 0;
    private static final int CURSO_CODIGO_CARRERA = 1;
    private static final int CURSO_NO_CICLO = 2;
    private static final int CURSO_NOMBRE = 3;
    private static final int CURSO_CREDITOS = 4;
    private static final int CURSO_HORAS_SEMANALES = 5;

    //  Profesor
    private static final int PROFESOR_CEDULA = 0;
    private static final int PROFESOR_NOMBRE = 1;
    private static final int PROFESOR_TELEFONO = 2;
    private static final int PROFESOR_EMAIL = 3;

    public static String[] initColNames(Class<?> objectType) {
        String[] colNames = null;
        switch (objectType.getSimpleName()) {
            case "Alumno":
                colNames = new String[6];
                colNames[ALUMNO_CEDULA] = "Cedula Alumno";
                colNames[ALUMNO_NOMBRE] = "Nombre";
                colNames[ALUMNO_TELEFONO] = "Telefono";
                colNames[ALUMNO_EMAIL] = "Email";
                colNames[ALUMNO_FECHA_NACIMIENTO] = "Fecha Nacimiento";
                colNames[ALUMNO_CARRERA] = "Carrera";
                break;
            case "Carrera":
                colNames = new String[3];
                colNames[CARRERA_CODIGO] = "Codigo Carrera";
                colNames[CARRERA_NOMBRE] = "Nombre";
                colNames[CARRERA_TITULO] = "Titulo";
                break;
            case "Curso":
                colNames = new String[6];
                colNames[CURSO_CODIGO] = "Codigo Curso";
                colNames[CURSO_CODIGO_CARRERA] = "Codigo Carrera";
                colNames[CURSO_NO_CICLO] = "Numero Ciclo";
                colNames[CURSO_NOMBRE] = "Nombre";
                colNames[CURSO_CREDITOS] = "Creditos";
                colNames[CURSO_HORAS_SEMANALES] = "Horas Semanales";
                break;
            case "Profesor":
                colNames = new String[4];
                colNames[PROFESOR_CEDULA] = "Cedula Profesor";
                colNames[PROFESOR_NOMBRE] = "Nombre";
                colNames[PROFESOR_TELEFONO] = "Telefono";
                colNames[PROFESOR_EMAIL] = "Email";
            default:
                break;
        }
        return colNames;
    }

    public static Object getValueAtCol(Class<?> objectType, int col, Object objeto) {
        switch (objectType.getSimpleName()) {
            case "Alumno":
                Alumno alumno = (Alumno) objeto;
                switch (col) {
                    case ALUMNO_CEDULA:
                        return alumno.getCedula_alumno();
                    case ALUMNO_NOMBRE:
                        return alumno.getNombre();
                    case ALUMNO_TELEFONO:
                        return alumno.getTelefono();
                    case ALUMNO_EMAIL:
                        return alumno.getEmail();
                    case ALUMNO_FECHA_NACIMIENTO:
                        return alumno.getFecha_nacimiento();
                    case ALUMNO_CARRERA:
                        return alumno.getCarrera();
                    default:
                        return "";
                }
            case "Carrera":
                Carrera carrera = (Carrera) objeto;
                switch (col) {
                    case CARRERA_CODIGO:
                        return carrera.getCodigo_carrera();
                    case CARRERA_NOMBRE:
                        return carrera.getNombre();
                    case CARRERA_TITULO:
                        return carrera.getTitulo();
                    default:
                        return "";
                }
            case "Curso":
                Curso curso = (Curso) objeto;
                switch (col) {
                    case CURSO_CODIGO:
                        return curso.getCodigo_curso();
                    case CURSO_CODIGO_CARRERA:
                        return curso.getCodigo_carrera();
                    case CURSO_NO_CICLO:
                        return curso.getNo_ciclo();
                    case CURSO_NOMBRE:
                        return curso.getNombre();
                    case CURSO_CREDITOS:
                        return curso.getCreditos();
                    case CURSO_HORAS_SEMANALES:
                        return curso.getHoras_semanales();
                    default:
                        return "";
                }
            case "Profesor":
                Profesor profesor = (Profesor) objeto;
                switch (col) {
                    case PROFESOR_CEDULA:
                        return profesor.getCedula_profesor();
                    case PROFESOR_NOMBRE:
                        return profesor.getNombre();
                    case PROFESOR_TELEFONO:
                        return profesor.getTelefono();
                    case PROFESOR_EMAIL:
                        return profesor.getEmail();
                    default:
                        return "";
                }
            default:
                return "";
        }
    }

    public static int[] getCols(Class<?> objectType) {
        switch (objectType.getSimpleName()) {
            case "Alumno":
                int[] colsAlumno = {ALUMNO_CEDULA, ALUMNO_NOMBRE, ALUMNO_TELEFONO, ALUMNO_EMAIL, ALUMNO_FECHA_NACIMIENTO, ALUMNO_CARRERA};
                return colsAlumno;
            case "Carrera":
                int[] colsCarrera = {CARRERA_CODIGO, CARRERA_NOMBRE, CARRERA_TITULO};
                return colsCarrera;
            case "Curso":
                int[] colsCurso = {CURSO_CODIGO, CURSO_CODIGO_CARRERA, CURSO_NO_CICLO, CURSO_NOMBRE, CURSO_CREDITOS, CURSO_HORAS_SEMANALES};
                return colsCurso;
            case "Profesor":
                int[] colsProfesor = {PROFESOR_CEDULA, PROFESOR_NOMBRE, PROFESOR_TELEFONO, PROFESOR_EMAIL};
                return colsProfesor;
            default:
                return null;
        }
    }
}
