/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FramePrincipal.java
 *
 * Created on 10/01/2012, 09:30:26
 */
package br.net.rwd.sca.frames;

import br.net.rwd.sca.dao.ContratoDAO;
import br.net.rwd.sca.dao.LocadorDAO;
import br.net.rwd.sca.entidades.Contrato;
import br.net.rwd.sca.entidades.Locador;
import br.net.rwd.sca.util.TableModelEspecial;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Erivando
 */
public class formPrincipal extends javax.swing.JFrame {

    private final ContratoDAO dao = new ContratoDAO();
    private List<Contrato> contratos;
    private final String usuarioLogado;

    public formPrincipal(String usuarioLogado) {
        initComponents();
        formPrincipal.this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone.gif")).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        this.usuarioLogado = usuarioLogado;
        carregaContratosInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonLocador = new javax.swing.JButton();
        jButtonLocatarios = new javax.swing.JButton();
        jButtonCarne = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jButtonContrato = new javax.swing.JButton();
        jLabelBoasVindas = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContratos = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCA - Sistema de Controle de Aluguel");
        setIconImages(null);
        setName("framePrincipal"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonLocador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/locador.png"))); // NOI18N
        jButtonLocador.setText("Locador");
        jButtonLocador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLocador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLocador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocadorActionPerformed(evt);
            }
        });

        jButtonLocatarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/locatarios.png"))); // NOI18N
        jButtonLocatarios.setText("Locatários");
        jButtonLocatarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLocatarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLocatarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocatariosActionPerformed(evt);
            }
        });

        jButtonCarne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carne.png"))); // NOI18N
        jButtonCarne.setText("Carnê");
        jButtonCarne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCarne.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCarne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarneActionPerformed(evt);
            }
        });

        jButtonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios.png"))); // NOI18N
        jButtonUsuarios.setText("Usuários");
        jButtonUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechar.png"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contrato.png"))); // NOI18N
        jButtonContrato.setText("Contrato");
        jButtonContrato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonContrato.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButtonLocador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLocatarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonContrato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCarne, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonUsuarios)
                    .addComponent(jButtonCarne)
                    .addComponent(jButtonContrato)
                    .addComponent(jButtonLocatarios)
                    .addComponent(jButtonLocador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelBoasVindas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelBoasVindas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBoasVindas.setText("Bem-vindo!");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contratos"));

        jTableContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ));
        jTableContratos.setEnabled(false);
        jScrollPane1.setViewportView(jTableContratos);

        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setText("Total R$ 0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotal))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBoasVindas, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBoasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-583)/2, (screenSize.height-338)/2, 583, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLocadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocadorActionPerformed
        formLocador dialog = new formLocador(new javax.swing.JFrame(), true, new LocadorDAO(), new Locador());
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonLocadorActionPerformed

    private void jButtonLocatariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocatariosActionPerformed
        formLocatario dialog = new formLocatario(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonLocatariosActionPerformed

    private void jButtonContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContratoActionPerformed
        formContrato dialog = new formContrato(new javax.swing.JFrame(), true, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonContratoActionPerformed

    private void jButtonCarneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarneActionPerformed
        formCarne dialog = new formCarne(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonCarneActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        formUsuario dialog = new formUsuario(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        System.exit(0);        
    }//GEN-LAST:event_jButtonFecharActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCarne;
    private javax.swing.JButton jButtonContrato;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonLocador;
    private javax.swing.JButton jButtonLocatarios;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabelBoasVindas;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContratos;
    // End of variables declaration//GEN-END:variables

    public final void carregaContratosInicial() {
        try {
            jLabelBoasVindas.setText("Bem-vindo! " + usuarioLogado);
            contratos = dao.seleciona();

            Double total = 0.00d;
            for (Contrato contrato : contratos) {
                total += contrato.getMensalidade();
            }
            jLabelTotal.setText("Total " + String.format("R$%.2f", total));

            jTableContratos.setModel(new TableModelEspecial(Contrato.class, contratos, jTableContratos));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
