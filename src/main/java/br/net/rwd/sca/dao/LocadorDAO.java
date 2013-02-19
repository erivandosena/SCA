/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Locador;
import br.net.rwd.sca.jpa.JpaUtilPattern;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Erivando
 */
public class LocadorDAO {

    public LocadorDAO() {
    }

    public int adiciona(Locador locador) throws SQLException {
        locador.setCodigo(JpaUtilPattern.getInstancia().obtemProximoCod("locador", "codigo"));

        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.persist(locador);
        em.getTransaction().commit();
        em.close();
        return locador.getCodigo();
    }

    public void atualiza(Locador locador) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.merge(locador);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(int codLocador) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.remove(em.find(Locador.class, codLocador));
        em.getTransaction().commit();
        em.close();
    }

    public Locador seleciona(int codLocador) {
        return JpaUtilPattern.getInstancia().getEntidade(Locador.class, codLocador);
    }

    public List<Locador> seleciona() {
        return JpaUtilPattern.getInstancia().getLista(Locador.class, "SELECT locad FROM locador locad ORDER BY locad.nome ASC");
    }

    /**
     * @deprecated 
     * Método não mais necessário usando JPA com anotação orphanRemoval=true na entidade.
     * @param codLocador
     * @return boolean
     */
    public boolean isContratoAtivoLocador(int codLocador) {
        boolean retorno = false;
        Object obj = JpaUtilPattern.getInstancia().getEntidade(Locador.class, "SELECT MAX(contr.codigo) FROM contrato contr WHERE contr.locador.codigo = ?1", codLocador);
        if (obj != null) {
            retorno = true;
        }
        return retorno;
    }
}
