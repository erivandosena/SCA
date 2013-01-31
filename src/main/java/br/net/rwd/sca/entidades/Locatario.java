
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.entidades;

import br.net.rwd.sca.util.ColunaSwing;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Erivando
 */
@Entity(name = "locatario")
public class Locatario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "locat_cod", nullable = false)
    private Integer codigo;
    @Temporal(TemporalType.DATE)
    @Column(name = "locat_data_cadastro")
    @ColunaSwing(descricao="Cadastrado")
    private Date dataCadastro;
    @Column(name = "locat_nome")
    @ColunaSwing(descricao="Nome")
    private String nome;
    @Column(name = "locat_rg")
    private String rg;
    @Column(name = "locat_cpf")
    @ColunaSwing(descricao="CPF")
    private String cpf;
    @Column(name = "locat_estado_civil")
    private String estadoCivil;
    @Column(name = "locat_profissao")
    private String profissao;
    @Column(name = "locat_nacionalidade")
    private String nacionalidade;
    @Column(name = "locat_endereco")
    private String endereco;
    @Column(name = "locat_num_endereco")
    private String numEndereco;
    @Column(name = "locat_bairro")
    private String bairro;
    @Column(name = "locat_cep")
    private String cep;
    @Column(name = "locat_cidade")
    private String cidade;
    @Column(name = "locat_uf")
    private String uf;
    @Column(name = "locat_telefone")
    private String telefone;
    @Column(name = "locat_status")
    private boolean status;
    @OneToMany(mappedBy="locatario",cascade= CascadeType.ALL, orphanRemoval=true)
    private List<Contrato> contratos = new LinkedList<Contrato>();

    public Locatario() {
    }

    public Locatario(Integer codigo) {
        this.codigo = codigo;
    }

    public Locatario(Integer codigo, Date dataCadastro, String nome, String rg, String cpf, String estadoCivil, String profissao, String nacionalidade, String endereco, String numEndereco, String bairro, String cep, String cidade, String uf, String telefone, boolean status) {
        this.codigo = codigo;
        this.dataCadastro = dataCadastro;
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
        this.telefone = telefone;
        this.status = status;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locatario other = (Locatario) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return getNome();
    }

}
