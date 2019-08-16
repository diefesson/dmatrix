package com.diefesson.dmatrix;

import com.diefesson.dmatrix.control.DMatrixController;
import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.view.DMatrixView;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class DMatrix {

    public static void main(String[] args) throws InterruptedException{
//        DMatrixView v = new DMatrixView();
//        DMatrixController c = v.getController();
//        c.adcionarMatriz("Matriz 1", new Matriz(5, 5));
//        v.setVisible(true);
//        
//        Thread.sleep(5000);
//        c.adcionarMatriz("Matriz 2", new Matriz(5, 5));
//        Thread.sleep(5000);
//        c.removerMatriz("Matriz 1");

        float [][] valores = new float[][]{
            {-2, 3, 1, 7},
            {0, -1, 2, 1},
            {3, -4, 5, 1},
            {1, 0, -2, -1}
        };
        
        Matriz m = new Matriz(valores);
        System.out.println(m.obterDeterminante());
    }

    
}
