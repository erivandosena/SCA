/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Usuario;
import br.net.rwd.sca.jpa.JpaUtilPattern;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Erivando
 */
public class UsuarioDAO {

    public UsuarioDAO() {
    }

    public int adiciona(Usuario usuario) throws SQLException {
        usuario.setCodigo(JpaUtilPattern.getInstancia().obtemProximoCod("usuario", "codigo"));
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        try {
            em.persist(usuario);
        } finally {
            em.getTransaction().commit();
            em.close();
        }
        return usuario.getCodigo();
    }

    public void atualiza(Usuario usuario) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(int codUsuario) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        try {
            em.remove(em.find(Usuario.class, codUsuario));
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public Usuario seleciona(int codUsuario) {
        return JpaUtilPattern.getInstancia().getEntidade(Usuario.class, codUsuario);
    }
    
    public List<Usuario> seleciona() {
        return JpaUtilPattern.getInstancia().getLista(Usuario.class, "SELECT usua FROM usuario usua ORDER BY usua.nome ASC");
    }

    public Usuario isLoginUsuarioSenha(String login, String senha) throws NoSuchAlgorithmException {
        return JpaUtilPattern.getInstancia().getEntidade(Usuario.class, "SELECT usua FROM usuario usua WHERE usua.login=?1 AND usua.senha=?2", login, criptografar(senha));
    }

    /**
     * Método que vai criar e retornar o hash da senha.
     * @param senha
     * @return String
     * @throws NoSuchAlgorithmException 
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
