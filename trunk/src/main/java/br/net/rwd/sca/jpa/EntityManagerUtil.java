/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Erivando
 */
public class EntityManagerUtil {

    private static EntityManagerFactory emf;
    private static final String PU = "ScaAppHibernateJPA";

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PU);
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

}
