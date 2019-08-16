package com.diefesson.dmatrix.view;

import com.diefesson.dmatrix.control.DMatrixController;
import com.diefesson.dmatrix.model.Matriz;
import javax.swing.DefaultListModel;
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
        menuNumeros = new javax.swing.JMenu();
        menuOperacoes = new javax.swing.JMenu();
        menuJavaScript = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoMatrizes.setText("Matrizes");

        textoNumeros.setText("Números");

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
        barraDeMenu.add(menuMatrizes);

        menuNumeros.setText("Numeros");
        barraDeMenu.add(menuNumeros);

        menuOperacoes.setText("Operações");
        barraDeMenu.add(menuOperacoes);

        menuJavaScript.setText("JavaScript");
        barraDeMenu.add(menuJavaScript);

        menuAjuda.setText("Ajuda");
        barraDeMenu.add(menuAjuda);

        menuSair.setText("Sair");
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
    private javax.swing.JMenu menuJavaScript;
    private javax.swing.JMenu menuMatrizes;
    private javax.swing.JMenu menuNumeros;
    private javax.swing.JMenu menuOperacoes;
    private javax.swing.JMenu menuSair;
    private javax.swing.JScrollPane rolamentoMatrizes;
    private javax.swing.JScrollPane rolamentoNumeros;
    private javax.swing.JTable tabelaNumeros;
    private javax.swing.JLabel textoMatrizes;
    private javax.swing.JLabel textoNumeros;
    // End of variables declaration//GEN-END:variables

    private final DefaultListModel<String> modeloMatrizes = new DefaultListModel<>();
    private final DefaultTableModel modeloNumeros;
    private final DMatrixController control;

    public DMatrixView() {
        initComponents();
        control = new DMatrixController(this);
        listaMatrizes.setModel(modeloMatrizes);
        modeloNumeros = (DefaultTableModel) tabelaNumeros.getModel();
    }

    public DMatrixController getController() {
        return control;
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
        SwingUtilities.invokeLater(()->{
            modeloMatrizes.removeElement(chave);
        });
    }

    public void emNumeroAdcionado(String chave, float numero, Float velho) {
        if(velho != null){
            
        }
        
        SwingUtilities.invokeLater(()->{
            
        });
    }

    public void emNumeroRemovido(String chave, Float numero) {
        SwingUtilities.invokeLater(()->{
            for(int i = 0; i < modeloNumeros.getRowCount(); i++){
                String c = (String) modeloNumeros.getValueAt(i, 0);
                if(c.equals(chave)){
                    modeloNumeros.removeRow(i);
                    break;
                }
            }
        });
    }
}
