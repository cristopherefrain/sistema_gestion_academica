package Services;

import Entities.Alumno;
import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Profesor;
import Entities.Usuario;
import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author wizard
 */
public final class UtilitiesSQL {


    /*Alumno*/
    private static final String INSERTAR_ALUMNO = "{call INSERTAR_ALUMNO(?,?,?,?,?,?)}";
    private static final String MODIFICAR_ALUMNO = "{call MODIFICAR_ALUMNO(?,?,?,?,?,?)}";
    private static final String BUSCAR_ALUMNO = "{?=call BUSCAR_ALUMNO(?)}";
    private static final String LISTAR_ALUMNO = "{?=call LISTAR_ALUMNO()}";
    private static final String ELIMINAR_ALUMNO = "{call ELIMINAR_ALUMNO(?)}";

    private static Alumno newAlumno(ResultSet rs) throws SQLException {
        return new Alumno(rs.getString("CEDULA_ALUMNO"), rs.getString("NOMBRE"), rs.getString("TELEFONO"), rs.getString("EMAIL"), rs.getString("FECHA_NACIMIENTO"), rs.getString("CARRERA"));
    }

    private static CallableStatement searchAlumno(Connection connection, String id) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(BUSCAR_ALUMNO);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.setString(2, id);
        return cstmt;
    }

    private static CallableStatement listAlumno(Connection connection) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(LISTAR_ALUMNO);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        return cstmt;
    }

    private static CallableStatement insertAlumno(Connection connection, Alumno alumno) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(INSERTAR_ALUMNO);
        cstmt.setString(1, alumno.getCedula_alumno());
        cstmt.setString(2, alumno.getNombre());
        cstmt.setString(3, alumno.getTelefono());
        cstmt.setString(4, alumno.getEmail());
        cstmt.setDate(5, java.sql.Date.valueOf(alumno.getFecha_nacimiento()));
        cstmt.setString(6, alumno.getCarrera());
        return cstmt;
    }

    private static PreparedStatement updateAlumno(Connection connection, Alumno alumno) throws SQLException {
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(MODIFICAR_ALUMNO);
        pstmt.setString(1, alumno.getCedula_alumno());
        pstmt.setString(2, alumno.getNombre());
        pstmt.setString(3, alumno.getTelefono());
        pstmt.setString(4, alumno.getEmail());
        pstmt.setDate(5, java.sql.Date.valueOf(alumno.getFecha_nacimiento()));
        pstmt.setString(6, alumno.getCarrera());
        return pstmt;
    }

    private static PreparedStatement deleteAlumno(Connection connection, String id) throws SQLException {
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(ELIMINAR_ALUMNO);
        pstmt.setString(1, id);
        return pstmt;
    }

    /*Carrera*/
    private static final String INSERTAR_CARRERA = "{call INSERTAR_CARRERA(?,?,?)}";
    private static final String MODIFICAR_CARRERA = "{call MODIFICAR_CARRERA(?,?,?)}";
    private static final String BUSCAR_CARRERA = "{?=call BUSCAR_CARRERA(?)}";
    private static final String LISTAR_CARRERA = "{?=call LISTAR_CARRERA()}";
    private static final String ELIMINAR_CARRERA = "{call ELIMINAR_CARRERA(?)}";

    private static Carrera newCarrera(ResultSet rs) throws SQLException {
        return new Carrera(rs.getString("CODIGO_CARRERA"), rs.getString("NOMBRE"), rs.getString("TITULO"));
    }

    private static CallableStatement searchCarrera(Connection connection, String id) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(BUSCAR_CARRERA);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.setString(2, id);
        return cstmt;
    }

    private static CallableStatement listCarrera(Connection connection) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(LISTAR_CARRERA);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        return cstmt;
    }

    private static CallableStatement insertCarrera(Connection connection, Carrera carrera) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(INSERTAR_CARRERA);
        cstmt.setString(1, carrera.getCodigo_carrera());
        cstmt.setString(2, carrera.getNombre());
        cstmt.setString(3, carrera.getTitulo());
        return cstmt;
    }

    private static PreparedStatement updateCarrera(Connection connection, Carrera carrera) throws SQLException {
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(MODIFICAR_CARRERA);
        pstmt.setString(1, carrera.getCodigo_carrera());
        pstmt.setString(2, carrera.getNombre());
        pstmt.setString(3, carrera.getTitulo());
        return pstmt;
    }

    private static PreparedStatement deleteCarrera(Connection connection, String id) throws SQLException {
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(ELIMINAR_CARRERA);
        pstmt.setString(1, id);
        return pstmt;
    }

    /*Ciclo*/
    private static final String LISTAR_CICLO = "{?=call LISTAR_CICLO()}";

    private static Ciclo newCiclo(ResultSet rs) throws SQLException {
        return new Ciclo(rs.getString("NO_CICLO"), rs.getString("ANIO"), rs.getString("NUMERO"), rs.getString("FECHA_INICIO"), rs.getString("FECHA_FIN"));
    }

    private static CallableStatement listCiclo(Connection connection) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(LISTAR_CICLO);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        return cstmt;
    }

    /*Curso*/
    private static final String INSERTAR_CURSO = "{call INSERTAR_CURSO(?,?,?,?,?,?)}";
    private static final String MODIFICAR_CURSO = "{call MODIFICAR_CURSO(?,?,?,?,?,?)}";
    private static final String BUSCAR_CURSO = "{?=call BUSCAR_CURSO(?)}";
    private static final String LISTAR_CURSO = "{?=call LISTAR_CURSO()}";
    private static final String ELIMINAR_CURSO = "{call ELIMINAR_CURSO(?)}";

    private static Curso newCurso(ResultSet rs) throws SQLException {
        return new Curso(rs.getString("CODIGO_CURSO"), rs.getString("CODIGO_CARRERA"), rs.getString("NO_CICLO"), rs.getString("NOMBRE"), rs.getString("CREDITOS"), rs.getString("HORAS_SEMANALES"));
    }

    private static CallableStatement searchCurso(Connection connection, String id) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(BUSCAR_CURSO);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.setString(2, id);
        return cstmt;
    }

    private static CallableStatement listCurso(Connection connection) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(LISTAR_CURSO);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        return cstmt;
    }

    private static CallableStatement insertCurso(Connection connection, Curso curso) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(INSERTAR_CURSO);
        cstmt.setString(1, curso.getCodigo_curso());
        cstmt.setString(2, curso.getCodigo_carrera());
        cstmt.setString(3, curso.getNo_ciclo());
        cstmt.setString(4, curso.getNombre());
        cstmt.setString(5, curso.getCreditos());
        cstmt.setString(6, curso.getHoras_semanales());
        return cstmt;
    }

    private static PreparedStatement updateCurso(Connection connection, Curso curso) throws SQLException {
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(MODIFICAR_CURSO);
        pstmt.setString(1, curso.getCodigo_curso());
        pstmt.setString(2, curso.getCodigo_carrera());
        pstmt.setString(3, curso.getNo_ciclo());
        pstmt.setString(4, curso.getNombre());
        pstmt.setString(5, curso.getCreditos());
        pstmt.setString(6, curso.getHoras_semanales());
        return pstmt;
    }

    private static PreparedStatement deleteCurso(Connection connection, String id) throws SQLException {
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(ELIMINAR_CURSO);
        pstmt.setString(1, id);
        return pstmt;
    }

    /*InicioSesion*/
    public static Boolean validateCredentials(final String cedula, final String clave) {
        ArrayList<Usuario> lista_usuarios = new ArrayList();
        lista_usuarios.add(new Usuario("system", "root", "SYS-DBA"));
        ArrayList<Usuario> filtrado = new ArrayList(lista_usuarios.stream().filter(user -> user.getCedula().equals(cedula) && user.getClave().equals(clave)).collect(Collectors.toList()));
        return !filtrado.isEmpty();
    }

    /*Profesor*/
    private static final String INSERTAR_PROFESOR = "{call INSERTAR_PROFESOR(?,?,?,?)}";
    private static final String MODIFICAR_PROFESOR = "{call MODIFICAR_PROFESOR(?,?,?,?)}";
    private static final String BUSCAR_PROFESOR = "{?=call BUSCAR_PROFESOR(?)}";
    private static final String LISTAR_PROFESOR = "{?=call LISTAR_PROFESOR()}";
    private static final String ELIMINAR_PROFESOR = "{call ELIMINAR_PROFESOR(?)}";

    public static Profesor newProfesor(ResultSet rs) throws SQLException {
        return new Profesor(rs.getString("CEDULA_PROFESOR"), rs.getString("NOMBRE"), rs.getString("TELEFONO"), rs.getString("EMAIL"));
    }

    private static CallableStatement searchProfesor(Connection connection, String id) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(BUSCAR_PROFESOR);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.setString(2, id);
        return cstmt;
    }

    private static CallableStatement listProfesor(Connection connection) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(LISTAR_PROFESOR);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        return cstmt;
    }

    private static CallableStatement insertProfesor(Connection connection, Profesor profesor) throws SQLException {
        CallableStatement cstmt;
        cstmt = connection.prepareCall(INSERTAR_PROFESOR);
        cstmt.setString(1, profesor.getCedula_profesor());
        cstmt.setString(2, profesor.getNombre());
        cstmt.setString(3, profesor.getTelefono());
        cstmt.setString(4, profesor.getEmail());
        return cstmt;
    }

    private static PreparedStatement updateProfesor(Connection connection, Profesor profesor) throws SQLException {
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(MODIFICAR_PROFESOR);
        pstmt.setString(1, profesor.getCedula_profesor());
        pstmt.setString(2, profesor.getNombre());
        pstmt.setString(3, profesor.getTelefono());
        pstmt.setString(4, profesor.getEmail());
        return pstmt;
    }

    private static PreparedStatement deleteProfesor(Connection connection, String id) throws SQLException {
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(ELIMINAR_PROFESOR);
        pstmt.setString(1, id);
        return pstmt;
    }
