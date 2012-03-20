/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.ListIterator;
import br.net.rwd.sca.entidades.Locatario;
import java.util.List;
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
public class LocatarioDAOTest {
    public static Integer codDoLocatario = 0;
    
    public LocatarioDAOTest() {
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
        LocatarioDAO instance = new LocatarioDAO();
        codDoLocatario = instance.adiciona(locatario);
        Locatario result = instance.seleciona(codDoLocatario);
        assertEquals(codDoLocatario, result.getCodigo());
    }

    @Test
    public void testSeleciona() throws Exception {
        System.out.println("seleciona");
        LocatarioDAO instance = new LocatarioDAO();
        Locatario result = instance.seleciona(codDoLocatario);
        assertEquals(codDoLocatario, result.getCodigo());
    }
    
    @Test
    public void testSelecionaTodosPorNome() throws Exception {
        System.out.println("selecionaTodosPorNome");
        String nome = "AlBU";
        LocatarioDAO instance = new LocatarioDAO();
        List result = instance.selecionaTodosPorNome(nome);

        ListIterator<Locatario> iterador = result.listIterator(0);
        while (iterador.hasNext()) {
            Locatario n = iterador.next();
            System.out.println(n.getCodigo() +" - "+n.getNome());
        }

        System.out.println("Total: "+result.size());

        assertTrue(result.size() > 0);
    }  

    @Test
    public void testAtualiza() throws Exception {
        System.out.println("atualiza");
        LocatarioDAO instance = new LocatarioDAO();
        Locatario locatario = instance.seleciona(codDoLocatario);
        locatario.setNome("RAMON G. RAMOS");
        instance.atualiza(locatario);
        locatario = instance.seleciona(codDoLocatario);
        System.out.println(locatario.getNome());
        assertEquals(locatario.getNome(), "RAMON G. RAMOS");
    }

    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        int codLocatario = codDoLocatario;
        LocatarioDAO instance = new LocatarioDAO();
        instance.remove(codLocatario);
        assertNull(instance.seleciona(codLocatario));
    }
}
