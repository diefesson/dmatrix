package com.diefesson.dmatrix.view;

import com.diefesson.dmatrix.model.Matriz;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class PanelMatriz extends javax.swing.JPanel {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollValores = new javax.swing.JScrollPane();
        tabelaValores = new javax.swing.JTable();

        scrollValores.setRowHeaderView(tabelaValores);
        scrollValores.setViewportView(tabelaValores);

        tabelaValores.setModel(modeloValores);
        tabelaValores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaValores.setAutoscrolls(false);
        tabelaValores.setTableHeader(null);
        scrollValores.setViewportView(tabelaValores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollValores)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollValores)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollValores;
    private javax.swing.JTable tabelaValores;
    // End of variables declaration//GEN-END:variables

    TabelaNumeros modeloValores = new TabelaNumeros();

    public PanelMatriz() {
        initComponents();
    }

    public void atualizarView(Matriz matriz) {
        int m = matriz.obterAltura();
        int n = matriz.obterLargura();

        modeloValores.setRowCount(m);
        modeloValores.setColumnCount(n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                modeloValores.setValueAt(matriz.obterValor(i, j), i, j);
            }
        }
    }

    public void atualizarControl(Matriz matriz) {
        if(matriz == null){
            modeloValores.setRowCount(0);
            modeloValores.setColumnCount(0);
            return;
        }
        
        int m = modeloValores.getRowCount();
        int n = modeloValores.getColumnCount();
        
        matriz.redimensionar(m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double valor = 0;
                try {
                    valor = Double.parseDouble(modeloValores.getValueAt(i, j).toString());
                } catch (NumberFormatException ex) {

                }
                matriz.definirValor(valor, i, j);
            }
        }
    }
    
    public void definirEditavel(boolean editavel){
        tabelaValores.setEnabled(editavel);
    }

}
