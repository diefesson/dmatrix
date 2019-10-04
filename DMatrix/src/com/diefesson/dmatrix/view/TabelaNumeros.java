package com.diefesson.dmatrix.view;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class TabelaNumeros extends DefaultTableModel {

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        String valor = aValue.toString();
        try {
            double v = Double.parseDouble(valor);
            super.setValueAt(v, row, column);
        } catch (NumberFormatException ex) {

        }
    }

}
