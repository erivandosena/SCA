/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * formContrato.java
 *
 * Created on 20/03/2013, 13:52:22
 */
package br.net.rwd.sca.frames;

import br.net.rwd.sca.dao.ContratoDAO;
import br.net.rwd.sca.entidades.Contrato;
import br.net.rwd.sca.util.TableModelEspecial;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FileUtils;
import org.jrimum.texgit.FlatFile;
import org.jrimum.texgit.Record;
import org.jrimum.texgit.Texgit;
import org.jrimum.utilix.ClassLoaders;


/**
 *
 * @author Erivando
 */
public class formRetorno extends javax.swing.JDialog {

    private final ContratoDAO dao = new ContratoDAO();
    private List<Contrato> contratos;
    private final formPrincipal controleContratosInicial;
    private JFileChooser dialogoArquivo;
    private File arqSelecionado;

    public formRetorno(java.awt.Frame parent, boolean modal, formPrincipal controleContratosInicial) {
        super(parent, modal);
        this.controleContratosInicial = controleContratosInicial;
        initComponents();
        carregaContratos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelArqSelecionado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContratos = new javax.swing.JTable();
        jButtonTratar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tratamento de Retorno");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/abrir.png"))); // NOI18N
        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
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

        jLabel1.setText("Arquivo selecionado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelArqSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelArqSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
        });
        jScrollPane1.setViewportView(jTableContratos);

        jButtonTratar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/processamento.png"))); // NOI18N
        jButtonTratar.setText("Tratar");
        jButtonTratar.setPreferredSize(new java.awt.Dimension(140, 50));
        jButtonTratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTratarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTratar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTratar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-640)/2, (screenSize.height-362)/2, 640, 362);
    }// </editor-fold>//GEN-END:initComponents

private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
    dialogoArquivo = new JFileChooser();
    FileFilter filtro = new FileNameExtensionFilter("Arquivos de retorno (*.RET, *.TXT)", "ret", "txt");
    dialogoArquivo.setFileFilter(filtro);
    dialogoArquivo.setAcceptAllFileFilterUsed(false);  
    
    int resultado = dialogoArquivo.showOpenDialog(formRetorno.this);
 
    if (resultado == JFileChooser.APPROVE_OPTION) {
        arqSelecionado = dialogoArquivo.getSelectedFile();
        jLabelArqSelecionado.setText(arqSelecionado.getAbsolutePath());
    }
}//GEN-LAST:event_jButtonSelecionarActionPerformed

private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
    setVisible(false);
}//GEN-LAST:event_jButtonVoltarActionPerformed

    @SuppressWarnings("CallToThreadDumpStack")
private void jTableContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContratosMouseClicked
    estadoBotoes();
}//GEN-LAST:event_jTableContratosMouseClicked

@SuppressWarnings(value = "CallToThreadDumpStack")
    private void jButtonTratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTratarActionPerformed
        try {
            tratarRetorno(arqSelecionado);
        } catch (IOException ioe) {
            ioe.getStackTrace();
        }
    }//GEN-LAST:event_jButtonTratarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JButton jButtonTratar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelArqSelecionado;
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
            jButtonTratar.setEnabled(status);
        }
    }
    
     void tratarRetorno(File arquivo) throws IOException {

		DateFormat df = new SimpleDateFormat("dd/MM/yy");

		FlatFile<Record> ff = Texgit.createFlatFile(ClassLoaders.getResource("/retorno/LayoutCefSIGCB240.txg.xml"));

		ff.read(FileUtils.readLines(arquivo, "UTF-8"));

		Record hd = ff.getRecord("HeaderArquivo");

		System.out.println("Empesa: " + hd.getValue("Empresa-Nome"));
		System.out.println("CNPJ: " + hd.getValue("Empresa-CPRF"));
		System.out.println("Data de geração do arquivo: " + df.format(hd.getValue("Arquivo-GeracaoData")));

		Record hdLote = ff.getRecord("HeaderLote");

		System.out.println("Numero sequencial do retorno: " + hdLote.getValue("Retorno-Numero"));
		System.out.println("Mensagens:");
		System.out.println("MSG1: " + hdLote.getValue("Mensagem1"));
		System.out.println("MSG2: " + hdLote.getValue("Mensagem2"));

		System.out.println("-------------------------------Registros----------------------------------");

		for (Record r : ff.getRecords("Arrecadacao-Segmento-T")) {

			System.out.println("_______________________________");
			System.out.println("> Dados do pagamento");

			Date vencimento = r.getValue("Vencimento");
			BigDecimal valor = r.getValue("Valor");

			System.out.println("Vencimento do título: " + df.format(vencimento));
			System.out.println("Valor do título: " + valor);

			System.out.println("NumeroInscricao: " + r.getValue("CodigoCedente"));
			System.out.println("Nosso Numero: " + r.getValue("NossoNumero"));

			// Arrecadacao-Segmento-U
			Record ru = r.getInnerRecords().get(0);

			Integer movimento = ru.getValue("CodigoMovimento");

			if (movimento == 6)
				System.out.println("6-Liquidação de arrecadação: " + ru.getValue("Valor-Pago"));

			vencimento = r.getValue("Vencimento");
			valor = r.getValue("Valor");

			// System.out.println("Vencimento do título: " +
			// df.format(vencimento));
			System.out.println(" Efetivacao: " + df.format(vencimento));
		}
                 

		System.out.println("-------------------------------Fim do arquivo ----------------------------------");
		System.out.println("Qtd registros lote: " + ff.getRecord("TraillerLote").getValue("QtdRegistros"));
		System.out.println("Qtd registros totais: " + ff.getRecord("TraillerArquivo").getValue("QtdRegistros"));
	}
  
}
