/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.session;

import br.net.rwd.sca.ejb.SessionBeanBasico;
import br.net.rwd.sca.entidades.Usuario;

/**
 *
 * @author Administrador
 */

public class UsuarioSession extends SessionBeanBasico {

    public Usuario getPorCodigo(int usuarioCod) {
        return getPojo(Usuario.class, usuarioCod);
    }
    
    
}
