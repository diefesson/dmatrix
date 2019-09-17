package com.diefesson.dmatrix;

import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.model.Sistema;
import com.diefesson.dmatrix.view.DMatrixView;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class DMatrix {

    public static void main(String[] args) throws InterruptedException {        
        Matriz m = new Matriz(new double[][]{
            {1, 2, 4},
            {0, 0, 1},
            {0, 0, 1}
        });
        
        Matriz m2 = new Matriz(new double[][]{
            {1},
            {2},
            {3}
        });

        System.out.println("matriz\n" + m);
        
        System.out.println("matriz 2\n" + m2);
        
        
        Sistema s = new Sistema(m, m2);
        System.out.println(s.solucionar());
        System.out.println(s);
        
        DMatrixView view = new DMatrixView();
        view.setVisible(true);

//        double antigoDeterminante = m.obterDeterminante();
//
//        double multiplicador = m.prepararMatriz();
//        
//        double novoDeterminante = m.obterDeterminante();
//        
//        double res = novoDeterminante * multiplicador;
//        
//        System.out.println("ad: " + antigoDeterminante + " m: " + multiplicador + " nd: " + novoDeterminante + "res: " + res);
//        
//        System.out.println("nova matriz\n" + m);
    }

}
