/*
 * To change this template, choose Tools | Templates
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
public class RelatorioMensalidade {

    private double mensa_valor;
    private Date mensa_vencimento;
    private String mensa_numero;
    private String mensa_observacao;
    private String locad_nome;
    private String locat_nome;
    private String locat_cpf;
    private String contr_numero;
    private String contr_descricao;
    private String locad_cidade;
    private String locad_uf;
    private String locat_telefone;

    public RelatorioMensalidade() {
    }

    public String getContr_descricao() {
        return contr_descricao;
    }

    public void setContr_descricao(String contr_descricao) {
        this.contr_descricao = contr_descricao;
    }

    public String getContr_numero() {
        return contr_numero;
    }

    public void setContr_numero(String contr_numero) {
        this.contr_numero = contr_numero;
    }

    public String getLocad_cidade() {
        return locad_cidade;
    }

    public void setLocad_cidade(String locad_cidade) {
        this.locad_cidade = locad_cidade;
    }

    public String getLocad_nome() {
        return locad_nome;
    }

    public void setLocad_nome(String locad_nome) {
        this.locad_nome = locad_nome;
    }

    public String getLocad_uf() {
        return locad_uf;
    }

    public void setLocad_uf(String locad_uf) {
        this.locad_uf = locad_uf;
    }

    public String getLocat_cpf() {
        return locat_cpf;
    }

    public void setLocat_cpf(String locat_cpf) {
        this.locat_cpf = locat_cpf;
    }

    public String getLocat_nome() {
        return locat_nome;
    }

    public void setLocat_nome(String locat_nome) {
        this.locat_nome = locat_nome;
    }

    public String getLocat_telefone() {
        return locat_telefone;
    }

    public void setLocat_telefone(String locat_telefone) {
        this.locat_telefone = locat_telefone;
    }

    public String getMensa_numero() {
        return mensa_numero;
    }

    public void setMensa_numero(String mensa_numero) {
        this.mensa_numero = mensa_numero;
    }

    public String getMensa_observacao() {
        return mensa_observacao;
    }

    public void setMensa_observacao(String mensa_observacao) {
        this.mensa_observacao = mensa_observacao;
    }

    public double getMensa_valor() {
        return mensa_valor;
    }

    public void setMensa_valor(double mensa_valor) {
        this.mensa_valor = mensa_valor;
    }

    public Date getMensa_vencimento() {
        return mensa_vencimento;
    }

    public void setMensa_vencimento(Date mensa_vencimento) {
        this.mensa_vencimento = mensa_vencimento;
    }

    public JasperPrint imprimirMensalidades(int codCarne) throws JRException {

        /*
        String consulta = "SELECT "
                + "mensalidade.mensa_valor,"
                + "mensalidade.mensa_vencimento,"
                + "mensalidade.mensa_numero,"
                + "mensalidade.mensa_observacao,"
                + "locador.locad_nome,"
                + "locatario.locat_nome,"
                + "locatario.locat_cpf,"
                + "contrato.contr_numero,"
                + "contrato.contr_descricao,"
                + "locador.locad_cidade,"
                + "locador.locad_uf,"
                + "locatario.locat_telefone "
                + "FROM "
                + "mensalidade, carne, contrato, locador, locatario "
                + "WHERE "
                + "carne.carne_cod = mensalidade.carne_cod "
                + "AND "
                + "carne.contr_cod = contrato.contr_cod "
                + "AND "
                + "contrato.locad_cod = locador.locad_cod "
                + "AND "
                + "contrato.locat_cod = locatario.locat_cod "
                + "AND "
                + "mensalidade.carne_cod =? "
                + "ORDER BY "
                + "mensalidade.mensa_vencimento ASC";
         * 
         */

        /*
        String consulta = "SELECT "
                + "mensa_valor,"
                + "mensa_vencimento,"
                + "mensa_numero,"
                + "mensa_observacao,"
                + "locad_nome,"
                + "locat_nome,"
                + "locat_cpf,"
                + "contr_numero,"
                + "contr_descricao,"
                + "locad_cidade,"
                + "locad_uf,"
                + "locat_telefone"
                + " FROM "
                + "mensalidade "
                + "INNER JOIN carne ON  carne.carne_cod = mensalidade.carne_cod "
                + "INNER JOIN contrato ON carne.contr_cod = contrato.contr_cod "
                + "INNER JOIN locador ON contrato.locad_cod = locador.locad_cod "
                + "INNER JOIN locatario ON contrato.locat_cod = locatario.locat_cod "
                + "WHERE "
                + "mensalidade.carne_cod = ? "
                + "ORDER BY "
                + "mensalidade.mensa_vencimento ASC";
         * 
         */

        String consulta = "SELECT "
                + "m.valor,"
                + "m.vencimento,"
                + "m.numero,"
                + "m.observacao,"
                + "m.carne.contrato.locador.nome,"
                + "m.carne.contrato.locatario.nome,"
                + "m.carne.contrato.locatario.cpf,"
                + "m.carne.contrato.numero,"
                + "m.carne.contrato.descricao,"
                + "m.carne.contrato.locador.cidade,"
                + "m.carne.contrato.locador.uf,"
                + "m.carne.contrato.locatario.telefone "
                + "FROM mensalidade m WHERE m.carne.codigo = ?1 ORDER BY m.vencimento ASC";
        
        List<RelatorioMensalidade> listaRel = new ArrayList<RelatorioMensalidade>();
        
        for (Object[] row : (List<Object[]>) JpaUtilPattern.getInstancia().executaQueryJpql(consulta, codCarne)) {
            RelatorioMensalidade rm = new RelatorioMensalidade();
            
            rm.setMensa_valor(Double.parseDouble(row[0].toString()));
            rm.setMensa_vencimento((Date) row[1]);
            rm.setMensa_numero(row[2].toString());
            rm.setMensa_observacao(row[3].toString());
            rm.setLocad_nome(row[4].toString());
            rm.setLocat_nome(row[5].toString());
            rm.setLocat_cpf(row[6].toString());
            rm.setContr_numero(row[7].toString());
            rm.setContr_descricao(row[8].toString());
            rm.setLocad_cidade(row[9].toString());
            rm.setLocad_uf(row[10].toString());
            rm.setLocat_telefone(row[11].toString());
            
            listaRel.add(rm);
        }
        

        //String local = System.getProperty("user.dir") + "\\relatorios\\carne.jasper";
        InputStream  local = RelatorioMensalidade.class.getClassLoader().getResourceAsStream("relatorios/carne.jasper");  
        
        Map parametros = new HashMap();
        parametros.put("CODIGO_CARNE", codCarne);

        JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listaRel);
        JasperPrint jprint = JasperFillManager.fillReport(local, parametros, jrbcds);
        return jprint;
    }
}
