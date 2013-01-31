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

import br.net.rwd.sca.dao.ContratoDAO;
import br.net.rwd.sca.dao.LocadorDAO;
import br.net.rwd.sca.dao.LocatarioDAO;
import br.net.rwd.sca.entidades.Contrato;
import br.net.rwd.sca.entidades.Locador;
import br.net.rwd.sca.entidades.Locatario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Erivando
 */
public class formAtualizaContrato extends javax.swing.JDialog {

    public final ContratoDAO dao;
    private final LocadorDAO daoLocador = new LocadorDAO();
    private final LocatarioDAO daoLocatario = new LocatarioDAO();
    private final formContrato controle;
    private final formPrincipal controleContratosInicial;
    private final Contrato contrato;

    public formAtualizaContrato(java.awt.Frame parent, boolean modal, ContratoDAO dao, Contrato contrato, formContrato controle, formPrincipal controleContratosInicial) {
        super(parent, modal);
        this.dao = dao;
        this.contrato = contrato;
        this.controle = controle;
        this.controleContratosInicial = controleContratosInicial;
        initComponents();
        carregaLocador();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxLocador = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxLocatario = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldValor = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldPrazo = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldDtaInicio = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextFieldDtaFim = new javax.swing.JFormattedTextField();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualiza Contrato");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Locador"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxLocador, 0, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBoxLocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Locatário"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxLocatario, 0, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBoxLocatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Contrato"));

        jLabel1.setText("Descrição");

        jLabel2.setText("Valor R$");

        jFormattedTextFieldValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00##"))));
        jFormattedTextFieldValor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFormattedTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldValorKeyReleased(evt);
            }
        });

        jLabel3.setText("Prazo");

        jLabel4.setText("Data Inicial");

        jLabel5.setText("Data Final");

        jFormattedTextFieldDtaFim.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldDtaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldDtaFim, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextFieldPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextFieldDtaFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextFieldDtaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-640)/2, (screenSize.height-338)/2, 640, 338);
    }// </editor-fold>//GEN-END:initComponents

private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
    try {
        if (jComboBoxLocador.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Infome o locador corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jComboBoxLocatario.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Infome o locatário corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jTextFieldDescricao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Infome a descrição corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jFormattedTextFieldValor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Infome o valor corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jFormattedTextFieldDtaInicio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Infome a data de início corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jFormattedTextFieldPrazo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Infome o prazo corretamente!", "Erro de campo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextFieldDtaInicio.getText());

        int prazo = Integer.parseInt(jFormattedTextFieldPrazo.getText());

        GregorianCalendar dataFinal = new GregorianCalendar();
        dataFinal.setTime(dataInicio);
        dataFinal.add(GregorianCalendar.MONTH, prazo);
        dataFinal.add(GregorianCalendar.MONTH, -1); //Janeiro = 1

        contrato.setLocador((Locador) jComboBoxLocador.getSelectedItem());
        contrato.setLocatario((Locatario) jComboBoxLocatario.getSelectedItem());
        contrato.setDescricao(jTextFieldDescricao.getText());
        contrato.setMensalidade(Float.parseFloat(jFormattedTextFieldValor.getText().replace(",", ".")));
        contrato.setDataInicial(new java.sql.Date(dataInicio.getTime()));
        contrato.setDataFinal(new java.sql.Date(dataFinal.getTimeInMillis()));
        contrato.setPrazo(prazo);

        dao.atualiza(contrato);
        this.controle.carregaContratos();
        this.controleContratosInicial.carregaContratosInicial();
        setVisible(false);

    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

}//GEN-LAST:event_jButtonConfirmarActionPerformed

private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    setVisible(false);
}//GEN-LAST:event_jButtonCancelarActionPerformed

private void jFormattedTextFieldValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorKeyReleased
}//GEN-LAST:event_jFormattedTextFieldValorKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox jComboBoxLocador;
    private javax.swing.JComboBox jComboBoxLocatario;
    private javax.swing.JFormattedTextField jFormattedTextFieldDtaFim;
    private javax.swing.JFormattedTextField jFormattedTextFieldDtaInicio;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrazo;
    private javax.swing.JFormattedTextField jFormattedTextFieldValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldDescricao;
    // End of variables declaration//GEN-END:variables

    private void carregaLocador() {
        @SuppressWarnings("UseOfObsoleteCollectionType")
        Vector<Locador> locador = new Vector(daoLocador.seleciona());
        DefaultComboBoxModel dcbmLocador = new DefaultComboBoxModel(locador);
        jComboBoxLocador.setModel(dcbmLocador);

        @SuppressWarnings("UseOfObsoleteCollectionType")
        Vector<Locatario> locatarios = new Vector(daoLocatario.seleciona());
        DefaultComboBoxModel dcbmLocatarios = new DefaultComboBoxModel(locatarios);
        jComboBoxLocatario.setModel(dcbmLocatarios);

        jComboBoxLocador.setSelectedItem(contrato.getLocador());
        jComboBoxLocatario.setSelectedItem(contrato.getLocatario());
        jTextFieldDescricao.setText(contrato.getDescricao());
        jFormattedTextFieldValor.setText(String.valueOf(contrato.getMensalidade()));
        jFormattedTextFieldDtaInicio.setText(new SimpleDateFormat("dd/MM/yyyy").format(contrato.getDataInicial()));
        jFormattedTextFieldDtaFim.setText(new SimpleDateFormat("dd/MM/yyyy").format(contrato.getDataFinal()));
        jFormattedTextFieldPrazo.setText(String.valueOf(contrato.getPrazo()));
    }
}
