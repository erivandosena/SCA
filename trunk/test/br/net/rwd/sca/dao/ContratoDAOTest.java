/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import br.net.rwd.sca.entidades.Locatario;
import java.sql.Date;
import java.util.Calendar;
import br.net.rwd.sca.entidades.Locador;
import br.net.rwd.sca.entidades.Contrato;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erivando
 */
public class ContratoDAOTest {
    
    public static Integer codDoContrato = 0;
    public static Integer codDoLocador = 0;
    public static Integer codDoLocatario = 0;
    
    public ContratoDAOTest() {
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
        LocadorDAO instanceLocador = new LocadorDAO();
        codDoLocador = instanceLocador.adiciona(locador);
        
        Locatario locatario = new Locatario();
        locatario.setDataCadastro(new Date(Calendar.getInstance().getTime().getTime()));
        locatario.setNome("Maria Delsa Albuquerque");
        locatario.setRg("56525772");
        locatario.setCpf("3813883-45");
        locatario.setProfissao("Artesã");
        locatario.setEstadoCivil("Casada");
        locatario.setNacionalidade("brasileira");
        locatario.setEndereco("Rua das rosas");
        locatario.setNumEndereco("1209");
        locatario.setBairro("Centro");
        locatario.setCep("60000-000");
        locatario.setCidade("Baturité");
        locatario.setUf("CE");
        locatario.setStatus(true);
        LocatarioDAO instanceLocatario = new LocatarioDAO();
        codDoLocatario = instanceLocatario.adiciona(locatario);
        
        Contrato contrato = new Contrato();
        contrato.setLocador(locador);
        contrato.setLocatario(locatario);
        contrato.setDescricao("Contrato de Aluguel");
        contrato.setMensalidade(250.00f);
        contrato.setPrazo(12);
        ContratoDAO instance = new ContratoDAO();
        codDoContrato = instance.adiciona(contrato);
        assertTrue(codDoContrato > 0);
    }
       
       @Test
    public void testSeleciona() throws Exception {
        System.out.println("seleciona");
        ContratoDAO instance = new ContratoDAO();
        Contrato result = instance.seleciona(codDoContrato);
        assertEquals(codDoContrato, result.getCodigo());
    }
       
       @Test
    public void testAtualiza() throws Exception {
        System.out.println("atualiza");
        ContratoDAO instance = new ContratoDAO();
        Contrato contrato = instance.seleciona(codDoContrato);
        contrato.setDescricao("Aluguel Residencial");
        instance.atualiza(contrato);
        assertEquals(instance.seleciona(codDoContrato).getDescricao(), "Aluguel Residencial");
    }
       
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        LocadorDAO instanciaLocador = new LocadorDAO();
        LocatarioDAO instanciaLocatario = new LocatarioDAO();
        ContratoDAO instance = new ContratoDAO();
        instance.remove(codDoContrato);
        instanciaLocador.remove(codDoLocador);
        instanciaLocatario.remove(codDoLocatario);
        assertNull(instance.seleciona(codDoContrato));
        assertNull(instanciaLocador.seleciona(codDoLocador));
        assertNull(instanciaLocatario.seleciona(codDoLocatario));
    }
    
}
