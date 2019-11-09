package com.diefesson.dmatrix.model;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public enum DirecaoEliminacao {

    BAIXO(true, false),
    AMBAS(true, true),
    CIMA(false, true);

    private final boolean cima, baixo;

    private DirecaoEliminacao(boolean baixo, boolean cima) {
        this.cima = cima;
        this.baixo = baixo;
    }

    public boolean baixo() {
        return baixo;
    }

    public boolean cima() {
        return cima;
    }

}
