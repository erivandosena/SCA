/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrador
 */
public class ConexaoPostgreSQL {

    private static Connection con = null;

    @SuppressWarnings("CallToThreadDumpStack")
    public static Connection getConnection() {
        if (con == null) {
            try {
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/sistema_sca";
                String usuario = "postgres";
                String senha = "postgres";
                Class.forName(driver);
                con = DriverManager.getConnection(url, usuario, senha);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public static void fechaConexao() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
