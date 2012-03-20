/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Erivando
 */
public class UsuarioDAO extends DAOGenerico {

    public UsuarioDAO() {
    }

    public int adiciona(Usuario usuario) throws SQLException {
        usuario.setCodigo(obtemProximoCod("usuario", "usua_cod"));
        String consulta = "INSERT INTO usuario (usua_cod, usua_nome, usua_login, usua_senha) VALUES (?, ?, ?, ?)";
        executaCommand(consulta,
                usuario.getCodigo(),
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getSenha());

        return usuario.getCodigo();
    }

    public void atualiza(Usuario usuario) throws SQLException {
        String consulta = "UPDATE usuario SET usua_nome=?, usua_login=?, usua_senha=? WHERE usua_cod=?";
        executaCommand(consulta,
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getSenha(),
                usuario.getCodigo());
    }

    public void remove(int codUsuario) throws SQLException {
        executaCommand("DELETE from usuario WHERE usua_cod = ?", codUsuario);
    }

    public Usuario seleciona(int codUsuario) throws SQLException {
        ResultSet rs = executaQuery("SELECT usua_cod, usua_nome, usua_login, usua_senha FROM usuario WHERE usua_cod=?", codUsuario);
        Usuario usuarios = null;
        if (rs.next()) {
            usuarios = populaUsuarios(rs);
        }
        rs.close();

        return usuarios;
    }

    public List<Usuario> selecionaTodos() throws SQLException {
        ResultSet rs = executaQuery("SELECT usua_cod, usua_nome, usua_login, usua_senha FROM usuario");
        List<Usuario> usuarios = new LinkedList<Usuario>();
        while (rs.next()) {
            usuarios.add(populaUsuarios(rs));
        }
        rs.close();

        return usuarios;
    }

    public static Usuario populaUsuarios(ResultSet rs) throws SQLException {

        Usuario usuario = new Usuario();

        usuario.setCodigo(rs.getInt("usua_cod"));
        usuario.setNome(rs.getString("usua_nome"));
        usuario.setLogin(rs.getString("usua_login"));
        usuario.setSenha(rs.getString("usua_senha"));

        return usuario;
    }

    public Usuario isLoginUsuarioSenha(String usuario, String senha) throws SQLException, NoSuchAlgorithmException {
        ResultSet rs = executaQuery("SELECT usua_cod, usua_nome, usua_login, usua_senha FROM usuario WHERE usua_login=? AND usua_senha=?", usuario, criptografar(senha));

        Usuario usuarioLogin = null;
        if (rs.next()) {
            usuarioLogin = populaUsuarios(rs);
        }
        rs.close();

        return usuarioLogin;
    }

    /*
     * Metodo que vai criar e retornar o hash
     */
    public String criptografar(String senha) throws NoSuchAlgorithmException {
        // Cria uma variável de referencia a um objeto MessageDigest
        MessageDigest md = null;
        try {
            //Instancia usando o algoritmo MD5
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
        //Cria o hash
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        return hash.toString(16);
    }
}
