/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Carne;
import br.net.rwd.sca.entidades.Mensalidade;
import br.net.rwd.sca.jpa.JpaUtilPattern;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Erivando
 */
public class CarneDAO {

    public CarneDAO() {
    }

    public int adicionaCarne(Carne carne) throws SQLException {
        carne.setCodigo(JpaUtilPattern.getInstancia().obtemProximoCod("carne", "codigo"));

        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.persist(carne);
        em.getTransaction().commit();
        em.close();

        Mensalidade mensalidade = new Mensalidade();
        GregorianCalendar dataInicial = new GregorianCalendar();
        dataInicial.setTime(carne.getContrato().getDataInicial());
        int prazo = carne.getContrato().getPrazo();

        int contador = 0;
        /* --------------------------- INSERÇÃO ----------------------------- */
        insereParcela(prazo, contador, dataInicial, mensalidade, carne);
        /* --------------------------- INSERÇÃO ----------------------------- */

        return carne.getCodigo();
    }

    public void atualizaCarne(Carne carne) throws SQLException {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.merge(carne);
        em.getTransaction().commit();
        em.close();

        Mensalidade mensalidade = null;
        List<Mensalidade> listaMensalidade = selecionaMensalidade(carne.getCodigo());

        GregorianCalendar dataInicial = new GregorianCalendar();
        dataInicial.setTime(carne.getContrato().getDataInicial());
        int prazo = carne.getContrato().getPrazo();

        /* -------------------------- ATUALIZAÇÃO --------------------------- */
        int contador = 0;
        for (Mensalidade parcela : listaMensalidade) {

            mensalidade = selecionaMensalidadePorCodigo(parcela.getCodigo());
            GregorianCalendar dataVencimento = new GregorianCalendar();
            dataVencimento.setTime(dataInicial.getTime());
            dataVencimento.add(GregorianCalendar.MONTH, contador);

            mensalidade.setCarne(carne);
            mensalidade.setValor(carne.getContrato().getMensalidade());
            mensalidade.setVencimento(new java.sql.Date(dataVencimento.getTimeInMillis()));
            mensalidade.setNumero(++contador + "/" + prazo);
            mensalidade.setObservacao(carne.getObservacao());

            atualizaMensalidade(mensalidade);
            System.out.println("ATUALIZOU MENSALIDADE");

            //Exclusão
            if (contador > prazo) {
                removeMensalidade(mensalidade.getCodigo());
            }
        }
        /* ------------------------- ATUALIZAÇÃO ---------------------------- */

        /* --------------------------- INSERÇÃO ----------------------------- */
        insereParcela(prazo, contador, dataInicial, mensalidade, carne);
        /* --------------------------- INSERÇÃO ----------------------------- */
    }

    public void removeCarne(int codCarne) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.remove(em.find(Carne.class, codCarne));
        em.getTransaction().commit();
        em.close();
    }

    public Carne selecionaCarne(int codCarne) {
        return JpaUtilPattern.getInstancia().getEntidade(Carne.class, codCarne);
    }

    public List<Carne> selecionaCarne() {
        return JpaUtilPattern.getInstancia().getLista(Carne.class, "SELECT carn FROM carne carn ORDER BY carn.contrato.dataInicial ASC");
    }

    public int adicionaMensalidade(Mensalidade mensalidade) throws SQLException {
        mensalidade.setCodigo(JpaUtilPattern.getInstancia().obtemProximoCod("mensalidade", "codigo"));
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.persist(mensalidade);
        em.getTransaction().commit();
        em.close();

        return mensalidade.getCodigo();
    }

    public void atualizaMensalidade(Mensalidade mensalidade) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.merge(mensalidade);
        em.getTransaction().commit();
        em.close();
    }

    public void removeMensalidade(int codMensalidade) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        em.remove(em.find(Mensalidade.class, codMensalidade));
        em.getTransaction().commit();
        em.close();
    }

    public Mensalidade selecionaMensalidadePorCodigo(int codMensalidade) {
        return JpaUtilPattern.getInstancia().getEntidade(Mensalidade.class, codMensalidade);
    }

    public List<Mensalidade> selecionaMensalidade(int carneCod) {
        return JpaUtilPattern.getInstancia().getLista(Mensalidade.class, "SELECT mensa FROM mensalidade mensa WHERE mensa.carne.codigo = ?1 ORDER BY mensa.vencimento ASC", carneCod);
    }

    /*
    public Carne selecionaCarneCriteria(int codCarne) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Carne> c = cb.createQuery(Carne.class);
            Root<Carne> carne = c.from(Carne.class);
            c.where(cb.equal(carne.get("codigo"), cb.parameter(Integer.class, "codigo")));
            TypedQuery q = em.createQuery(c);
            q.setParameter("codigo", codCarne);

            return (Carne) q.getSingleResult();
        } finally {
            em.getTransaction().commit();
            em.close();
        }

    }

    public List<Mensalidade> selecionaMensalidadeCriteria(Integer codMensalidade) {
        EntityManager em = JpaUtilPattern.getInstancia().getEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Mensalidade> c = cb.createQuery(Mensalidade.class);

             //A partir da CriteriaQuery podemos informar de qual tabela os dados serão consultados usando o método from(), que dado uma classe
             //ou tipo de entidade (EntityType) ele retorna um objeto do tipo Root<T>, que representa a clausula "from" da consulta.
             
             //Através do Root<T> é possível obter as colunas, fazer joins, usar a clausula "in" e outros.
             
            Root<Mensalidade> mensalidade = c.from(Mensalidade.class);

             //A partir do Root<T> é chamado o método where() que adiciona uma comparação se o campo "id" da entidade possui o valor do parametro "id".

             //Diferente do JPQL a passagem de parâmetro é fortemente tipada, a partir da CriteriaBuilder é necessário criar um parâmetro
             //(ParameterExpression<T>) que possui o tipo do parametro e seu nome.

            c.where(cb.equal(mensalidade.get("codigo"), cb.parameter(Integer.class, "codigo")));

            TypedQuery q = em.createQuery(c);
            //A passagem de parâmetros é igual ao do JPQL.
            q.setParameter("codigo", codMensalidade);
            return q.getResultList();
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
     * 
     */

    private void insereParcela(int prazo, int contador, GregorianCalendar dataInicial, Mensalidade mensalidade, Carne carne) throws SQLException {
        /* -------------------------------------------------------------------
        //obter a qauntidade de meses da diferença entre a datas inicial e final
        
        Calendar data1 = Calendar.getInstance();
        data1.setTime(dataInicial.getTime());
        
        Calendar data2 = Calendar.getInstance();
        data2.setTime(dataFinal.getTime());
        
        int difM = data2.get(Calendar.MONTH) - data1.get(Calendar.MONTH);
        int difA = ((data2.get(Calendar.YEAR) - data1.get(Calendar.YEAR)) * 12);
        
        int quantMeses = difA + difM;
        /* -------------------------------------------------------------------*/

        while (prazo > contador) {
            GregorianCalendar dataVencimento = new GregorianCalendar();
            dataVencimento.setTime(dataInicial.getTime());
            dataVencimento.add(GregorianCalendar.MONTH, contador);

            mensalidade.setCarne(carne);
            mensalidade.setValor(carne.getContrato().getMensalidade());
            mensalidade.setVencimento(new java.sql.Date(dataVencimento.getTime().getTime()));
            mensalidade.setNumero(++contador + "/" + prazo);
            mensalidade.setObservacao(carne.getObservacao());

            adicionaMensalidade(mensalidade);
        }
        /* --------------------------- INSERÇÃO ----------------------------- */
    }
}
