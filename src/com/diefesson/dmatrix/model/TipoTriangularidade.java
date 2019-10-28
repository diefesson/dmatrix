package com.diefesson.dmatrix.model;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public enum TipoTriangularidade {

    NAO_TRIANGULAR(false, false),
    TRIANGULAR_SUPERIOR(true, false),
    TRIANGULAR_INFERIOR(false, true),
    DIAGONAL(true, true);

    private final boolean superior;
    private final boolean inferior;

    private TipoTriangularidade(boolean superior, boolean inferior) {
        this.superior = superior;
        this.inferior = inferior;
    }

    public boolean tipoSuperior() {
        return superior;
    }

    public boolean tipoInferior() {
        return inferior;
    }

    public boolean tipoDiagonal() {
        return superior && inferior;
    }

    public boolean naoTriangular() {
        return !(superior || inferior);
    }
}
