package com.diefesson.dmatrix.control;

import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.view.EditorMatrizView;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class EditorMatrizController {

    private final EditorMatrizView view;
    private final DMatrixController dmController;
    private Matriz matriz = new Matriz(1, 1);
    private String nome;

    public EditorMatrizController(DMatrixController dmController, EditorMatrizView view) {
        if (dmController == null) {
            throw new NullPointerException("dmController não pode ser null");
        }
        this.dmController = dmController;
        this.view = view;
    }

    public DMatrixController obterDMController() {
        return dmController;
    }

    public EditorMatrizView obterView() {
        return view;
    }

    public Matriz obterMatriz() {
        return matriz;
    }

    public String obterNome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public void definirMatriz(Matriz m) {
        matriz = m;
    }

    public Matriz redimensionar(int m, int n) {
        return (matriz = matriz.redimensionar(m, n));
    }

    /**
     * Salva uma cópia da matriz interna no DMatrixController associado
     *
     * @param nome a chave da matriz
     */
    public void salvar() {
        this.nome = nome;
        dmController.adcionarMatriz(nome, matriz.clone());
    }

    /**
     * carrega uma cópia da matriz a partir do DMatrixController associado
     *
     * @param nome a chave da matriz
     */
    public void carregar(String nome) {
        this.nome = nome;
        matriz = dmController.obterMatriz(nome).clone();
        if (view != null) {
            view.emCarregado();
        }
    }

    /**
     * carrega uma coṕia da matriz dada
     *
     * @param matriz a matriz a
     * @param nome a chave da matriz
     */
    public void carregar(String nome, Matriz matriz) {
        this.matriz = matriz;
        this.nome = nome;
        if (view != null) {
            view.emCarregado();
        }
    }

}
