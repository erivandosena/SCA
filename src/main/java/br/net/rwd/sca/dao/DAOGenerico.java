/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erivando
 */
public abstract class DAOGenerico {

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection cx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema_sca", "postgres", "postgres");
            return cx;
        } catch (Exception ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public PreparedStatement getStatement(String st) throws SQLException {
        return getConnection().prepareStatement(st);
    }

    public ResultSet executaQuery(String consulta, Object... params) throws SQLException {
        PreparedStatement ps = getStatement(consulta);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeQuery();
    }

    public int executaCommand(String consulta, Object... params) throws SQLException {
        PreparedStatement ps = getStatement(consulta);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        int result = ps.executeUpdate();
        ps.close();
        return result;
    }

    public Integer obtemProximoCod(String nomeTabela, String nomeColuna) throws SQLException {
        ResultSet rs = executaQuery("select MAX(" + nomeColuna + ") from " + nomeTabela);
        rs.next();
        Object result = rs.getObject(1);
        if (result == null) {
            rs.close();
            return 1;
        } else {
            return ((Integer) result) + 1;
        }
    }
}
