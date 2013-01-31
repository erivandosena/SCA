/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Contrato;
import br.net.rwd.sca.jpa.JpaUtilPattern;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Erivando
 */
public class ContratoDAO {

    public ContratoDAO() {
    }

    public int adiciona(Contrato contrato) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date dataAtual = new Date();
        
        contrato.setCodigo(JpaUtilPattern.getInstancia().obtemProximoCod("contrato", "codigo"));
        contrato.setNumero(sdf.format(dataAtual) + "-" + contrato.getCodigo());

        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.persist(contrato);
        em.getTransaction().commit();
        em.close();
        return contrato.getCodigo();
    }

    public void atualiza(Contrato contrato) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        try {
            em.merge(contrato);
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
    
    public void remove(int codContrato) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.remove(em.find(Contrato.class, codContrato));
        em.getTransaction().commit();
        em.close();
    }

    public Contrato seleciona(int codContrato) {
        return JpaUtilPattern.getInstancia().getEntidade(Contrato.class, codContrato);
    }

    public List<Contrato> seleciona() {
        return JpaUtilPattern.getInstancia().getLista(Contrato.class, "SELECT contr FROM contrato contr ORDER BY contr.dataInicial ASC");
    }

}
