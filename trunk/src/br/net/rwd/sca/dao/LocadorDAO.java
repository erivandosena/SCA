/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Locador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Erivando
 */
public class LocadorDAO extends DAOGenerico {

    public LocadorDAO() {
    }

    public int adiciona(Locador locador) throws SQLException {
        locador.setCodigo(obtemProximoCod("locador", "locad_cod"));
        String consulta = "INSERT INTO locador (locad_cod, locad_nome, locad_rg, locad_cpf, locad_estado_civil, locad_profissao, locad_nacionalidade, locad_endereco, locad_num_endereco, locad_bairro, locad_cep, locad_cidade, locad_uf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executaCommand(consulta,
                locador.getCodigo(),
                locador.getNome(),
                locador.getRg(),
                locador.getCpf(),
                locador.getEstadoCivil(),
                locador.getProfissao(),
                locador.getNacionalidade(),
                locador.getEndereco(),
                locador.getNumEndereco(),
                locador.getBairro(),
                locador.getCep(),
                locador.getCidade(),
                locador.getUf());

        return locador.getCodigo();
    }

    public void atualiza(Locador locador) throws SQLException {
        String consulta = "UPDATE locador SET locad_nome=?, locad_rg=?, locad_cpf=?, locad_estado_civil=?, locad_profissao=?, locad_nacionalidade=?, locad_endereco=?, locad_num_endereco=?, locad_bairro=?, locad_cep=?, locad_cidade=?, locad_uf=? WHERE locad_cod=?";
        executaCommand(consulta,
                locador.getNome(),
                locador.getRg(),
                locador.getCpf(),
                locador.getEstadoCivil(),
                locador.getProfissao(),
                locador.getNacionalidade(),
                locador.getEndereco(),
                locador.getNumEndereco(),
                locador.getBairro(),
                locador.getCep(),
                locador.getCidade(),
                locador.getUf(),
                locador.getCodigo());
    }

    public void remove(int codLocador) throws SQLException {
        executaCommand("DELETE from locador WHERE locad_cod = ?", codLocador);
    }

    public Locador seleciona(int codLocador) throws SQLException {
        ResultSet rs = executaQuery("SELECT locad_cod, locad_nome, locad_rg, locad_cpf, locad_estado_civil, locad_profissao, locad_nacionalidade, locad_endereco, locad_num_endereco, locad_bairro, locad_cep, locad_cidade, locad_uf FROM locador WHERE locad_cod=?", codLocador);
        Locador locador = null;
        if (rs.next()) {
            locador = populaLocador(rs);
        }
        rs.close();

        return locador;
    }

    public Locador seleciona() throws SQLException {
        ResultSet rs = executaQuery("SELECT locad_cod, locad_nome, locad_rg, locad_cpf, locad_estado_civil, locad_profissao, locad_nacionalidade, locad_endereco, locad_num_endereco, locad_bairro, locad_cep, locad_cidade, locad_uf FROM locador");
        Locador locador = null;
        if (rs.next()) {
            locador = populaLocador(rs);
        }
        rs.close();

        return locador;
    }

    public List<Locador> selecionaLocador() throws SQLException {
        ResultSet rs = executaQuery("SELECT locad_cod, locad_nome, locad_rg, locad_cpf, locad_estado_civil, locad_profissao, locad_nacionalidade, locad_endereco, locad_num_endereco, locad_bairro, locad_cep, locad_cidade, locad_uf FROM locador");
        List<Locador> Locador = new LinkedList<Locador>();
        while (rs.next()) {
            Locador.add(populaLocador(rs));
        }
        rs.close();

        return Locador;
    }

    private static Locador populaLocador(ResultSet rs) throws SQLException {
        Locador locador = new Locador();

        locador.setCodigo(rs.getInt("locad_cod"));
        locador.setNome(rs.getString("locad_nome"));
        locador.setRg(rs.getString("locad_rg"));
        locador.setCpf(rs.getString("locad_cpf"));
        locador.setEstadoCivil(rs.getString("locad_estado_civil"));
        locador.setProfissao(rs.getString("locad_profissao"));
        locador.setNacionalidade(rs.getString("locad_nacionalidade"));
        locador.setEndereco(rs.getString("locad_endereco"));
        locador.setNumEndereco(rs.getString("locad_num_endereco"));
        locador.setBairro(rs.getString("locad_bairro"));
        locador.setCep(rs.getString("locad_cep"));
        locador.setCidade(rs.getString("locad_cidade"));
        locador.setUf(rs.getString("locad_uf"));

        return locador;
    }

    public boolean isContratoAtivoLocador(int codLocador) throws SQLException {
        boolean retorno = false;
        ResultSet rs = executaQuery("SELECT MAX(contr_cod) FROM contrato WHERE locad_cod=?", codLocador);
        if (rs.next()) {
            if (rs.getObject("max") != null) {
                retorno = true;
            }
        }
        rs.close();
        return retorno;
    }
}
