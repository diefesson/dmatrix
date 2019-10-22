package com.diefesson.dmatrix.control;

import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.view.EditorMatrizView;
import java.util.function.BiConsumer;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class EditorMatrizControl {

    private final EditorMatrizView view;
    private final DMatrixControl dmController;
    private Matriz matriz = new Matriz(1, 1);
    private String nome = "";
    private BiConsumer<String, Matriz> aoSalvar;

    /**
     *
     * @param dmController O DMatrixController que será associado a essa matriz
     * @param view A view que será associada a essa matriz, pode ser null
     */
    public EditorMatrizControl(DMatrixControl dmController, EditorMatrizView view) {
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
    public DMatrixControl obterDMController() {
        return dmController;
    }

    /**
     *
     * @return Obtém a view associada a este controle
     */
    public EditorMatrizView obterView() {
        return view;
    }

    public void definirAoSalvar(BiConsumer<String, Matriz> aoSalvar) {
        this.aoSalvar = aoSalvar;
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
        if (nome == null) {
            throw new NullPointerException("nome não pode ser null");
        }
        this.nome = nome;
    }

    /**
     *
     * @param m Substitui a matriz usado por esse controle
     */
    public void definirMatriz(Matriz m) {
        if (m == null) {
            throw new NullPointerException("a matriz não pode ser null");
        }
        matriz = m;
    }

    /**
     * Altera o tamanho da matriz interna desse controle
     *
     * @param m A nova altura da matriz
     * @param n A nova largura da matriz
     */
    public void redimensionar(int m, int n) {
        matriz.redimensionar(m, n);
    }

    /**
     * Salva uma cópia da matriz interna no DMatrixController associado
     */
    public void salvar() {
        if (aoSalvar != null) {
            aoSalvar.accept(nome, matriz);
        }
    }

    /**
     * Carrega uma cópia da matriz a partir do DMatrixController associado
     *
     * @param nome A chave da matriz
     */
    public void carregar(String nome) {
        if (nome == null) {
            throw new NullPointerException("o nome não pode ser null");
        }
        this.nome = nome;
        matriz = dmController.obterMatriz(nome);
        if (view != null) {
            view.emCarregado();
        }
    }

    /**
     * Carrega coṕia da matriz dada
     *
     * @param matriz a matriz a
     * @param nome a chave da matriz
     */
    public void carregar(String nome, Matriz matriz) {
        if (nome == null || matriz == null) {
            throw new NullPointerException("nem o nome, nem a matriz poder ser null");
        }
        this.matriz = matriz;
        this.nome = nome;
        if (view != null) {
            view.emCarregado();
        }
    }
    
    public void carregar(Matriz matriz) {
        if (matriz == null) {
            throw new NullPointerException("a matriz poder ser null");
        }
        this.matriz = matriz;
        if (view != null) {
            view.emCarregado();
        }
    }

}
