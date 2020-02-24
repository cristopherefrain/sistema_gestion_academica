/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Moviles
 */
public class Servicio {

    protected static Connection conexion;

    public Servicio() {
        conexion = null;
    }

    protected static void conectar() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LAB_MATRICULA", "LAB_MATRICULA1234");
    }

    protected static void desconectar() throws SQLException {
        if (!conexion.isClosed()) {
            conexion.close();
        }
    }
}
