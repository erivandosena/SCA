/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * formAdicionaUsuario.java
 *
 * Created on 19/01/2012, 16:42:57
 */
package br.net.rwd.sca.frames;

import br.net.rwd.sca.dao.LocadorDAO;
import br.net.rwd.sca.entidades.Locador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erivando
 */
public class formLocador extends javax.swing.JDialog {

    private final LocadorDAO dao;
    private Locador alteraLocador;

    public formLocador(java.awt.Frame parent, boolean modal, LocadorDAO dao, Locador locador) {
        super(parent, modal);
        this.dao = dao;
        this.alteraLocador = locador;
        initComponents();
        carregaDadosLocador();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldRg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldProfissao = new javax.swing.JTextField();
        jTextFieldNacinalidade = new javax.swing.JTextField();
        jTextFieldEstCivil = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldNum = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldCep = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldUf = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adiciona Locador");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nome");

        jLabel2.setText("RG");

        jLabel3.setText("CPF");

        jLabel4.setText("Estado Civil");

        jLabel5.setText("Profissão");

        jLabel6.setText("Nacionalidade");

        jLabel7.setText("Endereço");

        jLabel8.setText("Número");

        jLabel9.setText("Bairro");

        jLabel10.setText("CEP");

        jLabel11.setText("Cidade");

        jLabel12.setText("UF");

        jTextFieldEstCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEstCivilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldEstCivil)
                                    .addComponent(jTextFieldRg, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldBairro)
                                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldUf, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldNacinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldEstCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNacinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirma.png"))); // NOI18N
        jButtonConfirmar.setText("Salvar");
        jButtonConfirmar.setPreferredSize(new java.awt.Dimension(150, 50));
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(150, 50));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setPreferredSize(new java.awt.Dimension(150, 50));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-640)/2, (screenSize.height-351)/2, 640, 351);
    }// </editor-fold>//GEN-END:initComponents

private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    setVisible(false);
}//GEN-LAST:event_jButtonCancelarActionPerformed

private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed

    if (jTextFieldNome.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o nome corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldRg.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o rg corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldCpf.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o cpf corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldEstCivil.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o estado civil corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldProfissao.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome a profissão corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldNacinalidade.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome a nacionalidade corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldEndereco.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o endereço corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldNum.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o número corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldBairro.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o bairro corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldCep.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o cep corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldCidade.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome a cidade corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextFieldUf.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o uf corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        if (alteraLocador == null) {
            Locador insereLocador = new Locador();
            insereLocador.setNome(jTextFieldNome.getText().toUpperCase());
            insereLocador.setRg(jTextFieldRg.getText());
            insereLocador.setCpf(jTextFieldCpf.getText());
            insereLocador.setEstadoCivil(jTextFieldEstCivil.getText().toUpperCase());
            insereLocador.setProfissao(jTextFieldProfissao.getText().toUpperCase());
            insereLocador.setNacionalidade(jTextFieldNacinalidade.getText().toUpperCase());
            insereLocador.setEndereco(jTextFieldEndereco.getText().toUpperCase());
            insereLocador.setNumEndereco(jTextFieldNum.getText().toUpperCase());
            insereLocador.setBairro(jTextFieldBairro.getText().toUpperCase());
            insereLocador.setCep(jTextFieldCep.getText());
            insereLocador.setCidade(jTextFieldCidade.getText().toUpperCase());
            insereLocador.setUf(jTextFieldUf.getText().toUpperCase());
            dao.adiciona(insereLocador);
        } else {
            alteraLocador.setNome(jTextFieldNome.getText().toUpperCase());
            alteraLocador.setRg(jTextFieldRg.getText());
            alteraLocador.setCpf(jTextFieldCpf.getText());
            alteraLocador.setEstadoCivil(jTextFieldEstCivil.getText().toUpperCase());
            alteraLocador.setProfissao(jTextFieldProfissao.getText().toUpperCase());
            alteraLocador.setNacionalidade(jTextFieldNacinalidade.getText().toUpperCase());
            alteraLocador.setEndereco(jTextFieldEndereco.getText().toUpperCase());
            alteraLocador.setNumEndereco(jTextFieldNum.getText().toUpperCase());
            alteraLocador.setBairro(jTextFieldBairro.getText().toUpperCase());
            alteraLocador.setCep(jTextFieldCep.getText());
            alteraLocador.setCidade(jTextFieldCidade.getText().toUpperCase());
            alteraLocador.setUf(jTextFieldUf.getText().toUpperCase());
            dao.atualiza(alteraLocador);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(formLocador.class.getName()).log(Level.SEVERE, null, ex);
    }
    carregaDadosLocador();

}//GEN-LAST:event_jButtonConfirmarActionPerformed

private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
    if (alteraLocador == null) {
        JOptionPane.showMessageDialog(this, "Não existe registro para excluir!");
        return;
    }

    int resultado = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?\nTodas as outras informações dependentes deste cadastro também serão excluídas!", "Exclui", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (resultado == 0) {
        int codLocador = alteraLocador.getCodigo();

        /*
        if (dao.isContratoAtivoLocador(codLocador)) {
            JOptionPane.showMessageDialog(this, "Locador possui contrato(s).", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         * 
         */

        dao.remove(codLocador);

        setVisible(false);
    }

}//GEN-LAST:event_jButtonExcluirActionPerformed

private void jTextFieldEstCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEstCivilActionPerformed
}//GEN-LAST:event_jTextFieldEstCivilActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldEstCivil;
    private javax.swing.JTextField jTextFieldNacinalidade;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNum;
    private javax.swing.JTextField jTextFieldProfissao;
    private javax.swing.JTextField jTextFieldRg;
    private javax.swing.JTextField jTextFieldUf;
    // End of variables declaration//GEN-END:variables

    private void carregaDadosLocador() {

        alteraLocador = dao.seleciona(1);

        if (alteraLocador != null) {
            jTextFieldNome.setText(alteraLocador.getNome());
            jTextFieldRg.setText(alteraLocador.getRg());
            jTextFieldCpf.setText(alteraLocador.getCpf());
            jTextFieldEstCivil.setText(alteraLocador.getEstadoCivil());
            jTextFieldProfissao.setText(alteraLocador.getProfissao());
            jTextFieldNacinalidade.setText(alteraLocador.getNacionalidade());
            jTextFieldEndereco.setText(alteraLocador.getEndereco());
            jTextFieldNum.setText(alteraLocador.getNumEndereco());
            jTextFieldBairro.setText(alteraLocador.getBairro());
            jTextFieldCep.setText(alteraLocador.getCep());
            jTextFieldCidade.setText(alteraLocador.getCidade());
            jTextFieldUf.setText(alteraLocador.getUf());
        }

    }
}
