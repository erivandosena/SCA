/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.ejb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Erivando
 * @date 01/04/2012 20:56:25
 */
public abstract class SessionBeanBasico implements Serializable {

    private static final long serialVersionUID = 1L;
    @PersistenceContext
    private EntityManager em;
    
    public SessionBeanBasico() {
    }
    
    public EntityManager getEm() {
        return em;
    }

    public <T> List<T> getLista(Class<T> classToCast, String query, Object... valores) {
        Query qr = criarConsulta(query, valores);
        return qr.getResultList();
    }

    public <T> List<T> getNamedLista(Class<T> classToCast, String namedQuery, Object... valores) {
        Query qr = criarConsultaNamedQuery(namedQuery, valores);
        return qr.getResultList();
    }

    public <T> T getPojo(Class<T> classToCast, String query, Object... valores) {
        Query qr = criarConsulta(query, valores);
        return (T) qr.getSingleResult();
    }

    public <T> T getPojo(Class<T> classToCast, Serializable chavePrimaria) {
        return em.find(classToCast, chavePrimaria);
    }

    public int executaQuery(String query, Object... valores) {
        Query qr = criarConsulta(query, valores);
        return qr.executeUpdate();
    }

    private Query criarConsulta(String query, Object[] valores) {
        Query qr = em.createQuery(query);
        if (valores != null) {
            for (int i = 0; i < valores.length; i++) {
                Object obj = valores[i];
                qr.setParameter(i + 1, obj);
            }
        }
        return qr;
    }

    private Query criarConsultaNamedQuery(String namedQuery, Object[] valores) {
        Query qr = em.createNamedQuery(namedQuery);
        if (valores != null) {
            for (int i = 0; i < valores.length; i++) {
                Object obj = valores[i];
                qr.setParameter(i + 1, obj);
            }
        }
        return qr;
    }
}
