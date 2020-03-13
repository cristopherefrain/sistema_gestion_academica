package com.Application.Services;

import com.Application.Entities.Carrera;
import com.Application.Exceptions.GlobalException;
import com.Application.Exceptions.NoDataException;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarreraService extends Service {

    private static final String INSERTAR_CARRERA = "{call INSERTAR_CARRERA(?,?,?)}";
    private static final String MODIFICAR_CARRERA = "{call MODIFICAR_CARRERA(?,?,?)}";
    private static final String BUSCAR_CARRERA = "{?=call BUSCAR_CARRERA(?)}";
    private static final String LISTAR_CARRERA = "{?=call LISTAR_CARRERA()}";
    private static final String ELIMINAR_CARRERA = "{call ELIMINAR_CARRERA(?)}";
    private List<Carrera> carrerasList;

    public CarreraService() {
        super();
        carrerasList = new ArrayList<>();
        prepareCarreraData();
    }

    public List<Carrera> getCarrerasList() {
        return carrerasList;
    }

    private void prepareCarreraData() {
        carrerasList.add(new Carrera("LIX", "Ingenieria en Sistemas de Informacion", "Informatica"));
        carrerasList.add(new Carrera("FIL", "Filosofia", "Filo"));
        carrerasList.add(new Carrera("ADM", "Administracion de Empresas", "Administracion"));
        carrerasList.add(new Carrera("PPS", "Promocion de la Salud", "Educacion Fisica"));
        carrerasList.add(new Carrera("FIS", "Fisica Teorica aplicada a la teoria de cuerdas", "Fisica"));
    }

    /*Insertar profesores*/
    public void insertar_carrera(Carrera carrera) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = connection.prepareCall(INSERTAR_CARRERA);
            pstmt.setString(1, carrera.getCodigo_carrera());
            pstmt.setString(2, carrera.getNombre());
            pstmt.setString(3, carrera.getTitulo());
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

    /*Modificar profesores*/
    public void modificar_carrera(Carrera carrera) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(MODIFICAR_CARRERA);
            pstmt.setString(1, carrera.getCodigo_carrera());
            pstmt.setString(2, carrera.getNombre());
            pstmt.setString(3, carrera.getTitulo());
            int resultado = pstmt.executeUpdate();

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

    /*Buscar profesores*/
    public Carrera buscar_carrera(String id) throws GlobalException, NoDataException {

        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Carrera carrera = null;
        CallableStatement pstmt = null;
        try {
            pstmt = connection.prepareCall(BUSCAR_CARRERA);
//            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, id);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                carrera = new Carrera(rs.getString("CODIGO_CARRERA"),
                        rs.getString("NOMBRE"),
                        rs.getString("TITULO"));
                coleccion.add(carrera);
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
        return carrera;
    }

    /*Listar profesores*/
    public Collection listar_carrera() throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Carrera carrera = null;
        CallableStatement pstmt = null;
        try {
            pstmt = connection.prepareCall(LISTAR_CARRERA);
//            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                carrera = new Carrera(rs.getString("CODIGO_CARRERA"),
                        rs.getString("NOMBRE"),
                        rs.getString("TITULO"));
                coleccion.add(carrera);
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

    /*Eliminar profesores*/
    public void eliminar_carrera(String id) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(ELIMINAR_CARRERA);
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
