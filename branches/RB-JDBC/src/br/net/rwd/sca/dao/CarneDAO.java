/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Carne;
import br.net.rwd.sca.entidades.Mensalidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Erivando
 */
public class CarneDAO extends DAOGenerico {

    private static final String INSERT_MENSALIDADE = "INSERT INTO mensalidade (mensa_cod, carne_cod, mensa_valor, mensa_vencimento, mensa_numero, mensa_observacao) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_MENSALIDADE = "UPDATE mensalidade SET carne_cod=?, mensa_valor=?, mensa_vencimento=?, mensa_numero=?, mensa_observacao=? WHERE mensa_cod=?";
    private static final String DELETE_MENSALIDADE = "DELETE from mensalidade WHERE mensa_cod = ?";
    private static final String DELETE_MENSALIDADE_CARNE = "DELETE from mensalidade WHERE carne_cod = ?";
    private static final String SELECT_MENSALIDADE = "SELECT mensa_cod, carne_cod, mensa_valor, mensa_vencimento, mensa_numero, mensa_observacao FROM mensalidade WHERE mensa_cod = ?";
    private static final String SELECT_MENSALIDADE_CARNE = "SELECT mensa_cod, carne_cod, mensa_valor, mensa_vencimento, mensa_numero, mensa_observacao FROM mensalidade WHERE carne_cod = ?";

    public CarneDAO() {
    }

    public int adicionaCarne(Carne carne, String obs) throws SQLException {
        carne.setCodigo(obtemProximoCod("carne", "carne_cod"));
        String consulta = "INSERT INTO carne (carne_cod, contr_cod) VALUES (?, ?)";
        executaCommand(consulta, carne.getCodigo(), carne.getContrato().getCodigo());

        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setCarne(carne);

        GregorianCalendar dataVencimento = new GregorianCalendar();
        dataVencimento.setTime(new Date(mensalidade.getCarne().getContrato().getDataInicial().getTime()));
        dataVencimento.add(GregorianCalendar.MONTH, -1);

        // adiciona mensalidade
        for (int i = 1; i <= carne.getContrato().getPrazo(); i++) {
            dataVencimento.add(GregorianCalendar.MONTH, 1);
            mensalidade.setValor(mensalidade.getCarne().getContrato().getMensalidade());
            mensalidade.setVencimento(new java.sql.Date(dataVencimento.getTimeInMillis()));
            mensalidade.setNumero(i + "/" + carne.getContrato().getPrazo());
            mensalidade.setObservacao(obs);
            adicionaMensalidade(carne, mensalidade);
        }

        return carne.getCodigo();
    }

    public void atualizaCarne(Carne carne, String obs) throws SQLException {
        String consulta = "UPDATE carne SET contr_cod=? WHERE carne_cod=?";
        executaCommand(consulta,
                carne.getContrato().getCodigo(),
                carne.getCodigo());
        
        // remove mensalidades
        CarneDAO mensalidades = new CarneDAO();
        mensalidades.removeMensalidades(carne.getCodigo());
        
     //   Calendar calendar = Calendar.getInstance();
     //   calendar.setTime(new Date(calendar.getTime().getTime()));
     //   calendar.add(Calendar.DATE, -30);

        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setCarne(carne);
        
        GregorianCalendar dataVencimento = new GregorianCalendar();
        dataVencimento.setTime(new Date(mensalidade.getCarne().getContrato().getDataInicial().getTime()));
        dataVencimento.add(GregorianCalendar.MONTH, -1);
        
        // adiciona mensalidade
        for (int i = 1; i <= carne.getContrato().getPrazo(); i++) {
         //   calendar.add(Calendar.DATE, 30);
            dataVencimento.add(GregorianCalendar.MONTH, 1);
            mensalidade.setValor(mensalidade.getCarne().getContrato().getMensalidade());
            mensalidade.setVencimento(new java.sql.Date(dataVencimento.getTimeInMillis()));
            mensalidade.setNumero(i + "/" + carne.getContrato().getPrazo());
            mensalidade.setObservacao(obs);
            adicionaMensalidade(carne, mensalidade);
        }

    }

    public void removeCarne(int codCarne) throws SQLException {
        //remove mensalidade
        removeMensalidades(codCarne);
        
        String consulta = "DELETE from carne WHERE carne_cod = ?";
        executaCommand(consulta, codCarne);
    }

    public Carne selecionaCarne(int codCarne) throws SQLException {
        String consulta = "SELECT carne_cod, contr_cod FROM carne WHERE carne_cod = ?";
        ResultSet rs = executaQuery(consulta, codCarne);
        Carne carnes = null;
        if (rs.next()) {
            carnes = populaCarnes(rs, true);
        }
        rs.close();

        return carnes;
    }
    
    public Carne selecionaCarnePorContrato(int codContrato) throws SQLException {
        String consulta = "SELECT carne_cod, contr_cod FROM carne WHERE contr_cod = ?";
        ResultSet rs = executaQuery(consulta, codContrato);
        Carne carnes = null;
        if (rs.next()) {
            carnes = populaCarnes(rs, true);
        }
        rs.close();

        return carnes;
    }

    public List<Carne> selecionaTodosCarnes() throws SQLException {
        ResultSet rs = executaQuery("SELECT carne_cod, contr_cod FROM carne");
        List<Carne> carnes = new LinkedList<Carne>();
        while (rs.next()) {
            carnes.add(populaCarnes(rs, true));
        }
        rs.close();

        return carnes;
    }

