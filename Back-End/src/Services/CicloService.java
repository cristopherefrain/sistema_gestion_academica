package Services;

import Entities.Ciclo;
import Exceptions.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author wizard
 */
public final class CicloService extends Service {

    private static final String LISTAR_CICLO = "{?=call LISTAR_CICLO()}";

    public CicloService() {
        super();
    }

    /*Listar ciclos*/
    public Collection listar_ciclo() throws GlobalException, NoDataException {
        try {
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
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
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
        return coleccion;
    }
}
