/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.jpa;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrador
 */
public class JpaUtilPattern {

    private static JpaUtilPattern instancia;
    private EntityManagerFactory emf;
    public static Logger log4j = Logger.getLogger(Class.class.getName());

    private JpaUtilPattern() {
        emf = Persistence.createEntityManagerFactory("ScaAppHibernateJPA");
    }

    public static JpaUtilPattern getInstancia() {
        if (instancia == null) {
            instancia = new JpaUtilPattern();
        }
        return instancia;
    }

    public EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

   
    public List<?> executaQuery(String sql, Object... parametros) {
        EntityManager em = getEntityManager();
        Query consulta = em.createNativeQuery(sql);

        try {
            for (int i = 0; i < parametros.length; i++) {
                consulta.setParameter(i + 1, parametros[i]);
            }
            return consulta.getResultList();
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public List<?> executaQueryJpql(String jpql, Object... parametros) {
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery(jpql);

        try {
            for (int i = 0; i < parametros.length; i++) {
                consulta.setParameter(i + 1, parametros[i]);
            }
            return consulta.getResultList();
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public <T> List<T> getLista(Class<T> classToCast, String jpql, Object... parametros) {
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery(jpql);

        try {
            for (int i = 0; i < parametros.length; i++) {
                consulta.setParameter(i + 1, parametros[i]);
            }
            return consulta.getResultList();
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public <T> T getEntidade(Class<T> entityClass, String jpql, Object... parametros) {
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery(jpql);
        T entidade = null;

        try {
            for (int i = 0; i < parametros.length; i++) {
                consulta.setParameter(i + 1, parametros[i]);
            }
            try {
                if (consulta.getSingleResult() != null) {
                    entidade = (T) consulta.getSingleResult();
                }
            } catch (NoResultException nre) {
                log4j.error(nre);
            }
            return entidade;
        } finally {
            em.getTransaction().commit();
            em.close();
        }

    }

    public <T> T getEntidade(Class<T> entityClass, Serializable pk) {
        EntityManager em = getEntityManager();
        try {
            T entidade = em.find(entityClass, pk);
            return entidade;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public Integer obtemProximoCod(String nomeTabela, String nomeColuna) throws SQLException {
        EntityManager em = getEntityManager();
        Object codObj = em.createQuery("SELECT MAX(tabela." + nomeColuna + ") FROM " + nomeTabela + " tabela").getSingleResult();
        try {
            if (codObj == null) {
                return 1;
            } else {
                return ((Integer) codObj) + 1;
            }
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
}
