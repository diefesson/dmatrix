package com.diefesson.dmatrix.view;

import com.diefesson.dmatrix.control.DMatrixController;
import com.diefesson.dmatrix.control.EditorMatrizController;
import com.diefesson.dmatrix.model.Matriz;
import javax.swing.CellEditor;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import javax.swing.SwingUtilities;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class EditorMatrizView extends javax.swing.JFrame {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textoLinhas = new javax.swing.JLabel();
        textoColunas = new javax.swing.JLabel();
        spinnerColunas = new javax.swing.JSpinner();
        spinnerLinhas = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaValores = new javax.swing.JTable();
        textoNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoRedimensionar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textoLinhas.setText("Linhas:");

        textoColunas.setText("Colunas:");

        spinnerColunas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        spinnerLinhas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tabelaValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaValores);

        textoNome.setText("Nome da matriz:");

        campoNome.setText("minha matriz");

        botaoSalvar.setText("SALVAR");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoRedimensionar.setText("redimensionar");
        botaoRedimensionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRedimensionarActionPerformed(evt);
            }
        });

        jMenu1.setText("Matriz especial");

        jMenuItem1.setText("Matriz identidade");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Matriz aleatória");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoColunas)
                    .addComponent(textoLinhas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerColunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoRedimensionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSalvar))
                    .addComponent(campoNome))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoLinhas)
                            .addComponent(spinnerLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNome)
                            .addComponent(botaoSalvar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoColunas)
                                    .addComponent(spinnerColunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(botaoRedimensionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRedimensionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRedimensionarActionPerformed
        atualizarController();//manda os dados da tabela para a matriz
        controller.redimensionar((int) spinnerLinhas.getValue(), (int) spinnerColunas.getValue());//redimensiona a matriz
        atualizarView();//e então recebe os da matriz para a tabelas
    }//GEN-LAST:event_botaoRedimensionarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        atualizarController();
        controller.definirNome(campoNome.getText());
        controller.salvar();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int ordem = (int) spinnerLinhas.getValue();
        controller.definirMatriz(Matriz.gerarIdentidade(ordem));
        atualizarView();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int m = (int) spinnerLinhas.getValue();
        int n = (int) spinnerColunas.getValue();

        Matriz matriz = new Matriz(m, n);
        Matriz.PreencherAleatorio(matriz, -10, 11);
        controller.definirMatriz(matriz);

        atualizarView();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(EditorMatrizView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorMatrizView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorMatrizView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorMatrizView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorMatrizView(new DMatrixController(null)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoRedimensionar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerColunas;
    private javax.swing.JSpinner spinnerLinhas;
    private javax.swing.JTable tabelaValores;
    private javax.swing.JLabel textoColunas;
    private javax.swing.JLabel textoLinhas;
    private javax.swing.JLabel textoNome;
    // End of variables declaration//GEN-END:variables

    private final EditorMatrizController controller;
    private final DefaultTableModel modeloValores;

    /**
     * Creates new form EditorView
     *
     * @param dmController o controlador do dmatrix para ser usado
     */
    public EditorMatrizView(DMatrixController dmController) {
        initComponents();
        controller = new EditorMatrizController(dmController, this);
        modeloValores = (DefaultTableModel) tabelaValores.getModel();
        atualizarView();
    }

    /**
     * Chamado quando o controle dessa view carrega uma nova matriz
     */
    public void emCarregado() {
        SwingUtilities.invokeLater(() -> {
            campoNome.setText(controller.obterNome());
            atualizarView();
        });
    }

    /**
     * Atualiza a matriz no sentido control -> view
     */
    private void atualizarView() {
        SwingUtilities.invokeLater(() -> {
            Matriz matriz = controller.obterMatriz();
            int m = matriz.obterAltura();
            int n = matriz.obterLargura();

            spinnerLinhas.setValue(m);
            spinnerColunas.setValue(n);

            modeloValores.setRowCount(m);
            modeloValores.setColumnCount(n);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    modeloValores.setValueAt(matriz.obterValor(i, j), i, j);
                }
            }
        });
    }

    /**
     * Atualiza a matriz no sentido view -> control
     *
     */
    private void atualizarController() {
        int m = modeloValores.getRowCount();
        int n = modeloValores.getColumnCount();
        Matriz matriz = controller.obterMatriz();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                float valor = 0;
                try {
                    valor = Float.parseFloat(modeloValores.getValueAt(i, j).toString());
                } catch (NumberFormatException ex) {

                }
                matriz.definirValor(valor, i, j);
            }
        }
    }

    public EditorMatrizController obterController() {
        return controller;
    }

}
