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

import br.net.rwd.sca.cobranca.CarneCobranca;
import br.net.rwd.sca.dao.CarneDAO;
import br.net.rwd.sca.jasper.RelatorioMensalidade;
import br.net.rwd.sca.entidades.Carne;
import br.net.rwd.sca.entidades.Mensalidade;
import br.net.rwd.sca.util.TableModelEspecial;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.utilix.ClassLoaders;

/**
 *
 * @author Erivando
 */
public class formCarne extends javax.swing.JDialog {

    private final CarneDAO dao = new CarneDAO();
    private List<Carne> carnes;
    private List<Mensalidade> mensalidades;

    public formCarne(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregaCarnes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCarne = new javax.swing.JTable();
        jButtonImprimirRecibo = new javax.swing.JButton();
        jButtonImprimirBoleto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMensalidade = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        jButtonImprimir2viaBoleto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carnê");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Carnê"));

        jTableCarne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ));
        jTableCarne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCarneMouseClicked(evt);
            }
        });
        jTableCarne.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTableCarneComponentResized(evt);
            }
        });
        jTableCarne.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableCarneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableCarneFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCarne);

        jButtonImprimirRecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        jButtonImprimirRecibo.setText("Imprimir Carnê de Recibos");
        jButtonImprimirRecibo.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonImprimirRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirReciboActionPerformed(evt);
            }
        });

        jButtonImprimirBoleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        jButtonImprimirBoleto.setText("Imprimir Carnê de Pagamento");
        jButtonImprimirBoleto.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonImprimirBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirBoletoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonImprimirBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonImprimirRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImprimirRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonImprimirBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensalidades"));

        jTableMensalidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ));
        jScrollPane1.setViewportView(jTableMensalidade);

        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTotal.setText("Total R$ 0.00");

        jButtonImprimir2viaBoleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        jButtonImprimir2viaBoleto.setText("Imprimir 2ª Via Boleto");
        jButtonImprimir2viaBoleto.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonImprimir2viaBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimir2viaBoletoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jButtonImprimir2viaBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonImprimir2viaBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotal))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-640)/2, (screenSize.height-681)/2, 640, 681);
    }// </editor-fold>//GEN-END:initComponents

private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
    formAdicionaCarne dialog = new formAdicionaCarne(new javax.swing.JFrame(), true, dao, this);
    dialog.setVisible(true);
}//GEN-LAST:event_jButtonAdicionarActionPerformed

private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
    if (jTableCarne.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para edição!");
        return;
    }

    formAtualizaCarne dialog = new formAtualizaCarne(new javax.swing.JFrame(), true, dao, carnes.get(jTableCarne.getSelectedRow()), this);
    dialog.setVisible(true);
}//GEN-LAST:event_jButtonAlterarActionPerformed

private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
    if (jTableCarne.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para exclusão!");
        return;
    }

    int resultado = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", "Exclui", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (resultado == 0) {
        dao.removeCarne(carnes.get(jTableCarne.getSelectedRow()).getCodigo());
    }
    carregaCarnes();
}//GEN-LAST:event_jButtonRemoverActionPerformed

private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
    setVisible(false);
}//GEN-LAST:event_jButtonVoltarActionPerformed

private void jTableCarneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCarneMouseClicked
    if (evt.getClickCount() == 1) {
        carregaMensalidades(dao.selecionaCarne(carnes.get(jTableCarne.getSelectedRow()).getCodigo()));
    }
    estadoBotoes();
}//GEN-LAST:event_jTableCarneMouseClicked

private void jButtonImprimirReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirReciboActionPerformed
    if (jTableCarne.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para imprimir!");
        return;
    }

    RelatorioMensalidade rm = new RelatorioMensalidade();
    try {
        JasperViewer jv = new JasperViewer(rm.imprimirMensalidades(carnes.get(jTableCarne.getSelectedRow()).getCodigo()), false);
        this.setVisible(false);
        jv.setVisible(true);
        jv.setTitle("Carnê");
        jv.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone.gif")).getImage());
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButtonImprimirReciboActionPerformed

private void jTableCarneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableCarneFocusLost
}//GEN-LAST:event_jTableCarneFocusLost

private void jTableCarneComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTableCarneComponentResized
}//GEN-LAST:event_jTableCarneComponentResized

private void jTableCarneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableCarneFocusGained
}//GEN-LAST:event_jTableCarneFocusGained

private void jButtonImprimirBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirBoletoActionPerformed

    if (jTableCarne.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para imprimir!");
        return;
    }

    CarneCobranca carne = new CarneCobranca(dao.selecionaCarne(carnes.get(jTableCarne.getSelectedRow()).getCodigo()));
    //Informando o template personalizado:
    File templatePersonalizado = new File(ClassLoaders.getResource("/bloqueto/TemplateCarneCaixaA4.pdf").getFile());
    
    File boletosPorPagina = carne.groupInPages(carne.bloquetos(), "carne.pdf", templatePersonalizado);

    try {

        Runtime.getRuntime().exec("cmd.exe /c start " + boletosPorPagina.getAbsoluteFile());
    } catch (IOException ex) {
        ex.getStackTrace();
    }
 
}//GEN-LAST:event_jButtonImprimirBoletoActionPerformed

    private void jButtonImprimir2viaBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimir2viaBoletoActionPerformed

        if (jTableMensalidade.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para imprimir!");
            return;
        }

        CarneCobranca titulo = new CarneCobranca(dao.selecionaMensalidadePorCodigo(mensalidades.get(jTableMensalidade.getSelectedRow()).getCodigo()));

        BoletoViewer boletoViewer = new BoletoViewer(titulo.bloqueto(), new File(ClassLoaders.getResource("/bloqueto/TemplateTituloUnicoCaixaA4.pdf").getFile()));
        
        File boletoUnico = boletoViewer.getPdfAsFile("titulo.pdf");

        try {

            Runtime.getRuntime().exec("cmd.exe /c start " + boletoUnico.getAbsoluteFile());
        } catch (IOException ex) {
            ex.getStackTrace();
        }
            
    }//GEN-LAST:event_jButtonImprimir2viaBoletoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonImprimir2viaBoleto;
    private javax.swing.JButton jButtonImprimirBoleto;
    private javax.swing.JButton jButtonImprimirRecibo;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCarne;
    private javax.swing.JTable jTableMensalidade;
    // End of variables declaration//GEN-END:variables

    public final void carregaCarnes() {
        try {
            carnes = dao.selecionaCarne();
            jTableCarne.setModel(new TableModelEspecial(Carne.class, carnes, jTableCarne));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaMensalidades(Carne carne) {
        try {
            mensalidades = dao.selecionaMensalidade(carne.getCodigo());
            jTableMensalidade.setModel(new TableModelEspecial(Mensalidade.class, mensalidades, jTableMensalidade));

            Double total = 0.00d;
            for (Mensalidade mensalidade : mensalidades) {
                total += mensalidade.getValor();
            }
            jLabelTotal.setText("Total " + String.format("R$%.2f", total));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    void estadoBotoes() {
        if (jTableCarne.getSelectedRow() > -1) {
            boolean status = carnes.get(jTableCarne.getSelectedRow()).getContrato().getLocatario().isStatus();
            jButtonAlterar.setEnabled(status);
            jButtonImprimirRecibo.setEnabled(status);
            jButtonImprimirBoleto.setEnabled(status);
        }
    }
    
}
