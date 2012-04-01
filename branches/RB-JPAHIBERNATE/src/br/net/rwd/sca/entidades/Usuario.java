/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.entidades;

import br.net.rwd.sca.util.ColunaSwing;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Erivando
 */
@Entity(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "usua_cod", nullable = false)
    private Integer codigo;
    @Column(name = "usua_nome")
    @ColunaSwing(descricao = "Nome", renderizador = DefaultTableCellRenderer.class, corDeFundo = "")
    private String nome;
    @Column(name = "usua_login")
    @ColunaSwing(descricao = "Login", renderizador = DefaultTableCellRenderer.class, corDeFundo = "")
    private String login;
    @Column(name = "usua_senha")
    private String senha;

    public Usuario() {
    }

    public Usuario(Integer codigo) {
        this.codigo = codigo;
    }

    public Usuario(Integer codigo, String nome, String login, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void fazerLogin() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
}
