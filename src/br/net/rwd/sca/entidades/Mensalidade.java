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
public class Mensalidade implements Serializable {

    private Integer codigo;
    @ColunaSwing(descricao="Valor R$")
    private double valor;
    @ColunaSwing(descricao="Vencimento")
    private Date vencimento;
    @ColunaSwing(descricao="Mensalidade")
    private String numero;
    private String observacao;
    public Carne carne;

    public Mensalidade() {
    }

    public Mensalidade(Integer codigo) {
        this.codigo = codigo;
    }

    public Mensalidade(Integer codigo, double valor, Date vencimento, String numero, String observacao, Carne carne) {
        this.codigo = codigo;
        this.valor = valor;
        this.vencimento = vencimento;
        this.numero = numero;
        this.observacao = observacao;
        this.carne = carne;
    }

    public Carne getCarne() {
        return carne;
    }

    public void setCarne(Carne carne) {
        this.carne = carne;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensalidade other = (Mensalidade) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
    
}
