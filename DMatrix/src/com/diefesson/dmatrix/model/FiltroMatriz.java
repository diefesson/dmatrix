package com.diefesson.dmatrix.model;

import java.util.function.BiFunction;

/**
 * Um filtro usado para encontrar a posicão de valores em uma matriz
 * @author Diefesson de Sousa Silva
 */
public interface FiltroMatriz extends BiFunction<Posicao, Double, Boolean>{

    /**
     * Realiza uma busca por um determinado valor
     */
    public static class FiltroDeValor implements FiltroMatriz{

        private final double valor;

        public FiltroDeValor(double valor) {
            this.valor = valor;
        }
        
        @Override
        public Boolean apply(Posicao posicao, Double valor) {
            if(this.valor == valor){
                return true;
            } else {
                return false;
            }
        }
        
    }
    
    /**
     * Realiza uma busca por um valor difente do dado
     */
    public static class FiltroDeDiferente extends FiltroDeValor{
        
        public FiltroDeDiferente(double valor){
            super(valor);
        }

        @Override
        public Boolean apply(Posicao posicao, Double valor) {
            return !super.apply(posicao, valor); 
        }
        
        
    }
    
    @Override
    public Boolean apply(Posicao posicao, Double valor);
    
}
