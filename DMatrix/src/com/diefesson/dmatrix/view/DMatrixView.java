package com.diefesson.dmatrix.view;

import com.diefesson.dmatrix.control.DMatrixController;
import com.diefesson.dmatrix.control.EditorMatrizController;
import com.diefesson.dmatrix.control.EditorNumeroController;
import com.diefesson.dmatrix.model.Matriz;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class DMatrixView extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textoMatrizes = new javax.swing.JLabel();
        textoNumeros = new javax.swing.JLabel();
        rolamentoMatrizes = new javax.swing.JScrollPane();
        listaMatrizes = new javax.swing.JList<>();
        rolamentoNumeros = new javax.swing.JScrollPane();
        tabelaNumeros = new javax.swing.JTable();
        barraDeMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuMatrizes = new javax.swing.JMenu();
        menuNovaMatriz = new javax.swing.JMenuItem();
        menuEditarMatriz = new javax.swing.JMenuItem();
        menuRemoverMatrizes = new javax.swing.JMenuItem();
        menuNumeros = new javax.swing.JMenu();
        menuNovoNumero = new javax.swing.JMenuItem();
        menuEditarNumero = new javax.swing.JMenuItem();
        menuRemoverNumeros = new javax.swing.JMenuItem();
        menuOperacoes = new javax.swing.JMenu();
        menuJavaScript = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DMatrix");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textoMatrizes.setText("Matrizes");

        textoNumeros.setText("Números");

        listaMatrizes.setModel(new DefaultListModel<String>()
        );
        rolamentoMatrizes.setViewportView(listaMatrizes);

        tabelaNumeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chave", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        rolamentoNumeros.setViewportView(tabelaNumeros);

        menuArquivo.setText("Arquivo");
        barraDeMenu.add(menuArquivo);

        menuMatrizes.setText("Matrizes");

        menuNovaMatriz.setText("Nova matriz");
        menuNovaMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovaMatrizActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuNovaMatriz);

        menuEditarMatriz.setText("Editar selecionada");
        menuEditarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarMatrizActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuEditarMatriz);

        menuRemoverMatrizes.setText("Remover selecionadas");
        menuRemoverMatrizes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverMatrizesActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuRemoverMatrizes);

        barraDeMenu.add(menuMatrizes);

        menuNumeros.setText("Numeros");

        menuNovoNumero.setText("Novo numero");
        menuNovoNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoNumeroActionPerformed(evt);
            }
        });
        menuNumeros.add(menuNovoNumero);

        menuEditarNumero.setText("Editar numero");
        menuEditarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarNumeroActionPerformed(evt);
            }
        });
        menuNumeros.add(menuEditarNumero);

        menuRemoverNumeros.setText("Remover numeros");
        menuRemoverNumeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverNumerosActionPerformed(evt);
            }
        });
        menuNumeros.add(menuRemoverNumeros);

        barraDeMenu.add(menuNumeros);

        menuOperacoes.setText("Operações");
        barraDeMenu.add(menuOperacoes);

        menuJavaScript.setText("JavaScript");
        barraDeMenu.add(menuJavaScript);

        menuAjuda.setText("Ajuda");
        barraDeMenu.add(menuAjuda);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        barraDeMenu.add(menuSair);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rolamentoMatrizes, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoMatrizes)
                            .addComponent(textoNumeros)
                            .addComponent(rolamentoNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoMatrizes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolamentoMatrizes, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNumeros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolamentoNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovaMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovaMatrizActionPerformed
        EditorMatrizView editor = new EditorMatrizView(controller);
        editor.setVisible(true);
    }//GEN-LAST:event_menuNovaMatrizActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        emSair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        emSair();
    }//GEN-LAST:event_formWindowClosing

    private void menuRemoverMatrizesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverMatrizesActionPerformed
        int[] selecionados = listaMatrizes.getSelectedIndices();
        int quantidade = selecionados.length;

        String[] chaves = new String[quantidade];
        for (int i = 0; i < quantidade; i++) {
            chaves[i] = modeloMatrizes.getElementAt(selecionados[i]);
        }

        controller.removerMatrizes(chaves);
    }//GEN-LAST:event_menuRemoverMatrizesActionPerformed

    private void menuEditarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarMatrizActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {//nenhuma matriz foi selecionada
            return;
        }
        String chave = modeloMatrizes.getElementAt(indice);
        EditorMatrizView ev = new EditorMatrizView(controller);
        EditorMatrizController ec = ev.obterController();
        ec.carregar(chave);
        ev.setVisible(true);
    }//GEN-LAST:event_menuEditarMatrizActionPerformed

    private void menuNovoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoNumeroActionPerformed
        EditorNumeroView ev = new EditorNumeroView(controller);
        ev.setVisible(true);
    }//GEN-LAST:event_menuNovoNumeroActionPerformed

    private void menuRemoverNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverNumerosActionPerformed

    }//GEN-LAST:event_menuRemoverNumerosActionPerformed

    private void menuEditarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarNumeroActionPerformed
        int indice = tabelaNumeros.getSelectedRow();
        if (indice == -1) {
            return;
        }

        String chave = (String) modeloNumeros.getValueAt(indice, 0);
        EditorNumeroView ev = new EditorNumeroView(controller);
        EditorNumeroController ec = ev.obterController();
        ec.carregar(chave);
    }//GEN-LAST:event_menuEditarNumeroActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DMatrixView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DMatrixView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JList<String> listaMatrizes;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuEditarMatriz;
    private javax.swing.JMenuItem menuEditarNumero;
    private javax.swing.JMenu menuJavaScript;
    private javax.swing.JMenu menuMatrizes;
    private javax.swing.JMenuItem menuNovaMatriz;
    private javax.swing.JMenuItem menuNovoNumero;
    private javax.swing.JMenu menuNumeros;
    private javax.swing.JMenu menuOperacoes;
    private javax.swing.JMenuItem menuRemoverMatrizes;
    private javax.swing.JMenuItem menuRemoverNumeros;
    private javax.swing.JMenu menuSair;
    private javax.swing.JScrollPane rolamentoMatrizes;
    private javax.swing.JScrollPane rolamentoNumeros;
    private javax.swing.JTable tabelaNumeros;
    private javax.swing.JLabel textoMatrizes;
    private javax.swing.JLabel textoNumeros;
    // End of variables declaration//GEN-END:variables

    private final DefaultListModel<String> modeloMatrizes;
    private final DefaultTableModel modeloNumeros;
    private final DMatrixController controller;

    public DMatrixView() {
        initComponents();
        controller = new DMatrixController(this);
        modeloMatrizes = (DefaultListModel<String>) listaMatrizes.getModel();
        modeloNumeros = (DefaultTableModel) tabelaNumeros.getModel();
    }

    public DMatrixController getController() {
        return controller;
    }

    public void emMatrizAdcionada(String chave, Matriz matriz, Matriz velha) {
        if (velha != null) {//apenas uma atualização, não preciso atualizar a parte gráfica
            return;
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            modeloMatrizes.addElement(chave);
        });
    }

    public void emMatrizRemovida(String chave, Matriz matriz) {
        SwingUtilities.invokeLater(() -> {
            modeloMatrizes.removeElement(chave);
        });
    }

    public void emNumeroAdcionado(String chave, float numero, Float velho) {
        SwingUtilities.invokeLater(() -> {
            if (velho != null) {
                int indice = -1;
                int linhas = modeloNumeros.getRowCount();
                for (int i = 0; i < linhas; i++) {
                    if (chave.equals(modeloNumeros.getValueAt(i, 0))) {
                        indice = i;
                        break;
                    }
                }
                modeloNumeros.setValueAt(numero, indice, 1);
            } else {
                modeloNumeros.addRow(new Object[]{chave, numero});
            }
        });
    }

    public void emNumeroRemovido(String chave, Float numero) {
        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < modeloNumeros.getRowCount(); i++) {
                String c = (String) modeloNumeros.getValueAt(i, 0);
                if (c.equals(chave)) {
                    modeloNumeros.removeRow(i);
                    break;
                }
            }
        });
    }

    private void emSair() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
