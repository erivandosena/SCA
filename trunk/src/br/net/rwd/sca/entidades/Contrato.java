/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.entidades;

import br.net.rwd.sca.util.ColunaSwing;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Erivando
 */
public class Contrato implements Serializable {

    private Integer codigo;
    @ColunaSwing(descricao="Número")
    private String numero;
    @ColunaSwing(descricao="Descrição")
    private String descricao;
    @ColunaSwing(descricao="Valor R$")
    private double mensalidade;
    @ColunaSwing(descricao="Prazo")
    private int prazo;
    private Date dataInicial;
    private Date dataFinal;
    private Locador locador;
    private Locatario locatario;

    public Contrato() {
    }

    public Contrato(Integer codigo) {
        this.codigo = codigo;
    }

    public Contrato(Integer codigo, String numero, String descricao, double mensalidade, int prazo, Date dataInicial, Date dataFinal, Locador locador, Locatario locatario) {
        this.codigo = codigo;
        this.numero = numero;
        this.descricao = descricao;
        this.mensalidade = mensalidade;
        this.prazo = prazo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.locador = locador;
        this.locatario = locatario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contrato other = (Contrato) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return getNumero()+"  "+getLocatario().getNome()+ " ("+ getPrazo()+  " Mensalidades "+ String.format("R$%.2f", getMensalidade())+")";
    }
}