    private Carne populaCarnes(ResultSet rs, boolean populaMensalidades) throws SQLException {
        Carne carne = new Carne();

        ContratoDAO contratoDao = new ContratoDAO();

        carne.setCodigo(rs.getInt("carne_cod"));
        carne.setContrato(contratoDao.seleciona(rs.getInt("contr_cod")));

        if (populaMensalidades) {
            carne.setMensalidades(selecionaMensalidades(carne));
        }

        return carne;
    }

    public List<Mensalidade> selecionaMensalidades(Carne carne) throws SQLException {
        List<Mensalidade> mensalidade = new LinkedList<Mensalidade>();
        ResultSet rs = executaQuery(SELECT_MENSALIDADE_CARNE, carne.getCodigo());
        while (rs.next()) {
            mensalidade.add(populaMensalidades(rs, carne));
        }
        rs.close();

        return mensalidade;
    }

    public int adicionaMensalidade(Carne carne, Mensalidade mensalidade) throws SQLException {
        mensalidade.setCodigo(obtemProximoCod("mensalidade", "mensa_cod"));
        mensalidade.setCarne(carne);
        executaCommand(INSERT_MENSALIDADE,
                mensalidade.getCodigo(),
                mensalidade.getCarne().getCodigo(),
                mensalidade.getValor(),
                mensalidade.getVencimento(),
                mensalidade.getNumero(),
                mensalidade.getObservacao());

        return mensalidade.getCodigo();
    }

    public void atualizaMensalidade(Mensalidade mensalidade) throws SQLException {
        executaCommand(UPDATE_MENSALIDADE,
                mensalidade.getCarne().getCodigo(),
                mensalidade.getValor(),
                mensalidade.getVencimento(),
                mensalidade.getNumero(),
                mensalidade.getObservacao(),
                mensalidade.getCodigo());
    }

    public void removeMensalidade(int codMensalidade) throws SQLException {
        executaCommand(DELETE_MENSALIDADE, codMensalidade);
    }

    public void removeMensalidades(int codCarne) throws SQLException {
        executaCommand(DELETE_MENSALIDADE_CARNE, codCarne);
    }

    public Mensalidade selecionaMensalidade(int codMensalidade) throws SQLException {
        ResultSet rs = executaQuery(SELECT_MENSALIDADE, codMensalidade);
        Mensalidade mensalidades = null;
        if (rs.next()) {
            mensalidades = populaMensalidades(rs);
        }
        rs.close();

        return mensalidades;
    }
    
    public JasperPrint imprime(int codCarne) throws SQLException, JRException {
        String consulta = "SELECT "
                + "mensalidade.mensa_valor AS mensalidade_mensa_valor,"
                + "mensalidade.mensa_vencimento AS mensalidade_mensa_vencimento,"
                + "mensalidade.mensa_numero AS mensalidade_mensa_numero,"
                + "mensalidade.mensa_observacao AS mensalidade_mensa_observacao,"
                + "locador.locad_nome AS locador_locad_nome,"
                + "locatario.locat_nome AS locatario_locat_nome,"
                + "locatario.locat_cpf AS locatario_locat_cpf,"
                + "contrato.contr_numero AS contrato_contr_numero,"
                + "contrato.contr_descricao AS contrato_contr_descricao,"
                + "locador.locad_cidade AS locador_locad_cidade,"
                + "locador.locad_uf AS locador_locad_uf,"
                + "locatario.locat_telefone AS locatario_locat_telefone "
                + "FROM "
                + "public.carne carne INNER JOIN public.mensalidade mensalidade ON carne.carne_cod = mensalidade.carne_cod "
                + "INNER JOIN public.contrato contrato ON carne.contr_cod = contrato.contr_cod "
                + "INNER JOIN public.locador locador ON contrato.locad_cod = locador.locad_cod "
                + "INNER JOIN public.locatario locatario ON contrato.locat_cod = locatario.locat_cod "
                + "WHERE "
                + "mensalidade.carne_cod =?"
                + "ORDER BY "
                + "mensalidade.mensa_numero ASC";
        ResultSet rs = executaQuery(consulta, codCarne);

        Map parametersContrato = new HashMap();
        parametersContrato.put("CODIGO_CARNE", codCarne);

        JRResultSetDataSource jrResultData = new JRResultSetDataSource(rs); 
        JasperPrint jp = JasperFillManager.fillReport(System.getProperty("user.dir") + "\\relatorios\\carne.jasper", parametersContrato, jrResultData);
        rs.close();                                                     

        return jp;
    }

    private Mensalidade populaMensalidades(ResultSet rs, Carne... carne) throws SQLException {
        Mensalidade mensalidade = new Mensalidade();

        mensalidade.setCodigo(rs.getInt("mensa_cod"));
        mensalidade.setValor(rs.getFloat("mensa_valor"));
        mensalidade.setVencimento(rs.getDate("mensa_vencimento"));
        mensalidade.setNumero(rs.getString("mensa_numero"));
        mensalidade.setObservacao(rs.getString("mensa_observacao"));

        if (carne != null && carne.length > 0) {
            mensalidade.setCarne(carne[0]);
        } else {
            mensalidade.setCarne(selecionaCarne(rs.getInt("carne_cod")));
        }

        return mensalidade;
    }
}
