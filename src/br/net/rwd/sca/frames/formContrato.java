/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * formContrato.java
 *
 * Created on 23/01/2012, 14:47:02
 */
package br.net.rwd.sca.frames;

import br.net.rwd.sca.dao.ContratoDAO;
import br.net.rwd.sca.entidades.Contrato;
import br.net.rwd.sca.jasper.RelatorioContrato;
import br.net.rwd.sca.util.TableModelEspecial;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Erivando
 */
public class formContrato extends javax.swing.JDialog {

    private final ContratoDAO dao = new ContratoDAO();
    private List<Contrato> contratos;
    private final formPrincipal controleContratosInicial;

    public formContrato(java.awt.Frame parent, boolean modal, formPrincipal controleContratosInicial) {
        super(parent, modal);
        this.controleContratosInicial = controleContratosInicial;
        initComponents();
        carregaContratos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContratos = new javax.swing.JTable();
        jButtonImprimir = new javax.swing.JButton();
        jButtonPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contrato");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jTableContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ));
        jTableContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContratosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableContratosMouseEntered(evt);
            }
        });
        jTableContratos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableContratosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableContratosFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContratos);

        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButtonPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pdf.png"))); // NOI18N
        jButtonPdf.setText("Exportar");
        jButtonPdf.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-640)/2, (screenSize.height-362)/2, 640, 362);
    }// </editor-fold>//GEN-END:initComponents

private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
    formAdicionaContrato dialog = new formAdicionaContrato(new javax.swing.JFrame(), true, dao, this, controleContratosInicial);
    dialog.setVisible(true);
}//GEN-LAST:event_jButtonAdicionarActionPerformed

private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
    if (jTableContratos.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para edição!");
        return;
    }

    formAtualizaContrato dialog = new formAtualizaContrato(new javax.swing.JFrame(), true, dao, contratos.get(jTableContratos.getSelectedRow()), this, controleContratosInicial);
    dialog.setVisible(true);
}//GEN-LAST:event_jButtonAlterarActionPerformed

private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
    if (jTableContratos.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para exclusão!");
        return;
    }

    int resultado = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?\nTodas as outras informações dependentes deste cadastro também serão excluídas!", "Exclui", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

    if (resultado == 0) {
        int codContrato = contratos.get(jTableContratos.getSelectedRow()).getCodigo();
        dao.remove(codContrato);
    }
    carregaContratos();
    this.controleContratosInicial.carregaContratosInicial();
}//GEN-LAST:event_jButtonRemoverActionPerformed

private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
    setVisible(false);
}//GEN-LAST:event_jButtonVoltarActionPerformed

    @SuppressWarnings("CallToThreadDumpStack")
private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        if (jTableContratos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para imprimir!");
            return;
        }

        RelatorioContrato rc = new RelatorioContrato();
        try {
            JasperViewer jv = new JasperViewer(rc.impprimirContrato(contratos.get(jTableContratos.getSelectedRow()).getNumero()), false);
            this.setVisible(false);
            jv.setVisible(true);
            jv.setTitle("Contrato");
            jv.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone.gif")).getImage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_jButtonImprimirActionPerformed

    @SuppressWarnings("CallToThreadDumpStack")
private void jButtonPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPdfActionPerformed
        if (jTableContratos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para exportar!");
            return;
        }

        RelatorioContrato rc = new RelatorioContrato();
        try {
            String numero = contratos.get(jTableContratos.getSelectedRow()).getNumero();
            String arquivo = System.getProperty("user.dir") + "\\relatorios\\Contrato.pdf";
            JasperExportManager.exportReportToPdfFile(rc.impprimirContrato(numero), arquivo);
            this.setVisible(false);
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + arquivo);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

}//GEN-LAST:event_jButtonPdfActionPerformed

private void jTableContratosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContratosMouseEntered
}//GEN-LAST:event_jTableContratosMouseEntered

private void jTableContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContratosMouseClicked
    estadoBotoes();
}//GEN-LAST:event_jTableContratosMouseClicked

private void jTableContratosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableContratosFocusGained
}//GEN-LAST:event_jTableContratosFocusGained

private void jTableContratosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableContratosFocusLost
}//GEN-LAST:event_jTableContratosFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonPdf;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContratos;
    // End of variables declaration//GEN-END:variables

    public final void carregaContratos() {
        try {
            contratos = dao.seleciona();
            jTableContratos.setModel(new TableModelEspecial(Contrato.class, contratos, jTableContratos));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    void estadoBotoes() {
        if (jTableContratos.getSelectedRow() > -1) {
            boolean status = contratos.get(jTableContratos.getSelectedRow()).getLocatario().isStatus();
            jButtonAlterar.setEnabled(status);
            jButtonPdf.setEnabled(status);
            jButtonImprimir.setEnabled(status);
        }
    }
}
