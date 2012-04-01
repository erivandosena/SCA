/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Locador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erivando
 */
public class LocadorDAOTest {
    
    public static Integer codDoLocador = 0;
    
    public LocadorDAOTest() {
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
        Locador locador = new Locador();
        locador.setNome("Jose da silva xavier");
        locador.setRg("56525772");
        locador.setCpf("3813883-45");
        locador.setProfissao("carteiro");
        locador.setEstadoCivil("solterio");
        locador.setNacionalidade("brasileiro");
        locador.setEndereco("Rua das rosas");
        locador.setNumEndereco("1209");
        locador.setBairro("Centro");
        locador.setCep("60000-000");
        locador.setCidade("Fortaleza");
        locador.setUf("CE");
        LocadorDAO instance = new LocadorDAO();
        codDoLocador = instance.adiciona(locador);
        Locador result = instance.seleciona(codDoLocador);
        assertEquals(codDoLocador, result.getCodigo());
    }
    
     @Test
    public void testSeleciona() throws Exception {
        System.out.println("seleciona");
        int codLocador = codDoLocador;
        LocadorDAO instance = new LocadorDAO();
        Integer expResult = codDoLocador;
        Locador result = instance.seleciona(codLocador);
        assertEquals(expResult, result.getCodigo());
    }

    @Test
    public void testAtualiza() throws Exception {
        System.out.println("atualiza");
        LocadorDAO instance = new LocadorDAO();
        Locador locador = instance.seleciona(codDoLocador);
        locador.setNome("mari de jesus");
        locador.setRg("56525772");
        locador.setCpf("3813883-45");
        locador.setProfissao("Doméstica");
        locador.setEstadoCivil("solteira");
        locador.setNacionalidade("brasileira");
        locador.setEndereco("Rua das rosas");
        locador.setNumEndereco("1209");
        locador.setBairro("Centro");
        locador.setCep("60000-000");
        locador.setCidade("Fortaleza");
        locador.setUf("CE");
        instance.atualiza(locador);
        Locador result = instance.seleciona(codDoLocador);
        assertEquals("mari de jesus", result.getNome());
    }
    
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        LocadorDAO instance = new LocadorDAO();
            instance.remove(codDoLocador);
assertNull(instance.seleciona(codDoLocador));
    }

}
