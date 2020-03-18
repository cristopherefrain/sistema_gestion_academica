package com.Application.Services;

import com.Application.Entities.Profesor;
import com.Application.Exceptions.GlobalException;
import com.Application.Exceptions.NoDataException;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProfesorService extends Service {

    private static final String INSERTAR_PROFESOR = "{call INSERTAR_PROFESOR(?,?,?,?)}";
    private static final String MODIFICAR_PROFESOR = "{call MODIFICAR_PROFESOR(?,?,?,?)}";
    private static final String BUSCAR_PROFESOR = "{?=call BUSCAR_PROFESOR(?)}";
    private static final String LISTAR_PROFESOR = "{?=call LISTAR_PROFESOR()}";
    private static final String ELIMINAR_PROFESOR = "{call ELIMINAR_PROFESOR(?)}";
    private List<Profesor> profesoresList;

    public ProfesorService() {
        super();
        profesoresList = new ArrayList<>();
        prepareProfesorData();
    }

    public List<Profesor> getProfesoresList() {
        return profesoresList;
    }

    private void prepareProfesorData() {
        profesoresList.add(new Profesor("111111111", "EL Doctor", "11111111", "correo1@email.com"));
        profesoresList.add(new Profesor("222222222", "El Tigre", "22222222", "correo2@email.com"));
        profesoresList.add(new Profesor("333333333", "Cama Dios", "33333333", "correo3@email.com"));
        profesoresList.add(new Profesor("444444444", "Pepe Figuerez", "44444444", "correo4@email.com"));
        profesoresList.add(new Profesor("555555555", "Apu", "55555555", "correo5@email.com"));
    }

    /*Insertar profesores*/
    public void insertar_profesor(Profesor profesor) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = connection.prepareCall(INSERTAR_PROFESOR);
            pstmt.setString(1, profesor.getCedula_profesor());
            pstmt.setString(2, profesor.getNombre());
            pstmt.setString(3, profesor.getTelefono());
            pstmt.setString(4, profesor.getEmail());
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
    public void modificar_profesor(Profesor profesor) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(MODIFICAR_PROFESOR);
            pstmt.setString(1, profesor.getCedula_profesor());
            pstmt.setString(2, profesor.getNombre());
            pstmt.setString(3, profesor.getTelefono());
            pstmt.setString(4, profesor.getEmail());
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
    public Profesor buscar_profesor(String id) throws GlobalException, NoDataException {

        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Profesor profesor = null;
        CallableStatement pstmt = null;
        try {
            pstmt = connection.prepareCall(BUSCAR_PROFESOR);
//            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, id);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                profesor = new Profesor(rs.getString("CEDULA_PROFESOR"),
                        rs.getString("NOMBRE"),
                        rs.getString("TELEFONO"),
                        rs.getString("EMAIL"));
                coleccion.add(profesor);
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
        return profesor;
    }

    /*Listar profesores*/
    public Collection listar_profesor() throws GlobalException, NoDataException {
/*        try {
            Connect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Profesor profesor = null;
        CallableStatement pstmt = null;
        try {
            pstmt = connection.prepareCall(LISTAR_PROFESOR);
//            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                profesor = new Profesor(rs.getString("CEDULA_PROFESOR"),
                        rs.getString("NOMBRE"),
                        rs.getString("TELEFONO"),
                        rs.getString("EMAIL"));
                coleccion.add(profesor);
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
        return coleccion;*/
return profesoresList;
    }

    /*Eliminar profesores*/
    public void eliminar_profesor(String id) throws GlobalException, NoDataException {
        try {
            Connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(ELIMINAR_PROFESOR);
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