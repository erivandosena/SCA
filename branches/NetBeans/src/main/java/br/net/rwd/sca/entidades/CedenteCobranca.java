/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Administrador
 */

@Entity(name = "cedente")
public class CedenteCobranca implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ceden_cod", nullable = false)
    private Integer ceden_cod; 
    private String ceden_nome; 
    private String ceden_cpfcnpj; 
    private String ceden_agencia; 
    private String ceden_operacao; 
    private String ceden_conta; 
    private String ceden_nossonumero; 
    private String ceden_especie; 
    private String ceden_moeda; 
    private String ceden_aceite; 
    private String ceden_tipo;
    private String ceden_modalidade;
    private String ceden_emissao_bloq;
    private float ceden_multa; 
    private int ceden_multa_dias; 
    private float ceden_descontos; 
    private int ceden_descontos_dia; 
    private float ceden_juros; 
    private boolean ceden_avalista; 
    private String ceden_msg_sacado; 
    private String ceden_msg1; 
    private String ceden_msg2; 
    private String ceden_msg3; 
    private String ceden_msg4; 

    public CedenteCobranca() {
    }

    public CedenteCobranca(Integer ceden_cod) {
        this.ceden_cod = ceden_cod;
    }

    public CedenteCobranca(Integer ceden_cod, String ceden_nome, String ceden_cpfcnpj, String ceden_agencia, String ceden_operacao, String ceden_conta, String ceden_nossonumero, String ceden_especie, String ceden_moeda, String ceden_aceite, String ceden_tipo, String ceden_modalidade, String ceden_emissao_bloq, float ceden_multa, int ceden_multa_dias, float ceden_descontos, int ceden_descontos_dia, float ceden_juros, boolean ceden_avalista, String ceden_msg_sacado, String ceden_msg1, String ceden_msg2, String ceden_msg3, String ceden_msg4) {
        this.ceden_cod = ceden_cod;
        this.ceden_nome = ceden_nome;
        this.ceden_cpfcnpj = ceden_cpfcnpj;
        this.ceden_agencia = ceden_agencia;
        this.ceden_operacao = ceden_operacao;
        this.ceden_conta = ceden_conta;
        this.ceden_nossonumero = ceden_nossonumero;
        this.ceden_especie = ceden_especie;
        this.ceden_moeda = ceden_moeda;
        this.ceden_aceite = ceden_aceite;
        this.ceden_tipo = ceden_tipo;
        this.ceden_modalidade = ceden_modalidade;
        this.ceden_emissao_bloq = ceden_emissao_bloq;
        this.ceden_multa = ceden_multa;
        this.ceden_multa_dias = ceden_multa_dias;
        this.ceden_descontos = ceden_descontos;
        this.ceden_descontos_dia = ceden_descontos_dia;
        this.ceden_juros = ceden_juros;
        this.ceden_avalista = ceden_avalista;
        this.ceden_msg_sacado = ceden_msg_sacado;
        this.ceden_msg1 = ceden_msg1;
        this.ceden_msg2 = ceden_msg2;
        this.ceden_msg3 = ceden_msg3;
        this.ceden_msg4 = ceden_msg4;
    }

    public String getCeden_aceite() {
        return ceden_aceite;
    }

    public void setCeden_aceite(String ceden_aceite) {
        this.ceden_aceite = ceden_aceite;
    }

    public String getCeden_agencia() {
        return ceden_agencia;
    }

    public void setCeden_agencia(String ceden_agencia) {
        this.ceden_agencia = ceden_agencia;
    }

    public boolean isCeden_avalista() {
        return ceden_avalista;
    }

    public void setCeden_avalista(boolean ceden_avalista) {
        this.ceden_avalista = ceden_avalista;
    }

    public Integer getCeden_cod() {
        return ceden_cod;
    }

    public void setCeden_cod(Integer ceden_cod) {
        this.ceden_cod = ceden_cod;
    }

    public String getCeden_conta() {
        return ceden_conta;
    }

    public void setCeden_conta(String ceden_conta) {
        this.ceden_conta = ceden_conta;
    }

    public String getCeden_cpfcnpj() {
        return ceden_cpfcnpj;
    }

    public void setCeden_cpfcnpj(String ceden_cpfcnpj) {
        this.ceden_cpfcnpj = ceden_cpfcnpj;
    }

    public float getCeden_descontos() {
        return ceden_descontos;
    }

    public void setCeden_descontos(float ceden_descontos) {
        this.ceden_descontos = ceden_descontos;
    }

    public int getCeden_descontos_dia() {
        return ceden_descontos_dia;
    }

    public void setCeden_descontos_dia(int ceden_descontos_dia) {
        this.ceden_descontos_dia = ceden_descontos_dia;
    }

    public String getCeden_emissao_bloq() {
        return ceden_emissao_bloq;
    }

    public void setCeden_emissao_bloq(String ceden_emissao_bloq) {
        this.ceden_emissao_bloq = ceden_emissao_bloq;
    }

    public String getCeden_especie() {
        return ceden_especie;
    }

    public void setCeden_especie(String ceden_especie) {
        this.ceden_especie = ceden_especie;
    }

    public float getCeden_juros() {
        return ceden_juros;
    }

    public void setCeden_juros(float ceden_juros) {
        this.ceden_juros = ceden_juros;
    }

    public String getCeden_modalidade() {
        return ceden_modalidade;
    }

    public void setCeden_modalidade(String ceden_modalidade) {
        this.ceden_modalidade = ceden_modalidade;
    }

    public String getCeden_moeda() {
        return ceden_moeda;
    }

    public void setCeden_moeda(String ceden_moeda) {
        this.ceden_moeda = ceden_moeda;
    }

    public String getCeden_msg1() {
        return ceden_msg1;
    }

    public void setCeden_msg1(String ceden_msg1) {
        this.ceden_msg1 = ceden_msg1;
    }

    public String getCeden_msg2() {
        return ceden_msg2;
    }

    public void setCeden_msg2(String ceden_msg2) {
        this.ceden_msg2 = ceden_msg2;
    }

    public String getCeden_msg3() {
        return ceden_msg3;
    }

    public void setCeden_msg3(String ceden_msg3) {
        this.ceden_msg3 = ceden_msg3;
    }

    public String getCeden_msg4() {
        return ceden_msg4;
    }

    public void setCeden_msg4(String ceden_msg4) {
        this.ceden_msg4 = ceden_msg4;
    }

    public String getCeden_msg_sacado() {
        return ceden_msg_sacado;
    }

    public void setCeden_msg_sacado(String ceden_msg_sacado) {
        this.ceden_msg_sacado = ceden_msg_sacado;
    }

    public float getCeden_multa() {
        return ceden_multa;
    }

    public void setCeden_multa(float ceden_multa) {
        this.ceden_multa = ceden_multa;
    }

    public int getCeden_multa_dias() {
        return ceden_multa_dias;
    }

    public void setCeden_multa_dias(int ceden_multa_dias) {
        this.ceden_multa_dias = ceden_multa_dias;
    }

    public String getCeden_nome() {
        return ceden_nome;
    }

    public void setCeden_nome(String ceden_nome) {
        this.ceden_nome = ceden_nome;
    }

    public String getCeden_nossonumero() {
        return ceden_nossonumero;
    }

    public void setCeden_nossonumero(String ceden_nossonumero) {
        this.ceden_nossonumero = ceden_nossonumero;
    }

    public String getCeden_operacao() {
        return ceden_operacao;
    }

    public void setCeden_operacao(String ceden_operacao) {
        this.ceden_operacao = ceden_operacao;
    }

    public String getCeden_tipo() {
        return ceden_tipo;
    }

    public void setCeden_tipo(String ceden_tipo) {
        this.ceden_tipo = ceden_tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CedenteCobranca other = (CedenteCobranca) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.ceden_cod != null ? this.ceden_cod.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return ceden_nome;
    }
    
}
