/*
 * To change this template; choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.jasper;

import br.net.rwd.sca.jpa.JpaUtilPattern;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Administrador
 */
public class RelatorioContrato {

    private String contr_numero;
    private String contr_descricao;
    private Double contr_mensalidade;
    private Integer contr_prazo;
    private Date contr_data_inicial;
    private Date contr_data_final;
    private String locat_nome;
    private String locat_rg;
    private String locat_cpf;
    private String locat_estado_civil;
    private String locat_profissao;
    private String locat_nacionalidade;
    private String locat_endereco;
    private String locat_num_endereco;
    private String locat_bairro;
    private String locat_cidade;
    private String locat_uf;
    private String locad_nome;
    private String locad_rg;
    private String locad_cpf;
    private String locad_estado_civil;
    private String locad_profissao;
    private String locad_nacionalidade;
    private String locad_endereco;
    private String locad_num_endereco;
    private String locad_bairro;
    private String locad_cidade;
    private String locad_uf;

    public RelatorioContrato() {
    }

    public Date getContr_data_final() {
        return contr_data_final;
    }

    public void setContr_data_final(Date contr_data_final) {
        this.contr_data_final = contr_data_final;
    }

    public Date getContr_data_inicial() {
        return contr_data_inicial;
    }

    public void setContr_data_inicial(Date contr_data_inicial) {
        this.contr_data_inicial = contr_data_inicial;
    }

    public String getContr_descricao() {
        return contr_descricao;
    }

    public void setContr_descricao(String contr_descricao) {
        this.contr_descricao = contr_descricao;
    }

    public Double getContr_mensalidade() {
        return contr_mensalidade;
    }

    public void setContr_mensalidade(Double contr_mensalidade) {
        this.contr_mensalidade = contr_mensalidade;
    }

    public String getContr_numero() {
        return contr_numero;
    }

    public void setContr_numero(String contr_numero) {
        this.contr_numero = contr_numero;
    }

    public Integer getContr_prazo() {
        return contr_prazo;
    }

    public void setContr_prazo(Integer contr_prazo) {
        this.contr_prazo = contr_prazo;
    }

    public String getLocad_bairro() {
        return locad_bairro;
    }

    public void setLocad_bairro(String locad_bairro) {
        this.locad_bairro = locad_bairro;
    }

    public String getLocad_cidade() {
        return locad_cidade;
    }

    public void setLocad_cidade(String locad_cidade) {
        this.locad_cidade = locad_cidade;
    }

    public String getLocad_cpf() {
        return locad_cpf;
    }

    public void setLocad_cpf(String locad_cpf) {
        this.locad_cpf = locad_cpf;
    }

    public String getLocad_endereco() {
        return locad_endereco;
    }

    public void setLocad_endereco(String locad_endereco) {
        this.locad_endereco = locad_endereco;
    }

    public String getLocad_estado_civil() {
        return locad_estado_civil;
    }

    public void setLocad_estado_civil(String locad_estado_civil) {
        this.locad_estado_civil = locad_estado_civil;
    }

    public String getLocad_nacionalidade() {
        return locad_nacionalidade;
    }

    public void setLocad_nacionalidade(String locad_nacionalidade) {
        this.locad_nacionalidade = locad_nacionalidade;
    }

    public String getLocad_nome() {
        return locad_nome;
    }

    public void setLocad_nome(String locad_nome) {
        this.locad_nome = locad_nome;
    }

    public String getLocad_num_endereco() {
        return locad_num_endereco;
    }

    public void setLocad_num_endereco(String locad_num_endereco) {
        this.locad_num_endereco = locad_num_endereco;
    }

    public String getLocad_profissao() {
        return locad_profissao;
    }

    public void setLocad_profissao(String locad_profissao) {
        this.locad_profissao = locad_profissao;
    }

    public String getLocad_rg() {
        return locad_rg;
    }

    public void setLocad_rg(String locad_rg) {
        this.locad_rg = locad_rg;
    }

    public String getLocad_uf() {
        return locad_uf;
    }

    public void setLocad_uf(String locad_uf) {
        this.locad_uf = locad_uf;
    }

    public String getLocat_bairro() {
        return locat_bairro;
    }

    public void setLocat_bairro(String locat_bairro) {
        this.locat_bairro = locat_bairro;
    }

    public String getLocat_cidade() {
        return locat_cidade;
    }

    public void setLocat_cidade(String locat_cidade) {
        this.locat_cidade = locat_cidade;
    }

    public String getLocat_cpf() {
        return locat_cpf;
    }

    public void setLocat_cpf(String locat_cpf) {
        this.locat_cpf = locat_cpf;
    }

    public String getLocat_endereco() {
        return locat_endereco;
    }

    public void setLocat_endereco(String locat_endereco) {
        this.locat_endereco = locat_endereco;
    }

    public String getLocat_estado_civil() {
        return locat_estado_civil;
    }

