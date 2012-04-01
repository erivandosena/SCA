/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import br.net.rwd.sca.entidades.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erivando
 */
public class UsuarioDAOTest {

    public static Integer codDoUsuario = 0;

    public UsuarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdiciona() throws Exception {
        System.out.println("adiciona");
        Usuario usuario = new Usuario();
        usuario.setNome("Erivando S  R ");
        usuario.setLogin("Erivando");
        usuario.setSenha("1234");
        UsuarioDAO instance = new UsuarioDAO();
        codDoUsuario = instance.adiciona(usuario);
        Usuario result = instance.seleciona(codDoUsuario);
        assertEquals(codDoUsuario, result.getCodigo());
    }

    @Test
    public void testSeleciona() throws Exception {
        System.out.println("seleciona");
        int codUsuario = codDoUsuario;
        UsuarioDAO instance = new UsuarioDAO();
        Integer expResult = codDoUsuario;
        Usuario result = instance.seleciona(codUsuario);
        assertEquals(expResult, result.getCodigo());
    }

    @Test
    public void testSelecionaTodos() throws Exception {
        System.out.println("seleciona todos");
        UsuarioDAO instance = new UsuarioDAO();
        assertTrue(instance.seleciona().size() > 0);
    }

    @Test
    public void testAtualiza() throws Exception {
        System.out.println("atualiza");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario usuario = instance.seleciona(codDoUsuario);
        usuario.setNome("Erivando Ramos");
        usuario.setLogin("ramos");
        usuario.setSenha("2103");
        instance.atualiza(usuario);
        usuario = instance.seleciona(codDoUsuario);
        assertEquals(usuario.getNome(), "Erivando Ramos");
    }

  
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        UsuarioDAO instance = new UsuarioDAO();
            instance.remove(codDoUsuario);
            assertNull(instance.seleciona(codDoUsuario));
    }

}
