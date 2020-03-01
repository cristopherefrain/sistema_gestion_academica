package Services;

import Entities.Alumno;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import oracle.jdbc.internal.OracleTypes;

public class AlumnoService extends Service {

    private static final String INSERTAR_ALUMNO = "{call INSERTAR_ALUMNO(?,?,?,?,?,?)}";
    private static final String MODIFICAR_ALUMNO = "{call MODIFICAR_ALUMNO(?,?,?,?,?,?)}";
    private static final String BUSCAR_ALUMNO = "{?=call BUSCAR_ALUMNO(?)}";
    private static final String LISTAR_ALUMNO = "{?=call LISTAR_ALUMNO()}";
    private static final String ELIMINAR_ALUMNO = "{call ELIMINAR_ALUMNO(?)}";

    public AlumnoService() {
        super();
    }

    /*Insertar Alumnos*/
    public void insertar_alumno(Alumno alumno) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = connection.prepareCall(INSERTAR_ALUMNO);
            pstmt.setString(1, alumno.getCedula_alumno());
            pstmt.setString(2, alumno.getNombre());
            pstmt.setString(3, alumno.getTelefono());
            pstmt.setString(4, alumno.getEmail());
            pstmt.setDate(5, java.sql.Date.valueOf(alumno.getFecha_nacimiento()));
            pstmt.setString(6, alumno.getCarrera());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se realizo la insercion");
            }
            System.out.println("\nInsercion Satisfactoria!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                Disconnect();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    /*Modificar Alumnos*/
    public void modificar_alumno(Alumno alumno) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(MODIFICAR_ALUMNO);
            pstmt.setString(1, alumno.getCedula_alumno());
            pstmt.setString(2, alumno.getNombre());
            pstmt.setString(3, alumno.getTelefono());
            pstmt.setString(4, alumno.getEmail());
            pstmt.setDate(5, java.sql.Date.valueOf(alumno.getFecha_nacimiento()));
            pstmt.setString(6, alumno.getCarrera());
            int resultado = pstmt.executeUpdate();

            //System.out.println(resultado);
            //si es igual a 0 es porque si afecto un registro o mas
            if (resultado == 0) {
                throw new NoDataException("No se realizo la actualización");
            } else {
                System.out.println("\nModificación Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                Disconnect();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    /*Buscar Alumnos*/
    public Alumno buscar_alumno(String id) throws GlobalException, NoDataException {

        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Alumno elAlumno = null;
        CallableStatement pstmt = null;
        try {
            pstmt = connection.prepareCall(BUSCAR_ALUMNO);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, id);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                elAlumno = new Alumno(rs.getString("CEDULA_ALUMNO"),
                        rs.getString("NOMBRE"),
                        rs.getString("TELEFONO"),
                        rs.getString("EMAIL"),
                        rs.getString("FECHA_NACIMIENTO"),
                        rs.getString("CARRERA"));
                coleccion.add(elAlumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();

            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                Disconnect();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
//        if (coleccion == null || coleccion.size() == 0) {
//            throw new NoDataException("No hay datos");
//        }
        return elAlumno;
    }

    /*Listar Alumnos*/
    public Collection listar_alumno() throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Alumno elAlumno = null;
        CallableStatement pstmt = null;
        try {
            pstmt = connection.prepareCall(LISTAR_ALUMNO);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                elAlumno = new Alumno(rs.getString("CEDULA_ALUMNO"),
                        rs.getString("NOMBRE"),
                        rs.getString("TELEFONO"),
                        rs.getString("EMAIL"),
                        rs.getString("FECHA_NACIMIENTO"),
                        rs.getString("CARRERA"));
                coleccion.add(elAlumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();

            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                Disconnect();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
//        if (coleccion == null || coleccion.size() == 0) {
//            throw new NoDataException("No hay datos");
//        }
        return coleccion;
    }

    /*Eliminar Alumnos*/
    public void eliminar_alumno(String id) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(ELIMINAR_ALUMNO);
            pstmt.setString(1, id);

            int resultado = pstmt.executeUpdate();

            if (resultado == 0) {
                throw new NoDataException("No se realizo el borrado");
            } else {
                System.out.println("\nEliminación Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                Disconnect();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }
}
