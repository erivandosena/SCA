/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.entidades;

import br.net.rwd.sca.util.ColunaSwing;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Erivando
 */
public class Carne implements Serializable {

    private Integer codigo;
    @ColunaSwing(descricao="Contrato/Carnê")
    private Contrato contrato;
    private List<Mensalidade> mensalidades = new LinkedList<Mensalidade>();

    public Carne() {
    }

    public Carne(Integer codigo) {
        this.codigo = codigo;
    }

    public Carne(Integer codigo, Contrato contrato) {
        this.codigo = codigo;
        this.contrato = contrato;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public List<Mensalidade> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carne other = (Carne) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
    
}
