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

import br.net.rwd.sca.dao.LocatarioDAO;
import br.net.rwd.sca.entidades.Locatario;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erivando
 */
public class formAdicionaLocatario extends javax.swing.JDialog {

    public final LocatarioDAO dao;
    private final formLocatario controle;

    public formAdicionaLocatario(java.awt.Frame parent, boolean modal, LocatarioDAO dao, formLocatario controle) {
        super(parent, modal);
        this.dao = dao;
        this.controle = controle;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldRg = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
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
        jRadioButtonStatus1 = new javax.swing.JRadioButton();
        jRadioButtonStatus2 = new javax.swing.JRadioButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adiciona Locatário");
        setResizable(false);

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirma.png"))); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setText("Nome");

        jLabel38.setText("RG");

        jLabel39.setText("CPF");

        jLabel40.setText("Estado Civil");

        jLabel41.setText("Profissão");

        jLabel42.setText("Nacionalidade");

        jLabel43.setText("Endereço");

        jLabel44.setText("Número");

        jLabel45.setText("Bairro");

        jLabel46.setText("CEP");

        jLabel47.setText("Cidade");

        jLabel48.setText("UF");

        jTextFieldEstCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEstCivilActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonStatus1);
        jRadioButtonStatus1.setText("Ativo");

        buttonGroup1.add(jRadioButtonStatus2);
        jRadioButtonStatus2.setText("Inativo");

        jLabel49.setText("Status");

        jLabel50.setText("Telefone");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldEstCivil)
                                    .addComponent(jTextFieldRg, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)))
                    .addComponent(jLabel40)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel49)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jRadioButtonStatus1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonStatus2))
                                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldUf, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldCep)
                                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                            .addComponent(jTextFieldNacinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextFieldEstCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextFieldNacinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(jTextFieldUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonStatus1)
                    .addComponent(jLabel49)
                    .addComponent(jRadioButtonStatus2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-640)/2, (screenSize.height-376)/2, 640, 376);
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

    if (buttonGroup1.getSelection() == null) {
        JOptionPane.showMessageDialog(this, "Infome o status corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Locatario locatario = new Locatario();
    locatario.setDataCadastro(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
    locatario.setNome(jTextFieldNome.getText().toUpperCase());
    locatario.setRg(jTextFieldRg.getText());
    locatario.setCpf(jTextFieldCpf.getText());
    locatario.setEstadoCivil(jTextFieldEstCivil.getText().toUpperCase());
    locatario.setProfissao(jTextFieldProfissao.getText().toUpperCase());
    locatario.setNacionalidade(jTextFieldNacinalidade.getText().toUpperCase());
    locatario.setEndereco(jTextFieldEndereco.getText().toUpperCase());
    locatario.setNumEndereco(jTextFieldNum.getText().toUpperCase());
    locatario.setBairro(jTextFieldBairro.getText().toUpperCase());
    locatario.setCep(jTextFieldCep.getText());
    locatario.setCidade(jTextFieldCidade.getText().toUpperCase());
    locatario.setUf(jTextFieldUf.getText().toUpperCase());
    locatario.setTelefone(jTextFieldTelefone.getText());

    Boolean status = jRadioButtonStatus1.isSelected();
    if (jRadioButtonStatus2.isSelected()) {
        status = false;
    } else {
        status = true;
    }

    locatario.setStatus(status);

    try {
        dao.adiciona(locatario);
        this.controle.carregaDadosIniciais();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(formAdicionaLocatario.class.getName()).log(Level.SEVERE, null, ex);
    }
    setVisible(false);

}//GEN-LAST:event_jButtonConfirmarActionPerformed

private void jTextFieldEstCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEstCivilActionPerformed
}//GEN-LAST:event_jTextFieldEstCivilActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonStatus1;
    private javax.swing.JRadioButton jRadioButtonStatus2;
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
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextField jTextFieldUf;
    // End of variables declaration//GEN-END:variables
}
