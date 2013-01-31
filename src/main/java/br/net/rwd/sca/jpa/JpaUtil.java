/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Erivando
 */
public abstract class JpaUtil<T extends Serializable> extends EntityManagerUtil {

    private Logger log4j = Logger.getLogger(Class.class.getName());

    public JpaUtil() {
    }

    public void adicionar(T object) {
        EntityManager em = getEntityManager();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            log4j.error(ex);
        } finally {
            em.close();
        }
    }

    public void remover(Class<T> classe, int codigo) {
        EntityManager em = getEntityManager();
        try {
            em.remove(em.find(classe, codigo));
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            log4j.error(ex);
        } finally {
            em.close();
        }
    }

    public void atualizar(T object) {
        EntityManager em = getEntityManager();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            log4j.error(ex);
        } finally {
            em.close();
        }
    }

    public <T> List<T> getLista(Class<T> classToCast, String query, Object... valores) {
        Query qr = null;
        EntityManager em = getEntityManager();
        try {
            qr = em.createQuery(query);
            if (valores != null) {
                for (int i = 0; i < valores.length; i++) {
                    qr.setParameter(i + 1, valores[i]);
                }
            }
        } catch (Exception ex) {
            log4j.error(ex);
        } finally {
            em.close();
        }
        return qr.getResultList();
    }

    public <T> List<T> getNamedLista(Class<T> classToCast, String namedQuery, Object... valores) {
        Query qr = null;
        EntityManager em = getEntityManager();
        try {
            qr = em.createNamedQuery(namedQuery);
            if (valores != null) {
                for (int i = 0; i < valores.length; i++) {
                     Object obj = valores[i];
                     qr.setParameter(i + 1, obj);
                }
            }
        } catch (Exception ex) {
            log4j.error(ex);
        } finally {
            em.close();
        }
        return qr.getResultList();
    }

    public <T> List<T> getNativeLista(Class<T> classToCast, String nativeQuery, Object... valores) {
        Query qr = null;
        EntityManager em = getEntityManager();
        try {
            qr = em.createNativeQuery(nativeQuery);
            if (valores != null) {
                for (int i = 0; i < valores.length; i++) {
                    qr.setParameter(i + 1, valores[i]);
                }
            }
        } catch (Exception ex) {
            log4j.error(ex);
        } finally {
            em.close();
        }
        return qr.getResultList();
    }

    public <T> T getPojo(Class<T> classToCast, String query, Object... valores) {
        T t = null;
        EntityManager em = getEntityManager();
        try {
            Query qr = em.createQuery(query);
            if (valores != null) {
                for (int i = 0; i < valores.length; i++) {
                    qr.setParameter(i + 1, valores[i]);
                }
            }
            t = (T) qr.getSingleResult();
            if (t == null) {
                throw new NoResultException();
            }
        } catch (NoResultException nre) {
            log4j.error(nre);
        } catch (Exception ex) {
            log4j.error(ex);
        } finally {
            em.close();
        }
        return t;
    }

    public <T> T getPojo(Class<T> classToCast, Serializable chavePrimaria) {
        T t = null;
        EntityManager em = getEntityManager();
        try {
            t = em.find(classToCast, chavePrimaria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            log4j.error(ex);
        } finally {
            em.close();
        }
        return t;
    }

    public int executarConsulta(String query, Object... valores) {
        Query qr = null;
        EntityManager em = getEntityManager();
        try {
            qr = em.createQuery(query);
            if (valores != null) {
                for (int i = 0; i < valores.length; i++) {
                    qr.setParameter(i + 1, valores[i]);
                }
            }
        } catch (Exception ex) {
            log4j.error(ex);
        } finally {
            em.close();
        }
        return qr.executeUpdate();
    }

    public Integer obterProximoCodigo(String query) {
        Object obj = null;
        EntityManager em = getEntityManager();
        try {
            obj = em.createQuery(query).getSingleResult();
        } catch (Exception ex) {
            log4j.error(ex);
        } finally {
            em.close();
        }

        if (obj == null) {
            return 1;
        } else {
            return ((Integer) obj) + 1;
        }
    }
}
