package com.diefesson.dmatrix;

import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.view.DMatrixView;
import javax.swing.UIManager;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class DMatrix {

    public static void main(String[] args) throws InterruptedException {
        
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
