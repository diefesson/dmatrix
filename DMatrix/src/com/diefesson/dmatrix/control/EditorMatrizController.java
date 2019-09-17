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
    private String nome = "";

    /**
     * 
     * @param dmController O DMatrixController que será associado a essa matriz
     * @param view A view que será associada a essa matriz, pode ser null
     */
    public EditorMatrizController(DMatrixController dmController, EditorMatrizView view) {
        if (dmController == null) {
            throw new NullPointerException("dmController não pode ser null");
        }
        this.dmController = dmController;
        this.view = view;
    }

    /**
     * 
     * @return O DMatrixController associado a este controle
     */
    public DMatrixController obterDMController() {
        return dmController;
    }

    /**
     * 
     * @return Obtém a view associada a este controle
     */
    public EditorMatrizView obterView() {
        return view;
    }

    /**
     * 
     * @return Retorna a matriz interna desse controle
     */
    public Matriz obterMatriz() {
        return matriz;
    }

    /**
     * 
     * @return Obtém o nome usado para salvar a matriz
     */
    public String obterNome() {
        return nome;
    }

    /**
     * 
     * @param nome O nome nome que será usado para salvar a matriz
     */
    public void definirNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @param m Substitui a matriz usado por esse controle
     */
    public void definirMatriz(Matriz m) {
        matriz = m;
    }

    /**
     * Altera o tamanho da matriz interna desse controle
     * @param m A nova altura da matriz
     * @param n A nova largura da matriz
     * @return Por utilidade retorna a matriz desse controle
     */
    public Matriz redimensionar(int m, int n) {
        return (matriz = matriz.redimensionar(m, n));
    }

    /**
     * Salva uma cópia da matriz interna no DMatrixController associado
     */
    public void salvar() {
        dmController.adcionarMatriz(nome, matriz.clone());
    }

    /**
     * Carrega uma cópia da matriz a partir do DMatrixController associado
     *
     * @param nome A chave da matriz
     */
    public void carregar(String nome) {
        this.nome = nome;
        matriz = dmController.obterMatriz(nome).clone();
        if (view != null) {
            view.emCarregado();
        }
    }

    /**
     * Carrega uma coṕia da matriz dada
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
