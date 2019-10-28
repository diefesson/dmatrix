package com.diefesson.dmatrix;

import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.view.DMatrixView;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class DMatrix {

    public static void main(String[] args) throws InterruptedException {
        iniciar();
    }

    private static void testar() {
        Matriz m = new Matriz(new double[][]{
            {0.0001, 0.99, 0},
            {1, 0, 0},
            {0, 0, 2}
        });
        m.ortogonalizar();
        m.normalizar();
        System.out.println(m.classificarOrtogonalizacao());
        System.out.println(m);
    }

    private static void iniciar() {
        definirLaf();
        new DMatrixView().setVisible(true);
    }

    //O NetBeans já coloca isso nas janelas, mas é mais conveniente aqui
    private static void definirLaf() {
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
    }

}
