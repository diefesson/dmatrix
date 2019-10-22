package com.diefesson.dmatrix.control;

import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.view.DMatrixView;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class DMatrixControl {

    private final Map<String, Matriz> matrizes = new HashMap<>();
    private final Map<String, Double> numeros = new HashMap<>();
    private final DMatrixView view;

    /**
     *
     * @param view A view associada a este controlador
     */
    public DMatrixControl(DMatrixView view) {
        this.view = view;
    }

    /**
     * Adciona uma matriz a coleção contida no controlador
     *
     * @param chave A chave da matriz
     * @param matriz A matriz que será armazenada
     */
    public void adcionarMatriz(String chave, Matriz matriz) {
        if (chave == null || matriz == null) {
            throw new NullPointerException("nem a chave nem a matriz podem ser nulas");
        }
        Matriz antiga = matrizes.put(chave, matriz);
        if (view != null) {
            view.emMatrizAdcionada(chave, matriz, antiga);
        }
    }

    /**
     * Obtém uma matriz a partir de sua chave
     *
     * @param chave A chave que identifica a matriz
     * @return A matriz ou null caso ela não seja encontrada
     */
    public Matriz obterMatriz(String chave) {
        if (chave == null) {
            throw new NullPointerException("a chave não pode ser nula");
        }
        return matrizes.get(chave);
    }

    /**
     * Remove uma matriz da coleção
     *
     * @param chave A chave que indentifica a matriz
     * @return Retorna a matriz que foi removida
     */
    public Matriz removerMatriz(String chave) {
        if (chave == null) {
            throw new NullPointerException("a chave não pode ser nula");
        }
        Matriz matriz = matrizes.remove(chave);
        if (view != null && matriz != null) {
            view.emMatrizRemovida(chave, matriz);
        }
        return matriz;
    }

    /**
     * Adciona um número a coleção
     *
     * @param chave A chave que indentica o número
     * @param numero O numero a ser armazenado
     */
    public void adcionarNumero(String chave, double numero) {
        if (chave == null) {
            throw new NullPointerException("a chave não pode ser nula");
        }

        Double antigo = numeros.put(chave, numero);
        if (view != null) {
            view.emNumeroAdcionado(chave, numero, antigo);
        }
    }

    /**
     * Obtém um número da coleção
     *
     * @param chave A chave que identifica o número
     * @return O número ou null, caso não seja encontrado
     */
    public Double obterNumero(String chave) {
        if (chave == null) {
            throw new NullPointerException("a chave não pode ser nula");
        }

        return numeros.get(chave);
    }

    /**
     * Remove um número da coleção
     *
     * @param chave A chave que identifica o número
     * @return O número removido, ou null caso ele não seja encontrado
     */
    public Double removerNumero(String chave) {
        if (chave == null) {
            throw new NullPointerException("a chave não pode ser nula");
        }

        Double numero = numeros.remove(chave);
        if (view != null && numero != null) {
            view.emNumeroRemovido(chave, numero);
        }
        return numero;
    }

    /**
     * Obtém uma matriz a partir de filtro dado
     *
     * @param filtro A interface funcional que serve como filtro para selecionar
     * matrizes
     * @return Um mapa contendo as chaves e as matrizes aprovados pelo filtro
     */
    public Map<String, Matriz> obterMatrizes(Function<Matriz, Boolean> filtro) {
        Map<String, Matriz> resultados = new HashMap<>();
        for (Entry<String, Matriz> no : matrizes.entrySet()) {
            if (filtro.apply(no.getValue())) {
                resultados.put(no.getKey(), no.getValue());
            }
        }
        return resultados;
    }

    /**
     * Remove todas as matrizes identificadas pela chaves dadas
     *
     * @param chaves as chaves que indenticam as matrizes a serem removidas
     */
    public void removerMatrizes(String[] chaves) {
        for (String chave : chaves) {
            removerMatriz(chave);
        }
    }

    /**
     * Remove todos os números identificados pelos chaves dadas
     *
     * @param chaves As chaves que indentificam os números que serão removidos
     */
    public void removerNumeros(String[] chaves) {
        for (String chave : chaves) {
            removerNumero(chave);
        }
    }

}
