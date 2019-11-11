package com.diefesson.dmatrix.view;

import com.diefesson.dmatrix.control.DMatrixControl;
import com.diefesson.dmatrix.control.GroovyControl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class GroovyView extends javax.swing.JFrame {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        editorScript = new javax.swing.JTextArea();
        labelStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenuItem();
        menuSalvar = new javax.swing.JMenuItem();
        menuExecutar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DMatrix - Script");
        setAlwaysOnTop(true);

        editorScript.setColumns(20);
        editorScript.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        editorScript.setRows(5);
        editorScript.setText("//A função de script já funciona e interpreta Groovy\n//Mas minha API ainda não está totalmente pronta\n\nimport com.diefesson.dmatrix.model.*\nimport com.diefesson.dmatrix.control.*\n\ndef mensagem = \"OLA MUNDO\"\ndef matriz = new Matriz(1, mensagem.size())\nfor(int j = 0; j < mensagem.size(); j++){\n     matriz.definirValor((double) mensagem.charAt(j), 0, j)\n}\n\ndmControl.adcionarMatriz(\"OLA MUNDO\", matriz)");
        jScrollPane1.setViewportView(editorScript);

        labelStatus.setText("Parado");

        menuArquivo.setText("Arquivo");

        menuAbrir.setText("Abrir");
        menuArquivo.add(menuAbrir);

        menuSalvar.setText("Salvar");
        menuArquivo.add(menuSalvar);

        jMenuBar1.add(menuArquivo);

        menuExecutar.setText("Script");

        jMenuItem1.setText("Executar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuExecutar.add(jMenuItem1);

        jMenuBar1.add(menuExecutar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelStatus)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        labelStatus.setText("Executando");
        control.definirScript(editorScript.getText());
        control.executar(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GroovyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroovyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroovyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroovyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GroovyView(new DMatrixControl(null)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea editorScript;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuExecutar;
    private javax.swing.JMenuItem menuSalvar;
    // End of variables declaration//GEN-END:variables

    private final DMatrixControl dmControl;
    private final GroovyControl control;

    public GroovyView(DMatrixControl dmControl) {
        initComponents();
        this.dmControl = dmControl;
        GroovyControl c = null;
        try {
            c = new GroovyControl(dmControl, this);
        } catch (IOException ex) {
            Logger.getLogger(GroovyView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de fluxo ao criar fluxo de script");
        }
        control = c;
    }
    
    public void aoTerminar(){
        SwingUtilities.invokeLater(()->{
            labelStatus.setText("Parado");
        });
    }

}