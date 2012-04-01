    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Locatario;
import br.net.rwd.sca.jpa.JpaUtilPattern;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Erivando
 */
public class LocatarioDAO {

    public LocatarioDAO() {
    }
    
    public int adiciona(Locatario locatario) throws SQLException {
        locatario.setCodigo(JpaUtilPattern.getInstancia().obtemProximoCod("locatario", "codigo"));

        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.persist(locatario);
        em.getTransaction().commit();
        em.close();
        return locatario.getCodigo();
    }
    
    public void atualiza(Locatario locatario) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.merge(locatario);
        em.getTransaction().commit();
        em.close();
    }
    
    public void remove(int codLocatario) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.remove(em.find(Locatario.class, codLocatario));
        em.getTransaction().commit();
        em.close();
    }
    
    public Locatario seleciona(int codLocatario) {
        return JpaUtilPattern.getInstancia().getEntidade(Locatario.class, codLocatario);
    }
    
    public List<Locatario> seleciona() {
        return JpaUtilPattern.getInstancia().getLista(Locatario.class, "SELECT locat FROM locatario locat ORDER BY locat.nome ASC");
    }

}
