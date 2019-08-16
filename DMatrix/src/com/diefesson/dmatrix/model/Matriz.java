package com.diefesson.dmatrix.model;

import java.util.Random;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class Matriz implements Cloneable{
    
    private float[][] valores;
    
    public Matriz(int m, int n){
        valores = new float[m][n];
    }
    
    /**
     * OBS: esse construtor não 
     * @param valores Os valores que serão usados nessa matriz
     */
    public Matriz(float[][] valores){
        int m = valores.length;
        int n = valores[0].length;
        
        if(m == 0 || n == 0){
            throw new IllegalArgumentException("A altura ou a largura não deve ser 0");
        }
        for(int i = 1; i < valores.length; i++){
            if(valores[i].length != n){
                throw new IllegalArgumentException("O tamanho das colunas não são iguais");
            }
        }
        
        this.valores = valores;
    }
    
    public void selecionarValor(float valor, int i, int j){
        valores[i][j] = valor;
    }
    
    public float obterValor(int i, int j){
        return valores[i][j];
    }
    
    public int obterAltura(){
        return valores.length;
    }
    
    public int obterLargura(){
        return valores[0].length;
    }
    
    public boolean verificarQuadrada(){
        return obterAltura() == obterLargura();
    }
    
    public boolean verificarNula(){
        int m = obterAltura();
        int n = obterLargura();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obterValor(i, j) != 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean verificarIdentidade(){
        int m = obterAltura();
        int n = obterLargura();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obterValor(i, j) != ((i == j) ? 1 : 0)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public TipoTriangularidade verificarTriangularidade(){
        if(!verificarQuadrada()){
            return TipoTriangularidade.NAO_TRIANGULAR;
        }
        
        int tamanho = obterAltura();//altura == largura...
        boolean inferior = true, superior = true;
        
        loopSuperior:
        for(int i = 0; i < tamanho; i++){
            for(int j = i - 1; j > -1; j--){
                if(obterValor(i, j) != 0){
                    superior = false;
                    break loopSuperior;
                }
            }
        }
        
        loopInferior:
        for(int i = 0; i < tamanho; i++){
            for(int j = i + 1; j < tamanho; j++){
                if(obterValor(i, j) != 0){
                    inferior = false;
                    break loopInferior;
                }
            }
        }
        
        if(superior && inferior){
            return TipoTriangularidade.DIAGONAL;
        } else if(superior) {
            return TipoTriangularidade.TRIANGULAR_SUPERIOR;
        } else if(inferior){
            return  TipoTriangularidade.TRIANGULAR_INFERIOR;
        } else {
            return TipoTriangularidade.NAO_TRIANGULAR;
        }
    }
    
    public void somaEscalar(float escalar){
        int m = obterAltura();
        int n = obterLargura();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                valores[i][j] += escalar;
            }
        }
    }
    
    /**
     * OBS: A matriz alterada é a usada para chamar esse método
     * @param outra A outra matriz para a operação de soma matricial
     */
    public void somaMatriz(Matriz outra){
        int m = obterAltura();
        int n = obterLargura();
        if(m != outra.obterAltura() || n != outra.obterLargura()){
            throw new IllegalArgumentException("O tamanho das matrizes deve ser igual(" + m +"x" + n + " " + outra.obterAltura() + "x" + outra.obterLargura() + ")");
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                valores[i][j] += outra.obterValor(i, j);
            }
        }
    }
    
    /**
     * 
     * @param escalar O escalar a qual está matriz será multiplicado
     */
    public void multiplicacaoEscalar(float escalar){
        int m = obterAltura();
        int n = obterLargura();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                valores[i][j] *= escalar;
            }
        }
    }
    
    /**
     * 
     * @param outra O segundo operando da multipliicao de matrizes
     * @return O resultado da multiplicacao de matrizes
     * @throws IllegalArgumentException Caso as matrizes não sejam multiplicaveis
     */
    public Matriz multiplicacao(Matriz outra){
        Matriz saida = matrizParaMultiplicacao(outra);
        
        int m = saida.obterAltura();
        int n = saida.obterLargura();
        int o = obterLargura();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                float valor = 0;
                for(int k = 0; k < o; k++){
                    valor += obterValor(i, k) * outra.obterValor(k, j);
                }
                saida.selecionarValor(valor, i, j);
            }
        }
        
        return saida;
    }
    
    /**
     * 
     * @param outra A segundo operando, usado para estimar o tamanho
     * @return Uma matriz do tamanho correto para ser usada na sáida da multiplição dessa por outra
     * @throws IllegalArgumentException Caso as matrizes nãp possam não sejam multiplicaveis entre si
     */
    public Matriz matrizParaMultiplicacao(Matriz outra){
        if(verificarMultiplicacao(outra)){
            throw new IllegalArgumentException("A largura de m1 deve ser igual a altura de m2");
        }
        return new Matriz(obterAltura(), outra.obterLargura());
    }
    
    /**
     * 
     * @param outra O segundo operando da multiplicação
     * @return true, se as matrizes forem multiplicaveis entre si
     */
    public boolean verificarMultiplicacao(Matriz outra){
        return obterLargura() == outra.obterAltura();
    }
    
    public float valorDeMaiorModulo(){
        float valor = 0;
        int m = obterAltura();
        int n = obterLargura();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(Math.abs(valores[i][j]) > valor){
                    valor = valores[i][j];
                }
            }
        }
        return valor;
    }
    
    /**
     * 
     * @return Uma cópia profunda dessa matriz
     */
    public Matriz Clone(){
        int m = obterAltura();
        int n = obterLargura();
        float[][] cloneValores = new float[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; i++){
                cloneValores[i][j] = valores[i][j];
            }
        }
        
        return new Matriz(cloneValores);
    }
    
    public static void PreencherAleatorio(Matriz matriz, float min, float max){
        float delta = max - min;
        Random r = new Random();
        int m = matriz.obterAltura();
        int n = matriz.obterLargura();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matriz.selecionarValor(min + delta * r.nextFloat(), i, j);
            }
        }
    }
    
    public static Matriz gerarIdentidade(int ordem){
        Matriz identidade = new Matriz(ordem, ordem);
        for(int k = 0; k < ordem; k++){
            identidade.selecionarValor(1, k, k);
        }
        return identidade;
    }
    
}
