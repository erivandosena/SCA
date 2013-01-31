/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Erivando
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({br.net.rwd.sca.dao.LocatarioDAOTest.class, br.net.rwd.sca.dao.LocadorDAOTest.class, br.net.rwd.sca.dao.ContratoDAOTest.class, br.net.rwd.sca.dao.CarneDAOTest.class})
public class TodosOsTestes {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
