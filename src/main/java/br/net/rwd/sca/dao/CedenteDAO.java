/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.CedenteCobranca;
import br.net.rwd.sca.jpa.JpaUtilPattern;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Administrador
 */
public class CedenteDAO {

    public CedenteDAO() {
    }
    
        public int adiciona(CedenteCobranca cedente) throws SQLException {
        cedente.setCeden_cod(JpaUtilPattern.getInstancia().obtemProximoCod("cedente", "ceden_cod"));

        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.persist(cedente);
        em.getTransaction().commit();
        em.close();
        return cedente.getCeden_cod();
    }

    public void atualiza(CedenteCobranca cedente) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.merge(cedente);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(int codCedente) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.remove(em.find(CedenteCobranca.class, codCedente));
        em.getTransaction().commit();
        em.close();
    }

    public CedenteCobranca selecionaCedente() {
        return JpaUtilPattern.getInstancia().getEntidade(CedenteCobranca.class, "SELECT c FROM cedente c ORDER BY c.ceden_nome ASC");
    }

    public List<CedenteCobranca> seleciona() {
        return JpaUtilPattern.getInstancia().getLista(CedenteCobranca.class, "SELECT c FROM cedente c ORDER BY c.ceden_nome ASC");
    }
    
}