    public void setLocat_estado_civil(String locat_estado_civil) {
        this.locat_estado_civil = locat_estado_civil;
    }

    public String getLocat_nacionalidade() {
        return locat_nacionalidade;
    }

    public void setLocat_nacionalidade(String locat_nacionalidade) {
        this.locat_nacionalidade = locat_nacionalidade;
    }

    public String getLocat_nome() {
        return locat_nome;
    }

    public void setLocat_nome(String locat_nome) {
        this.locat_nome = locat_nome;
    }

    public String getLocat_num_endereco() {
        return locat_num_endereco;
    }

    public void setLocat_num_endereco(String locat_num_endereco) {
        this.locat_num_endereco = locat_num_endereco;
    }

    public String getLocat_profissao() {
        return locat_profissao;
    }

    public void setLocat_profissao(String locat_profissao) {
        this.locat_profissao = locat_profissao;
    }

    public String getLocat_rg() {
        return locat_rg;
    }

    public void setLocat_rg(String locat_rg) {
        this.locat_rg = locat_rg;
    }

    public String getLocat_uf() {
        return locat_uf;
    }

    public void setLocat_uf(String locat_uf) {
        this.locat_uf = locat_uf;
    }

    public JasperPrint impprimirContrato(String numContrato) throws JRException {

        String consulta = "SELECT "
                + "contrato.contr_numero,"
                + "contrato.contr_descricao,"
                + "contrato.contr_mensalidade,"
                + "contrato.contr_prazo,"
                + "contrato.contr_data_inicial,"
                + "contrato.contr_data_final,"
                + "locatario.locat_nome,"
                + "locatario.locat_rg,"
                + "locatario.locat_cpf,"
                + "locatario.locat_estado_civil,"
                + "locatario.locat_profissao,"
                + "locatario.locat_nacionalidade,"
                + "locatario.locat_endereco,"
                + "locatario.locat_num_endereco,"
                + "locatario.locat_bairro,"
                + "locatario.locat_cidade,"
                + "locatario.locat_uf,"
                + "locador.locad_nome,"
                + "locador.locad_rg,"
                + "locador.locad_cpf,"
                + "locador.locad_estado_civil,"
                + "locador.locad_profissao,"
                + "locador.locad_nacionalidade,"
                + "locador.locad_endereco,"
                + "locador.locad_num_endereco,"
                + "locador.locad_bairro,"
                + "locador.locad_cidade,"
                + "locador.locad_uf "
                + "FROM locatario "
                + "INNER JOIN contrato ON locatario.locat_cod = contrato.locat_cod "
                + "INNER JOIN locador ON contrato.locad_cod = locador.locad_cod "
                + "WHERE contrato.contr_numero = ?";

        List<RelatorioContrato> listaRel = new ArrayList<RelatorioContrato>();

        for (Object[] row : (List<Object[]>) JpaUtilPattern.getInstancia().executaQuery(consulta, numContrato)) {
            RelatorioContrato rc = new RelatorioContrato();

            rc.setContr_numero(row[0].toString());
            rc.setContr_descricao(row[1].toString());
            rc.setContr_mensalidade(Double.parseDouble(row[2].toString()));
            rc.setContr_prazo(Integer.parseInt(row[3].toString()));
            rc.setContr_data_inicial((Date) row[4]);
            rc.setContr_data_final((Date) row[5]);
            rc.setLocat_nome(row[6].toString());
            rc.setLocat_rg(row[7].toString());
            rc.setLocat_cpf(row[8].toString());
            rc.setLocat_estado_civil(row[9].toString());
            rc.setLocat_profissao(row[10].toString());
            rc.setLocat_nacionalidade(row[11].toString());
            rc.setLocat_endereco(row[12].toString());
            rc.setLocat_num_endereco(row[13].toString());
            rc.setLocat_bairro(row[14].toString());
            rc.setLocat_cidade(row[15].toString());
            rc.setLocat_uf(row[16].toString());
            rc.setLocad_nome(row[17].toString());
            rc.setLocad_rg(row[18].toString());
            rc.setLocad_cpf(row[19].toString());
            rc.setLocad_estado_civil(row[20].toString());
            rc.setLocad_profissao(row[21].toString());
            rc.setLocad_nacionalidade(row[22].toString());
            rc.setLocad_endereco(row[23].toString());
            rc.setLocad_num_endereco(row[24].toString());
            rc.setLocad_bairro(row[25].toString());
            rc.setLocad_cidade(row[26].toString());
            rc.setLocad_uf(row[27].toString());

            listaRel.add(rc);
        }

        //String local = "./relatorios/contrato.jasper";
        InputStream  local = RelatorioMensalidade.class.getClassLoader().getResourceAsStream("relatorios/contrato.jasper"); 

        Map parametros = new HashMap();
        parametros.put("NUMERO_CONTRATO", numContrato);

        JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listaRel);
        JasperPrint jprint = JasperFillManager.fillReport(local, parametros, jrbcds);
        return jprint;
    }
}
