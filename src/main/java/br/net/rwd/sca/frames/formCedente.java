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

import br.net.rwd.sca.dao.CedenteDAO;
import br.net.rwd.sca.entidades.CedenteCobranca;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erivando
 */
public class formCedente extends javax.swing.JDialog {

    private final CedenteDAO dao;
    private CedenteCobranca alteraCedente;

    public formCedente(java.awt.Frame parent, boolean modal, CedenteDAO dao, CedenteCobranca cedente) {
        super(parent, modal);
        this.dao = dao;
        this.alteraCedente = cedente;
        initComponents();
        carregaDadosCedente();
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
        jTextFieldAgencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldInstrucoes1 = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldOperacao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldContaCedente = new javax.swing.JTextField();
        jComboBoxMoeda = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEspecie = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxAceite = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jFormattedTextFieldMulta = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldDiasMulta = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jFormattedTextFieldDesc = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldDiasDesc = new javax.swing.JTextField();
        jFormattedTextFieldJuros = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldInstrucoes4 = new javax.swing.JTextField();
        jTextFieldInstrucoes2 = new javax.swing.JTextField();
        jTextFieldInstrucoes3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMensagemSac = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNossoNum = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxModalidade = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxEmisBloq = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox();
        jCheckBoxAvalista = new javax.swing.JCheckBox();
        jButtonExcluir = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adiciona Cedente");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nome");

        jLabel2.setText("Agência");

        jLabel3.setText("CPF");

        jLabel4.setText("Moeda");

        jTextFieldNome.setColumns(50);

        jLabel6.setText("Juros %");

        jLabel7.setText("Instruções sobre multa e juros");

        jTextFieldInstrucoes1.setColumns(80);

        jLabel13.setText("Operação");

        jLabel14.setText("Conta/Código Cedente");

        jComboBoxMoeda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "R$", "UFIR" }));

        jLabel16.setText("Espécie");

        jComboBoxEspecie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DM", "DS", "OU" }));

        jLabel17.setText("Aceite");

        jComboBoxAceite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "N", "S" }));

        jLabel18.setText("Multa %");

        jFormattedTextFieldMulta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel19.setText("Dias");

        jLabel20.setText("Desconto %");

        jFormattedTextFieldDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel21.setText("Dias");

        jFormattedTextFieldJuros.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel8.setText("Instruções sobre descontos");

        jTextFieldInstrucoes4.setColumns(80);

        jTextFieldInstrucoes2.setColumns(80);

        jTextFieldInstrucoes3.setColumns(80);

        jScrollPane1.setViewportView(jTextAreaMensagemSac);

        jLabel24.setText("Mensagens Sadado");

        jLabel9.setText("Instruções diversas");

        jLabel10.setText("Instruções diversas");

        jLabel5.setText("Nosso Número");

        jTextFieldNossoNum.setColumns(15);

        jLabel11.setText("Modalidade");

        jComboBoxModalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "1" }));

        jLabel12.setText("Emissão do Bloqueto");

        jComboBoxEmisBloq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "4", "3", "2", "1" }));

        jLabel15.setText("Tipo");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SR", "RG" }));

        jCheckBoxAvalista.setText("Exibir Avalista");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jComboBoxMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBoxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                                        .addComponent(jLabel13)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(75, 75, 75)
                                                        .addComponent(jLabel14)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldContaCedente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBoxAceite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(24, 24, 24)
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jFormattedTextFieldMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel19)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldDiasMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel20)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jFormattedTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel21)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldDiasDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(27, 27, 27)
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jFormattedTextFieldJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxEmisBloq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNossoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckBoxAvalista))))
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel24)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldInstrucoes1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldInstrucoes2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldInstrucoes3, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldInstrucoes4, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
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
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldContaCedente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextFieldJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jFormattedTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldDiasDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxAceite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jFormattedTextFieldMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDiasMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxEmisBloq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldNossoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAvalista))
                .addGap(10, 10, 10)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldInstrucoes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldInstrucoes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldInstrucoes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldInstrucoes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setPreferredSize(new java.awt.Dimension(150, 50));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-809)/2, (screenSize.height-576)/2, 809, 576);
    }// </editor-fold>//GEN-END:initComponents

private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    setVisible(false);
}//GEN-LAST:event_jButtonCancelarActionPerformed

