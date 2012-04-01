/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import br.net.rwd.sca.entidades.Contrato;
import br.net.rwd.sca.entidades.Locador;
import br.net.rwd.sca.entidades.Locatario;
import br.net.rwd.sca.entidades.Carne;
import br.net.rwd.sca.entidades.Mensalidade;
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
public class CarneDAOTest {
    public static Integer codDoCarne = 0;
    public static Integer codDoCarneMens1 = 0;
    public static Integer codDoLocador = 0;
    public static Integer codDoLocatario = 0;
    public static Integer codDoContrato = 0;
    
    public CarneDAOTest() {
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
    public void testAdicionaCarne() throws Exception {
        System.out.println("adicionaCarne");
        
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
        
        Integer prazo = 3;
        Date dataInicio = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataInicio = format.parse("29/03/2012");
        
        GregorianCalendar dataFinal = new GregorianCalendar();
        dataFinal.setTime(dataInicio);
        dataFinal.add(GregorianCalendar.MONTH, prazo);
        
       /* ------------------------------------------------*/
        //obter um inteiro da diferenca entre os meses
        
        Calendar data1 = Calendar.getInstance();
        data1.setTime(dataInicio);
			
	Calendar data2 = Calendar.getInstance();
	data2.setTime(dataFinal.getTime());
			
	int difMes = data2.get(Calendar.MONTH)-data1.get(Calendar.MONTH);
	int difAno = ((data2.get(Calendar.YEAR)-data1.get(Calendar.YEAR))*12);
	int mezes = difAno+difMes;

      /* ------------------------------------------------*/
 
        Contrato contrato = new Contrato();
        contrato.setLocador(locador);
        contrato.setLocatario(locatario);
        contrato.setNumero("2012-001");
        contrato.setDescricao("Contrato de Aluguel");
        contrato.setMensalidade(250.00f);
        contrato.setPrazo(mezes);
        contrato.setDataInicial(dataInicio);
        contrato.setDataFinal(new java.sql.Date(dataFinal.getTimeInMillis()));
        ContratoDAO instanceContrato = new ContratoDAO();
        
        codDoContrato = instanceContrato.adiciona(contrato);

        Carne carne = new Carne();
        carne.setContrato(contrato);
        carne.setObservacao("Pague em dias e evite cobranças.");

        CarneDAO instance = new CarneDAO();
        codDoCarne = instance.adicionaCarne(carne);
        carne = instance.selecionaCarne(codDoCarne);
        
        assertTrue(codDoCarne > 0);
        assertEquals(carne.getMensalidades().size(), mezes);
    }
    
     @Test
    public void testSelecionaCarne() throws Exception {
        System.out.println("selecionaCarne");
        CarneDAO instance = new CarneDAO();
        Carne result = instance.selecionaCarne(codDoCarne);
        assertEquals(result.getCodigo(), codDoCarne);
        codDoCarneMens1 = result.getMensalidades().get(0).getCodigo();
    }
     
     @Test
    public void testSelecionaTodosCarnes() throws Exception {
        System.out.println("selecionaTodosCarnes");
        CarneDAO instance = new CarneDAO();
        List result = instance.selecionaCarne();
        assertTrue(result.size() > 0);
    }
     
     @Test
    public void testSelecionaMensalidade() throws Exception {
        System.out.println("selecionaMensalidade");
        CarneDAO instance = new CarneDAO();
        List result = instance.selecionaMensalidade(codDoCarneMens1);
        assertTrue(result.isEmpty());
    }
     
     /*
     @Test
    public void testSelecionaMensalidades() throws Exception {
        System.out.println("selecionaMensalidades");
        CarneDAO instance = new CarneDAO();
        List result = instance.selecionaMensalidades(instance.selecionaCarne(codDoCarne));
        assertTrue(result.size() > 0);
    }
      * 
      */

    @Test
    public void testAtualizaCarne() throws Exception {
        System.out.println("atualizaCarne");
        CarneDAO instance = new CarneDAO();
        ContratoDAO instanceContrato = new ContratoDAO();
        
        Carne carne = instance.selecionaCarne(codDoCarne);
        
        Contrato contrato = instanceContrato.seleciona(codDoContrato);
        carne.setObservacao("Obrigado pelo pagamento!");
        carne.setContrato(contrato);
        contrato.setPrazo(6);
        

        instance.atualizaCarne(carne);
        carne = instance.selecionaCarne(codDoCarne);
        
        assertEquals(carne.getMensalidades().size(), 6);
    }
    
    /*
     @Test
    public void testAtualizaMensalidade() throws Exception {
        System.out.println("atualizaMensalidade");
        CarneDAO instance = new CarneDAO();
        Mensalidade mensalidade = instance.selecionaMensalidade(2);
        mensalidade.setValor(100.00f);
        instance.atualizaMensalidade(mensalidade);
        mensalidade = instance.selecionaMensalidade(2);
        assertTrue(mensalidade.getValor() == 100.00f);
   }
     * 
     */

     /*
    @Test
    public void testRemoveMensalidade() throws Exception {
        System.out.println("removeMensalidade");
        int codMensalidade = codDoCarneMens1;
        CarneDAO instance = new CarneDAO();
        instance.removeMensalidade(codMensalidade);
       assertNull(instance.selecionaMensalidade(codMensalidade));
    }
      * 
      */

     /*
    @Test
    public void testRemoveMensalidades() throws Exception {
        System.out.println("removeMensalidades");
        int codCarne = codDoCarne;
        CarneDAO instance = new CarneDAO();
        instance.removeMensalidades(codCarne);
        Carne carne = instance.selecionaCarne(codDoCarne);
        assertTrue(instance.selecionaMensalidades(carne).isEmpty());
    }
      * 
      */

    @Test
    public void testRemoveCarne() throws Exception {
        System.out.println("removeCarne");
        int codCarne = codDoCarne;
        CarneDAO instance = new CarneDAO();
        instance.removeCarne(codCarne);
        
        ContratoDAO instanceContrato = new ContratoDAO();
        instanceContrato.remove(codDoContrato);
        
        LocatarioDAO instanceLocatario = new LocatarioDAO();
        LocadorDAO instanceLocador = new LocadorDAO();
        instanceLocador.remove(codDoLocador);
        instanceLocatario.remove(codDoLocatario);
        
        UsuarioDAO instancia = new UsuarioDAO();
        instancia.remove(2);
        assertNull(instancia.seleciona(2));
        
        assertNull(instance.selecionaCarne(codCarne));
        assertNull(instanceContrato.seleciona(codDoContrato));
        assertNull(instanceLocador.seleciona(codDoLocador));
        assertNull(instanceLocatario.seleciona(codDoLocatario));
        
        
    }

}
