package com.diefesson.dmatrix.view;

import com.diefesson.dmatrix.control.DMatrixControl;
import com.diefesson.dmatrix.control.HistoricoControl;
import com.diefesson.dmatrix.model.Historico;
import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.model.Registro;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class HistoricoView extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelVisualizando = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        panelMatriz = new com.diefesson.dmatrix.view.PanelMatriz();
        panelMatrizAmpliada = new com.diefesson.dmatrix.view.PanelMatriz();
        botaoAnterior = new javax.swing.JButton();
        botalProximo = new javax.swing.JButton();
        labelRegistro = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DMatrix - Historico");
        setAlwaysOnTop(true);

        labelVisualizando.setText("Visualizando:");

        labelNome.setText("nome");

        botaoAnterior.setText("Anterior");
        botaoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAnteriorActionPerformed(evt);
            }
        });

        botalProximo.setText("Proximo");
        botalProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botalProximoActionPerformed(evt);
            }
        });

        labelRegistro.setText("pagina");

        labelDescricao.setText("Descrição:");

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMatrizAmpliada, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescricao)
                .addGap(483, 483, 483))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botalProximo)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelVisualizando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVisualizando)
                    .addComponent(labelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(panelMatrizAmpliada, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAnterior)
                    .addComponent(labelRegistro)
                    .addComponent(botalProximo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAnteriorActionPerformed
        indice--;
        atualizarView();
    }//GEN-LAST:event_botaoAnteriorActionPerformed

    private void botalProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botalProximoActionPerformed
        indice++;
        atualizarView();
    }//GEN-LAST:event_botalProximoActionPerformed

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
            java.util.logging.Logger.getLogger(HistoricoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoView(new DMatrixControl(null)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botalProximo;
    private javax.swing.JButton botaoAnterior;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelRegistro;
    private javax.swing.JLabel labelVisualizando;
    private com.diefesson.dmatrix.view.PanelMatriz panelMatriz;
    private com.diefesson.dmatrix.view.PanelMatriz panelMatrizAmpliada;
    // End of variables declaration//GEN-END:variables

    private final HistoricoControl control;
    int indice = 0;

    public HistoricoView(DMatrixControl dmControl) {
        initComponents();
        control = new HistoricoControl(dmControl, this);
        panelMatriz.definirEditavel(false);
        panelMatrizAmpliada.definirEditavel(false);
        atualizarView();
    }
    
    public HistoricoControl obterControl(){
        return control;
    }

    public void aoCarregar() {
        indice = 0;
        atualizarView();
    }
    
    private void atualizarView(){
        Historico h = control.obterHistorico();
        int q = h.obterQuantidade();
        
        Registro r = h.obterRegistro(indice);
        Matriz m = r.obterMatriz();
        Matriz a = m.obterAmpliada();
        
        labelNome.setText(control.obterNome());
        
        panelMatriz.atualizarView(m);
        panelMatrizAmpliada.atualizarControl(a);
        
        campoDescricao.setText("");
        for(String desc : r){
            campoDescricao.append(desc + "\n");
        }
        
        botaoAnterior.setEnabled(indice != 0);
        botalProximo.setEnabled(indice !=  q - 1);
        labelRegistro.setText("Registro " + (indice + 1) + " de " + q);
    }

}