//=======================

    public static Object newObject(Class<?> entityClass, ResultSet rs) throws SQLException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                return newAlumno(rs);
            case "Carrera":
                return newCarrera(rs);
            case "Ciclo":
                return newCiclo(rs);
            case "Curso":
                return newCurso(rs);
            case "Profesor":
                return newProfesor(rs);
            default:
                return null;
        }
    }

    public static CallableStatement crtCallableStmnt(Connection con, String operation, Class<?> entityClass, Object obj) throws SQLException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                return operation.equals("SEARCH") ? searchAlumno(con, (String) obj)
                        : operation.equals("LIST") ? listAlumno(con)
                        : operation.equals("INSERT") ? insertAlumno(con, (Alumno) obj) : null;
            case "Carrera":
                return operation.equals("SEARCH") ? searchCarrera(con, (String) obj)
                        : operation.equals("LIST") ? listCarrera(con)
                        : operation.equals("INSERT") ? insertCarrera(con, (Carrera) obj) : null;
            case "Ciclo":
                return operation.equals("LIST") ? listCiclo(con) : null;
            case "Curso":
                return operation.equals("SEARCH") ? searchCurso(con, (String) obj)
                        : operation.equals("LIST") ? listCurso(con)
                        : operation.equals("INSERT") ? insertCurso(con, (Curso) obj) : null;
            case "Profesor":
                return operation.equals("SEARCH") ? searchProfesor(con, (String) obj)
                        : operation.equals("LIST") ? listProfesor(con)
                        : operation.equals("INSERT") ? insertProfesor(con, (Profesor) obj) : null;
            default:
                return null;
        }
    }

    public static PreparedStatement crtPreparedStmnt(Connection con, String operation, Class<?> entityClass, Object obj) throws SQLException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                return operation.equals("UPDATE") ? updateAlumno(con, (Alumno) obj)
                        : operation.equals("DELETE") ? deleteAlumno(con, (String) obj) : null;
            case "Carrera":
                return operation.equals("UPDATE") ? updateCarrera(con, (Carrera) obj)
                        : operation.equals("DELETE") ? deleteCarrera(con, (String) obj) : null;
            case "Ciclo":
                return operation.equals("LIST") ? listCiclo(con) : null;
            case "Curso":
                return operation.equals("UPDATE") ? updateCurso(con, (Curso) obj)
                        : operation.equals("DELETE") ? deleteCurso(con, (String) obj) : null;
            case "Profesor":
                return operation.equals("UPDATE") ? updateProfesor(con, (Profesor) obj)
                        : operation.equals("DELETE") ? deleteProfesor(con, (String) obj) : null;
            default:
                return null;
        }
    }

    public static Statement createStatement(Connection con, String operation, Class<?> entityClass, Object obj) throws SQLException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                return operation.equals("SEARCH") ? (Statement) searchAlumno(con, (String) obj)
                        : operation.equals("LIST") ? (Statement) listAlumno(con)
                        : operation.equals("INSERT") ? (Statement) insertAlumno(con, (Alumno) obj)
                        : operation.equals("UPDATE") ? (Statement) updateAlumno(con, (Alumno) obj)
                        : operation.equals("DELETE") ? (Statement) deleteAlumno(con, (String) obj) : null;
            case "Carrera":
                return operation.equals("SEARCH") ? (Statement) searchCarrera(con, (String) obj)
                        : operation.equals("LIST") ? (Statement) listCarrera(con)
                        : operation.equals("INSERT") ? (Statement) insertCarrera(con, (Carrera) obj)
                        : operation.equals("UPDATE") ? (Statement) updateCarrera(con, (Carrera) obj)
                        : operation.equals("DELETE") ? (Statement) deleteCarrera(con, (String) obj) : null;
            case "Ciclo":
                return operation.equals("LIST") ? (Statement) listCiclo(con) : null;
            case "Curso":
                return operation.equals("SEARCH") ? (Statement) searchCurso(con, (String) obj)
                        : operation.equals("LIST") ? (Statement) listCurso(con)
                        : operation.equals("INSERT") ? (Statement) insertCurso(con, (Curso) obj)
                        : operation.equals("UPDATE") ? (Statement) updateCurso(con, (Curso) obj)
                        : operation.equals("DELETE") ? (Statement) deleteCurso(con, (String) obj) : null;
            case "Profesor":
                return operation.equals("SEARCH") ? (Statement) searchProfesor(con, (String) obj)
                        : operation.equals("LIST") ? (Statement) listProfesor(con)
                        : operation.equals("INSERT") ? (Statement) insertProfesor(con, (Profesor) obj)
                        : operation.equals("UPDATE") ? (Statement) updateProfesor(con, (Profesor) obj)
                        : operation.equals("DELETE") ? (Statement) deleteProfesor(con, (String) obj) : null;
            default:
                return null;
        }
    }

}
