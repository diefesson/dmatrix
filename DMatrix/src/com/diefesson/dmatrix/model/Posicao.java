package com.diefesson.dmatrix.model;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class Posicao implements Cloneable {

    private int i, j;

    public Posicao(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int obterI() {
        return i;
    }

    public void definirI(int i) {
        this.i = i;
    }

    public int obterJ() {
        return j;
    }

    public void definirJ(int j) {
        this.j = j;
    }

    /**
     *
     * @return Uma cópia dessa Posição
     */
    @Override
    public Object clone() {
        return new Posicao(i, j);
    }

    @Override
    public String toString() {
        return "(" + i + ", " + j + ")";
    }

}
