/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Contrato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ContratoDAO extends DAOGenerico {

    public ContratoDAO() {
    }

    public int adiciona(Contrato contrato) throws SQLException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date dataAtual = new Date();

        contrato.setCodigo(obtemProximoCod("contrato", "contr_cod"));
        contrato.setNumero(sdf.format(dataAtual) + "-" + contrato.getCodigo());
        String consulta = "INSERT INTO contrato (contr_cod, locad_cod, locat_cod, contr_numero, contr_descricao, contr_mensalidade, contr_prazo, contr_data_inicial, contr_data_final) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executaCommand(consulta,
                contrato.getCodigo(),
                contrato.getLocador().getCodigo(),
                contrato.getLocatario().getCodigo(),
                contrato.getNumero(),
                contrato.getDescricao(),
                contrato.getMensalidade(),
                contrato.getPrazo(),
                contrato.getDataInicial(),
                contrato.getDataFinal());

        return contrato.getCodigo();
    }

    public void remove(int codContrato) throws SQLException {
        executaCommand("DELETE from contrato WHERE contr_cod = ?", codContrato);
    }

    public void atualiza(Contrato contrato) throws SQLException {
        String consulta = "UPDATE contrato SET locad_cod=?, locat_cod=?, contr_descricao=?, contr_mensalidade=?, contr_prazo=?, contr_data_inicial=?, contr_data_final=? WHERE contr_cod=?";
        executaCommand(consulta,
                contrato.getLocador().getCodigo(),
                contrato.getLocatario().getCodigo(),
                contrato.getDescricao(),
                contrato.getMensalidade(),
                contrato.getPrazo(),
                contrato.getDataInicial(),
                contrato.getDataFinal(),
                contrato.getCodigo());
    }

    public Contrato seleciona(int codContrato) throws SQLException {
        ResultSet rs = executaQuery("SELECT contr_cod, locad_cod, locat_cod, contr_numero, contr_descricao, contr_mensalidade, contr_prazo, contr_data_inicial, contr_data_final FROM contrato WHERE contr_cod=?", codContrato);
        Contrato contratos = null;
        if (rs.next()) {
            contratos = populaContratos(rs);
        }
        rs.close();

        return contratos;
    }

    public List<Contrato> selecionaTodos() throws SQLException {
        ResultSet rs = executaQuery("SELECT contr_cod, locad_cod, locat_cod, contr_numero, contr_descricao, contr_mensalidade, contr_prazo, contr_data_inicial, contr_data_final FROM contrato");
        List<Contrato> Contratos = new LinkedList<Contrato>();
        while (rs.next()) {
            Contratos.add(populaContratos(rs));
        }
        rs.close();

        return Contratos;
    }

    public JasperPrint imprime(String numContrato) throws SQLException, JRException {
        String consulta = "SELECT "
                + "contrato.contr_descricao AS contrato_contr_descricao,"
                + "contrato.contr_mensalidade AS contrato_contr_mensalidade,"
                + "contrato.contr_prazo AS contrato_contr_prazo,"
                + "contrato.contr_data_inicial AS contrato_contr_data_inicial,"
                + "contrato.contr_data_final AS contrato_contr_data_final,"
                + "locatario.locat_nome AS locatario_locat_nome,"
                + "locatario.locat_rg AS locatario_locat_rg,"
                + "locatario.locat_cpf AS locatario_locat_cpf,"
                + "locatario.locat_estado_civil AS locatario_locat_estado_civil,"
                + "locatario.locat_profissao AS locatario_locat_profissao,"
                + "locatario.locat_nacionalidade AS locatario_locat_nacionalidade,"
                + "locatario.locat_endereco AS locatario_locat_endereco,"
                + "locatario.locat_num_endereco AS locatario_locat_num_endereco,"
                + "locatario.locat_bairro AS locatario_locat_bairro,"
                + "locatario.locat_cidade AS locatario_locat_cidade,"
                + "locatario.locat_uf AS locatario_locat_uf,"
                + "locador.locad_nome AS locador_locad_nome,"
                + "locador.locad_rg AS locador_locad_rg,"
                + "locador.locad_cpf AS locador_locad_cpf,"
                + "locador.locad_estado_civil AS locador_locad_estado_civil,"
                + "locador.locad_profissao AS locador_locad_profissao,"
                + "locador.locad_nacionalidade AS locador_locad_nacionalidade,"
                + "locador.locad_endereco AS locador_locad_endereco,"
                + "locador.locad_num_endereco AS locador_locad_num_endereco,"
                + "locador.locad_cidade AS locador_locad_cidade,"
                + "locador.locad_uf AS locador_locad_uf,"
                + "locador.locad_bairro AS locador_locad_bairro,"
                + "contrato.contr_numero AS contrato_contr_numero "
                + "FROM "
                + "public.locatario locatario INNER JOIN public.contrato contrato ON locatario.locat_cod = contrato.locat_cod "
                + "INNER JOIN public.locador locador ON contrato.locad_cod = locador.locad_cod "
                + "WHERE contrato.contr_numero =?";
        ResultSet rs = executaQuery(consulta, numContrato);

        Map parametersContrato = new HashMap();
        parametersContrato.put("NUMERO_CONTRATO", numContrato);

        JRResultSetDataSource jrResultData = new JRResultSetDataSource(rs); 
        JasperPrint jp = JasperFillManager.fillReport(System.getProperty("user.dir") + "\\relatorios\\contrato.jasper", parametersContrato, jrResultData);
        rs.close();                                                  // ./relatorios/contrato.jasper     

        return jp;
    }

    private static Contrato populaContratos(ResultSet rs) throws SQLException {

        Contrato contrato = new Contrato();

        LocadorDAO locadorDao = new LocadorDAO();
        LocatarioDAO locatarioDao = new LocatarioDAO();

        contrato.setCodigo(rs.getInt("contr_cod"));
        contrato.setLocador(locadorDao.seleciona(rs.getInt("locad_cod")));
        contrato.setLocatario(locatarioDao.seleciona(rs.getInt("locat_cod")));
        contrato.setNumero(rs.getString("contr_numero"));
        contrato.setDescricao(rs.getString("contr_descricao"));
        contrato.setMensalidade(rs.getDouble("contr_mensalidade"));
        contrato.setPrazo(rs.getInt("contr_prazo"));
        contrato.setDataInicial(rs.getDate("contr_data_inicial"));
        contrato.setDataFinal(rs.getDate("contr_data_final"));

        return contrato;
    }
    
    public boolean isCarneAtivoContrato(int codContrato) throws SQLException {
        boolean retorno = false;
        ResultSet rs = executaQuery("SELECT MAX(carne_cod) FROM carne WHERE contr_cod=?", codContrato);
        if (rs.next()) {
            if (rs.getObject("max") != null) {
                retorno = true;
            }
        }
        rs.close();
        return retorno;
    }
}
