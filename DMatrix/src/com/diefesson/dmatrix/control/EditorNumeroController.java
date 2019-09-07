package com.diefesson.dmatrix.control;

import com.diefesson.dmatrix.view.EditorNumeroView;
import java.util.Random;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class EditorNumeroController {

    private final EditorNumeroView view;
    private final DMatrixController dmController;
    private float numero;
    private String nome;

    public EditorNumeroController(EditorNumeroView view, DMatrixController dmController) {
        this.view = view;
        this.dmController = dmController;
    }

    public EditorNumeroView obterView() {
        return view;
    }

    public void definirNumero(float numero) {
        this.numero = numero;
    }

    public float obterNumero() {
        return numero;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public String obterNome() {
        return nome;
    }

    public void carregar(String nome) {
        this.nome = nome;
        numero = dmController.obterNumero(nome);
        view.emCarregar();
    }

    public void carregar(String nome, float numero) {
        this.nome = nome;
        this.numero = numero;
        view.emCarregar();
    }

    public void salvar() {
        dmController.adcionarNumero(nome, numero);
    }

    public void aleatorio(float min, float max) {
        float delta = max - min;
        Random r = new Random();
        numero = min + delta * r.nextInt();
    }

}
