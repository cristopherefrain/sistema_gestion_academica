package com.Application.Services;

import com.Application.Entities.Ciclo;
import com.Application.Exceptions.GlobalException;
import com.Application.Exceptions.NoDataException;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CicloService extends Service {

    private static final String LISTAR_CICLO = "{?=call LISTAR_CICLO()}";
    private List<Ciclo> ciclosList;

    public CicloService() {
        super();
        ciclosList = new ArrayList<>();
        prepareCicloData();
    }

    public List<Ciclo> getCiclosList() {
        return ciclosList;
    }

    private void prepareCicloData() {
        ciclosList.add(new Ciclo("1", "2020", "1", "11/02/20", "11/04/20"));
        ciclosList.add(new Ciclo("2", "2020", "2", "11/06/20", "11/08/20"));
        ciclosList.add(new Ciclo("3", "2020", "3", "11/09/20", "11/12/20"));
    }

    /*Listar ciclos*/
    public Collection listar_ciclo() throws GlobalException, NoDataException {
/*        try {
            Connect();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Ciclo elCiclo = null;
        CallableStatement pstmt = null;
        try {
            pstmt = connection.prepareCall(LISTAR_CICLO);
//            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                elCiclo = new Ciclo(rs.getString("NO_CICLO"),
                        rs.getString("ANIO"),
                        rs.getString("NUMERO"),
                        rs.getString("FECHA_INICIO"),
                        rs.getString("FECHA_FIN"));
                coleccion.add(elCiclo);
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
return ciclosList;
    }
}
