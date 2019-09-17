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
    private double numero = 0;
    private String nome = "";

    public EditorNumeroController(EditorNumeroView view, DMatrixController dmController) {
        this.view = view;
        this.dmController = dmController;
    }

    /**
     * 
     * @return A view associada a esse controle
     */
    public EditorNumeroView obterView() {
        return view;
    }

    /**
     * 
     * @param numero O número que será editado
     */
    public void definirNumero(double numero) {
        this.numero = numero;
    }

    /**
     * 
     * @return O número que está sendo editado
     */
    public double obterNumero() {
        return numero;
    }

    /**
     * 
     * @param nome O nome que será usado ao salvar o número
     */
    public void definirNome(String nome) {
        if(nome == null){
            throw new NullPointerException("O nome do número não pode ser null");
        }
        this.nome = nome;
    }

    /**
     * 
     * @return O nome que será usado para salvar o número
     */
    public String obterNome() {
        return nome;
    }

    /**
     * Carrega uma cópia do número para ser edita
     * @param nome A chave que indentifica o número
     */
    public void carregar(String nome) {
        this.nome = nome;
        Double n = dmController.obterNumero(nome);
        if(n == null){
            n = 0d;
        }
        numero = n;
        view.emCarregar();
    }

    /**
     * Carrega o número no controle
     * @param nome O nome que será usado para salvar o número
     * @param numero O número que será editado
     */
    public void carregar(String nome, double numero) {
        this.nome = nome;
        this.numero = numero;
        view.emCarregar();
    }

    /**
     * Salva o número editado no DMatrixController associado
     */
    public void salvar() {
        dmController.adcionarNumero(nome, numero);
    }

    /**
     * Substitui o número por um valor aleatório
     * @param min O valor mínimo inclusivo
     * @param max O valor máximo exclusivo
     */
    public void aleatorio(double min, double max) {
        double delta = max - min;
        Random r = new Random();
        numero = min + delta * r.nextInt();
    }

}