private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed

    if (jTextFieldNome.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o nome corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (jTextFieldNossoNum.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(this, "Infome o nosso número inicial!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        if (alteraCedente == null) {
            CedenteCobranca insereCedente = new CedenteCobranca();
            dao.adiciona(insereAtualiza(insereCedente));
        } else {
            dao.atualiza(insereAtualiza(alteraCedente));
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(formCedente.class.getName()).log(Level.SEVERE, null, ex);
    }
    carregaDadosCedente();

}//GEN-LAST:event_jButtonConfirmarActionPerformed

private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
    if (alteraCedente == null) {
        JOptionPane.showMessageDialog(this, "Não existe registro para excluir!");
        return;
    }

    int resultado = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", "Exclui", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (resultado == 0) {
        int codCedente = alteraCedente.getCeden_cod();
        dao.remove(codCedente);
        setVisible(false);
    }

}//GEN-LAST:event_jButtonExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JCheckBox jCheckBoxAvalista;
    private javax.swing.JComboBox jComboBoxAceite;
    private javax.swing.JComboBox jComboBoxEmisBloq;
    private javax.swing.JComboBox jComboBoxEspecie;
    private javax.swing.JComboBox jComboBoxModalidade;
    private javax.swing.JComboBox jComboBoxMoeda;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JFormattedTextField jFormattedTextFieldDesc;
    private javax.swing.JFormattedTextField jFormattedTextFieldJuros;
    private javax.swing.JFormattedTextField jFormattedTextFieldMulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMensagemSac;
    private javax.swing.JTextField jTextFieldAgencia;
    private javax.swing.JTextField jTextFieldContaCedente;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldDiasDesc;
    private javax.swing.JTextField jTextFieldDiasMulta;
    private javax.swing.JTextField jTextFieldInstrucoes1;
    private javax.swing.JTextField jTextFieldInstrucoes2;
    private javax.swing.JTextField jTextFieldInstrucoes3;
    private javax.swing.JTextField jTextFieldInstrucoes4;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNossoNum;
    private javax.swing.JTextField jTextFieldOperacao;
    // End of variables declaration//GEN-END:variables

    private void carregaDadosCedente() {

        alteraCedente = dao.selecionaCedente();

        if (alteraCedente != null) { 
            jTextFieldNome.setText(alteraCedente.getCeden_nome());
            jTextFieldCpf.setText(alteraCedente.getCeden_cpfcnpj());
            jTextFieldAgencia.setText(alteraCedente.getCeden_agencia());
            jTextFieldOperacao.setText(alteraCedente.getCeden_operacao());
            jTextFieldContaCedente.setText(alteraCedente.getCeden_conta());
            jTextFieldNossoNum.setText(alteraCedente.getCeden_nossonumero());
            jComboBoxMoeda.setSelectedItem(alteraCedente.getCeden_moeda());
            jComboBoxEspecie.setSelectedItem(alteraCedente.getCeden_especie());
            jComboBoxAceite.setSelectedItem(alteraCedente.getCeden_aceite());
            jComboBoxTipo.setSelectedItem(alteraCedente.getCeden_tipo());
            jComboBoxModalidade.setSelectedItem(alteraCedente.getCeden_modalidade());
            jComboBoxEmisBloq.setSelectedItem(alteraCedente.getCeden_emissao_bloq());
            jFormattedTextFieldMulta.setText(String.valueOf(alteraCedente.getCeden_multa()));
            jTextFieldDiasMulta.setText(String.valueOf(alteraCedente.getCeden_multa_dias()));
            jFormattedTextFieldDesc.setText(String.valueOf(alteraCedente.getCeden_descontos()));
            jTextFieldDiasDesc.setText(String.valueOf(alteraCedente.getCeden_descontos_dia()));
            jFormattedTextFieldJuros.setText(String.valueOf(alteraCedente.getCeden_juros()));
            jCheckBoxAvalista.setSelected(alteraCedente.isCeden_avalista());
            jTextAreaMensagemSac.setText(alteraCedente.getCeden_msg_sacado());
            jTextFieldInstrucoes1.setText(alteraCedente.getCeden_msg1());
            jTextFieldInstrucoes2.setText(alteraCedente.getCeden_msg2());
            jTextFieldInstrucoes3.setText(alteraCedente.getCeden_msg3());
            jTextFieldInstrucoes4.setText(alteraCedente.getCeden_msg4());
        }

    }
    
    private CedenteCobranca insereAtualiza(CedenteCobranca c) {
        c.setCeden_nome(jTextFieldNome.getText().toUpperCase());
        c.setCeden_cpfcnpj(jTextFieldCpf.getText());
        c.setCeden_agencia(jTextFieldAgencia.getText());
        c.setCeden_operacao(jTextFieldOperacao.getText());
        c.setCeden_conta(jTextFieldContaCedente.getText());
        c.setCeden_nossonumero(jTextFieldNossoNum.getText());
        c.setCeden_moeda(jComboBoxMoeda.getSelectedItem().toString());
        c.setCeden_especie(jComboBoxEspecie.getSelectedItem().toString());
        c.setCeden_aceite(jComboBoxAceite.getSelectedItem().toString());
        c.setCeden_tipo(jComboBoxTipo.getSelectedItem().toString());
        c.setCeden_modalidade(jComboBoxModalidade.getSelectedItem().toString());
        c.setCeden_emissao_bloq(jComboBoxEmisBloq.getSelectedItem().toString());
        c.setCeden_multa(Float.valueOf(jFormattedTextFieldMulta.getText().replace(",", ".")));
        c.setCeden_multa_dias(Integer.valueOf(jTextFieldDiasMulta.getText()));
        c.setCeden_descontos(Float.valueOf(jFormattedTextFieldDesc.getText().replace(",", ".")));
        c.setCeden_descontos_dia(Integer.valueOf(jTextFieldDiasDesc.getText()));
        c.setCeden_juros(Float.valueOf(jFormattedTextFieldJuros.getText().replace(",", ".")));
        c.setCeden_avalista(jCheckBoxAvalista.isSelected());
        c.setCeden_msg_sacado(jTextAreaMensagemSac.getText());
        c.setCeden_msg1(jTextFieldInstrucoes1.getText());
        c.setCeden_msg2(jTextFieldInstrucoes2.getText());
        c.setCeden_msg3(jTextFieldInstrucoes3.getText());
        c.setCeden_msg4(jTextFieldInstrucoes4.getText());

        return c;
    }
}
