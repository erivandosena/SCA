/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.dao;

import br.net.rwd.sca.entidades.Locatario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Erivando
 */
public class LocatarioDAO extends DAOGenerico {

    public LocatarioDAO() {
    }
    
    public int adiciona(Locatario locatario) throws SQLException {
        locatario.setCodigo(obtemProximoCod("locatario", "locat_cod"));
        String consulta = "INSERT INTO locatario (locat_cod, locat_data_cadastro, locat_nome, locat_rg, locat_cpf, locat_estado_civil, locat_profissao, locat_nacionalidade, locat_endereco, locat_num_endereco, locat_bairro, locat_cep, locat_cidade, locat_uf, locat_telefone, locat_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executaCommand(consulta, 
                locatario.getCodigo(),
                locatario.getDataCadastro(),
                locatario.getNome(),
                locatario.getRg(),
                locatario.getCpf(),
                locatario.getEstadoCivil(),
                locatario.getProfissao(),
                locatario.getNacionalidade(),
                locatario.getEndereco(),
                locatario.getNumEndereco(),
                locatario.getBairro(),
                locatario.getCep(),
                locatario.getCidade(),
                locatario.getUf(),
                locatario.getTelefone(),
                locatario.isStatus());
        
        return locatario.getCodigo();
    }
    
    public void atualiza(Locatario locatario) throws SQLException {
        String consulta = "UPDATE locatario SET locat_nome=?, locat_rg=?, locat_cpf=?, locat_estado_civil=?, locat_profissao=?, locat_nacionalidade=?, locat_endereco=?, locat_num_endereco=?, locat_bairro=?, locat_cep=?, locat_cidade=?, locat_uf=?, locat_telefone=?, locat_status=? WHERE locat_cod=?";
        executaCommand(consulta, 
                locatario.getNome(),
                locatario.getRg(),
                locatario.getCpf(),
                locatario.getEstadoCivil(),
                locatario.getProfissao(),
                locatario.getNacionalidade(),
                locatario.getEndereco(),
                locatario.getNumEndereco(),
                locatario.getBairro(),
                locatario.getCep(),
                locatario.getCidade(),
                locatario.getUf(),
                locatario.getTelefone(),
                locatario.isStatus(),
                locatario.getCodigo());
    }
    
    public void remove(int codLocatario) throws SQLException {
        executaCommand("DELETE from locatario WHERE locat_cod = ?", codLocatario);
    }
    
    public Locatario seleciona(int codLocatario) throws SQLException {
        ResultSet rs = executaQuery("SELECT locat_cod, locat_data_cadastro, locat_nome, locat_rg, locat_cpf, locat_estado_civil, locat_profissao, locat_nacionalidade, locat_endereco, locat_num_endereco, locat_bairro, locat_cep, locat_cidade, locat_uf, locat_telefone, locat_status FROM locatario WHERE locat_cod = ?", codLocatario);
        Locatario locatarios = null;
        if(rs.next()) {
            locatarios = populaLocatarios(rs);
        }
        rs.close();
        
        return locatarios;
    }
    
    public List<Locatario> selecionaTodosPorNome(String nome) throws SQLException {
        ResultSet rs = executaQuery("SELECT locat_cod, locat_data_cadastro, locat_nome, locat_rg, locat_cpf, locat_estado_civil, locat_profissao, locat_nacionalidade, locat_endereco, locat_num_endereco, locat_bairro, locat_cep, locat_cidade, locat_uf, locat_telefone, locat_status FROM locatario WHERE locat_status = 'true' AND locat_nome ILIKE ? ORDER BY locat_nome ASC", "%"+nome+"%");
        List<Locatario> locatarios = new LinkedList<Locatario>();
        while (rs.next()) {
            locatarios.add(populaLocatarios(rs));
        }
        rs.close();

        return locatarios;
    }
    
    public List<Locatario> selecionaTodos() throws SQLException {
        ResultSet rs = executaQuery("SELECT locat_cod, locat_data_cadastro, locat_nome, locat_rg, locat_cpf, locat_estado_civil, locat_profissao, locat_nacionalidade, locat_endereco, locat_num_endereco, locat_bairro, locat_cep, locat_cidade, locat_uf, locat_telefone, locat_status FROM locatario ORDER BY locat_nome ASC");
        List<Locatario> locatarios = new LinkedList<Locatario>();
        while (rs.next()) {
            locatarios.add(populaLocatarios(rs));
        }
        rs.close();
        
        return locatarios;
    }

    private static Locatario populaLocatarios(ResultSet rs) throws SQLException {
        
        Locatario locatario = new Locatario();
        
        locatario.setCodigo(rs.getInt("locat_cod"));
        locatario.setDataCadastro(rs.getDate("locat_data_cadastro"));
        locatario.setNome(rs.getString("locat_nome"));
        locatario.setRg(rs.getString("locat_rg"));
        locatario.setCpf(rs.getString("locat_cpf"));
        locatario.setEstadoCivil(rs.getString("locat_estado_civil"));
        locatario.setProfissao(rs.getString("locat_profissao"));
        locatario.setNacionalidade(rs.getString("locat_nacionalidade"));
        locatario.setEndereco(rs.getString("locat_endereco"));
        locatario.setNumEndereco(rs.getString("locat_num_endereco"));
        locatario.setBairro(rs.getString("locat_bairro"));
        locatario.setCep(rs.getString("locat_cep"));
        locatario.setCidade(rs.getString("locat_cidade"));
        locatario.setUf(rs.getString("locat_uf"));
        locatario.setTelefone(rs.getString("locat_telefone"));
        locatario.setStatus(rs.getBoolean("locat_status"));
        
        return locatario;
    }
    
    public boolean isContratoAtivoLocatario(int codLocatario) throws SQLException {
        boolean retorno = false;
        ResultSet rs = executaQuery("SELECT MAX(contr_cod) FROM contrato WHERE locat_cod=?", codLocatario);
        if (rs.next()) {
            if (rs.getObject("max") != null) {
                retorno = true;
            }
        }
        rs.close();
        return retorno;
    }
}
