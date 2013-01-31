/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Erivando
 */
@Entity(name = "locador")
public class Locador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "locad_cod", nullable = false)
    private Integer codigo;
    @Column(name = "locad_nome")
    private String nome;
    @Column(name = "locad_rg")
    private String rg;
    @Column(name = "locad_cpf")
    private String cpf;
    @Column(name = "locad_estado_civil")
    private String estadoCivil;
    @Column(name = "locad_profissao")
    private String profissao;
    @Column(name = "locad_nacionalidade")
    private String nacionalidade;
    @Column(name = "locad_endereco")
    private String endereco;
    @Column(name = "locad_num_endereco")
    private String numEndereco;
    @Column(name = "locad_bairro")
    private String bairro;
    @Column(name = "locad_cep")
    private String cep;
    @Column(name = "locad_cidade")
    private String cidade;
    @Column(name = "locad_uf")
    private String uf;
    @OneToMany(mappedBy="locador",cascade= CascadeType.ALL, orphanRemoval=true)
    private List<Contrato> contratos = new LinkedList<Contrato>();

    public Locador() {
    }

    public Locador(Integer codigo) {
        this.codigo = codigo;
    }

    public Locador(Integer codigo, String nome, String rg, String cpf, String estadoCivil, String profissao, String nacionalidade, String endereco, String numEndereco, String bairro, String cep, String cidade, String uf) {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
        this.nacionalidade = nacionalidade;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(String numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locador other = (Locador) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
