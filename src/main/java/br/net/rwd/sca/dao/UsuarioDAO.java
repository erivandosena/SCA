/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Usuario;
import br.net.rwd.sca.jpa.JpaUtil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 *
 * @author Erivando
 */
public class UsuarioDAO extends JpaUtil {

    public UsuarioDAO() {
    }

    public int adiciona(Usuario usuario) {
        usuario.setCodigo(obterProximoCodigo("SELECT MAX(usua.codigo) FROM usuario usua"));
        adicionar(usuario);
        return usuario.getCodigo();
    }

    public void atualiza(Usuario usuario) {
        atualizar(usuario);
    }

    public void remove(int codUsuario) {
        remover(Usuario.class, codUsuario);
    }

    public Usuario seleciona(int codUsuario) {
        return (Usuario) getPojo(Usuario.class, codUsuario);
    }

    public List<Usuario> seleciona() {
        return getLista(Usuario.class, "SELECT usua FROM usuario usua ORDER BY usua.nome ASC");
    }

    public Usuario isLoginUsuarioSenha(String login, String senha) throws NoSuchAlgorithmException {
        return (Usuario) getPojo(Usuario.class, "SELECT usua FROM usuario usua WHERE usua.login=?1 AND usua.senha=?2", login, criptografar(senha));
    }

    /**
     * Método que vai criar e retornar o hash da senha.
     *
     * @param senha
     * @return hash
     * @throws NoSuchAlgorithmException
     */
    public String criptografar(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = null; // Cria uma variável de referencia a um objeto MessageDigest
        try {
            md = MessageDigest.getInstance("MD5"); //Instancia usando o algoritmo MD5
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes())); //Cria o hash
        return hash.toString(16);
    }
}
