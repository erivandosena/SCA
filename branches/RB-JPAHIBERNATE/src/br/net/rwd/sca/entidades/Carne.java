/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.entidades;

import br.net.rwd.sca.util.ColunaSwing;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Erivando
 */
@Entity(name = "carne")
public class Carne implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "carne_cod", nullable = false)
    private Integer codigo;
    @ManyToOne
    @JoinColumn(name = "contr_cod")
    @ColunaSwing(descricao="Contrato/Carnê")
    private Contrato contrato;
    @Column(name = "carne_observacao")
    private String observacao;
    @OneToMany(mappedBy="carne",cascade= CascadeType.ALL, orphanRemoval=true)
    private List<Mensalidade> mensalidades = new LinkedList<Mensalidade>();

    public Carne() {
    }

    public Carne(Integer codigo) {
        this.codigo = codigo;
    }

    public Carne(Integer codigo, Contrato contrato, String observacao) {
        this.codigo = codigo;
        this.contrato = contrato;
        this.observacao = observacao;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
