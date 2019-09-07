package com.diefesson.dmatrix.model;

import java.util.Random;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class Matriz implements Cloneable {

    private final float[][] valores;

    /**
     *
     * @param m a altura da matriz
     * @param n a largura da matriz
     */
    public Matriz(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException(String.format("Tamanho da matriz inválido %dx%d", m, n));
        }
        valores = new float[m][n];
    }

    /**
     * OBS: esse construtor não copia a matriz dada
     *
     * @param valores os valores que serão usados nessa matriz
     */
    public Matriz(float[][] valores) {
        int m = valores.length;
        if (m == 0) {
            throw new IllegalArgumentException("A altura da matriz não pode ser igual a zero");
        }
        int n = valores[0].length;
        if (n == 0) {
            throw new IllegalArgumentException("A largura da matriz não pode ser igual zero");
        }

        for (int i = 1; i < valores.length; i++) {
            if (valores[i].length != n) {
                throw new IllegalArgumentException("O tamanho das colunas devem ser todos iguais");
            }
        }

        this.valores = valores;
    }

    public void definirValor(float valor, int i, int j) {
        valores[i][j] = valor;
    }

    /**
     *
     * @param i a linha do elemento na matriz
     * @param j a coluna do elemento na matriz
     * @return o valor do elemente na posição (i, j)
     */
    public float obterValor(int i, int j) {
        return valores[i][j];
    }

    /**
     *
     * @return a altura dessa matriz
     */
    public int obterAltura() {
        return valores.length;
    }

    /**
     *
     * @return a largura dessa matriz
     */
    public int obterLargura() {
        return valores[0].length;
    }

    /**
     *
     * @return true se essa matriz for quadrada
     */
    public boolean verificarQuadrada() {
        return obterAltura() == obterLargura();
    }

    /**
     *
     * @return true se todos os elementos dessa matriz forem iguais a zero
     */
    public boolean verificarNula() {
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obterValor(i, j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Uma matriz identidade é aquela em que para todos os elementos, se i == j
     * o valor do elemento é 1, caso contrário 0
     *
     * @return true se essa matriz for uma matriz identidade
     */
    public boolean verificarIdentidade() {
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obterValor(i, j) != ((i == j) ? 1 : 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * OBS: por coveniência esse método também chega se o caso de matriz
     * diagonal
     *
     * @return um enumerador para o tipo de triangularidade
     */
    public TipoTriangularidade verificarTriangularidade() {
        if (!verificarQuadrada()) {
            return TipoTriangularidade.NAO_TRIANGULAR;
        }

        int tamanho = obterAltura();//altura == largura...
        boolean inferior = true, superior = true;

        loopSuperior:
        for (int i = 0; i < tamanho; i++) {
            for (int j = i - 1; j > -1; j--) {
                if (obterValor(i, j) != 0) {
                    superior = false;
                    break loopSuperior;
                }
            }
        }

        loopInferior:
        for (int i = 0; i < tamanho; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                if (obterValor(i, j) != 0) {
                    inferior = false;
                    break loopInferior;
                }
            }
        }

        if (superior && inferior) {
            return TipoTriangularidade.DIAGONAL;
        } else if (superior) {
            return TipoTriangularidade.TRIANGULAR_SUPERIOR;
        } else if (inferior) {
            return TipoTriangularidade.TRIANGULAR_INFERIOR;
        } else {
            return TipoTriangularidade.NAO_TRIANGULAR;
        }
    }

    /**
     * Realiza uma soma escalar(não sei se esse é o correto dessa operação)
     *
     * @param escalar o valor a ser somados a todas as células dessa matriz
     */
    public void somaEscalar(float escalar) {
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valores[i][j] += escalar;
            }
        }
    }

    /**
     * OBS: A matriz alterada é a usada para chamar esse método
     *
     * @param outra A outra matriz para a operação de soma matricial
     * @throws IllegalArgumentException caso as matrizes não posssam ser somadas
     */
    public void somaMatriz(Matriz outra) {
        int m = obterAltura();
        int n = obterLargura();
        if (m != outra.obterAltura() || n != outra.obterLargura()) {
            throw new IllegalArgumentException("O tamanho das matrizes deve ser igual(" + m + "x" + n + " " + outra.obterAltura() + "x" + outra.obterLargura() + ")");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valores[i][j] += outra.obterValor(i, j);
            }
        }
    }

    /**
     *
     * @param escalar O escalar a qual está matriz será multiplicado
     */
    public void multiplicacaoEscalar(float escalar) {
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valores[i][j] *= escalar;
            }
        }
    }

    /**
     *
     * @param outra O segundo operando da multipliicao de matrizes
     * @return O resultado da multiplicacao de matrizes
     * @throws IllegalArgumentException Caso as matrizes não sejam
     * multiplicaveis
     */
    public Matriz multiplicacao(Matriz outra) {
        Matriz saida = matrizParaMultiplicacao(outra);

        int m = saida.obterAltura();
        int n = saida.obterLargura();
        int o = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                float valor = 0;
                for (int k = 0; k < o; k++) {
                    valor += obterValor(i, k) * outra.obterValor(k, j);
                }
                saida.definirValor(valor, i, j);
            }
        }

        return saida;
    }

    /**
     *
     * @param outra A segundo operando, usado para estimar o tamanho
     * @return Uma matriz do tamanho correto para ser usada na sáida da
     * multiplição dessa por outra
     * @throws IllegalArgumentException Caso as matrizes não possam não sejam
     * multiplicaveis entre si
     */
    public Matriz matrizParaMultiplicacao(Matriz outra) {
        if (!verificarMultiplicacao(outra)) {
            throw new IllegalArgumentException("A largura de m1 deve ser igual a altura de m2");
        }
        return new Matriz(obterAltura(), outra.obterLargura());
    }

    /**
     *
     * @param outra O segundo operando da multiplicação
     * @return true, se as matrizes forem multiplicaveis entre si
     */
    public boolean verificarMultiplicacao(Matriz outra) {
        return obterLargura() == outra.obterAltura();
    }

    public float valorDeMaiorModulo() {
        float valor = 0;
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(valores[i][j]) > valor) {
                    valor = valores[i][j];
                }
            }
        }
        return valor;
    }

    /**
     * OBS veja Cloneable para mais informações
     *
     * @return Uma cópia profunda dessa matriz
     */
    @Override
    public Matriz clone() {
        int m = obterAltura();
        int n = obterLargura();
        float[][] cloneValores = new float[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cloneValores[i][j] = valores[i][j];
            }
        }

        return new Matriz(cloneValores);
    }

    /**
     *
     * @param matriz a matriz a ser preechida
     * @param min o valor mínimo(inclusivo)
     * @param max o valor máximo(exclusivo)
     */
    public static void PreencherAleatorio(Matriz matriz, float min, float max) {
        float delta = max - min;
        Random r = new Random();
        int m = matriz.obterAltura();
        int n = matriz.obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz.definirValor(min + delta * r.nextFloat(), i, j);
            }
        }
    }

    /**
     * obtém a linha processado i e j da sequinte forma i = i % m j = j % n útil
     * para o teorema de Sarrus
     *
     * @param i a linha do valor
     * @param j a coluna do fator
     * @return
     */
    public float obterValorExtendido(int i, int j) {
        i %= obterAltura();
        j %= obterLargura();
        return valores[i][j];
    }

    public Matriz obterMatrizComplemento() {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para que tenha uma matriz complemento");
        }

        int ordem = obterAltura();
        Matriz m = new Matriz(ordem, ordem);
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                m.definirValor(obterMenorComplemento(i, j), i, j);
            }
        }
        return m;
    }

    public Matriz obterMatrizCofator() {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para que tenha uma matriz cofator");
        }

        int ordem = obterAltura();
        Matriz m = new Matriz(ordem, ordem);
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                m.definirValor(obterCofator(i, j), i, j);
            }
        }
        return m;
    }

    public float obterDeterminante() {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para que tenha um determinate");
        }

        int ordem = obterAltura();

        switch (ordem) {
            case 1:
                return valores[0][0];
            case 2:
                return valores[0][0] * valores[1][1] - valores[0][1] * valores[1][0];
            case 3:
                float determinante = 0;
                for (int k = 0; k < 3; k++) {//diagonais principais
                    float multiplicado = 1;
                    for (int l = 0; l < 3; l++) {
                        multiplicado *= obterValorExtendido(l, k + l);
                    }
                    determinante += multiplicado;
                }
                for (int k = 0; k < 3; k++) {//diagonais oposta
                    float multiplicado = 1;
                    for (int l = 0; l < 3; l++) {
                        multiplicado *= obterValorExtendido(2 - l, k + l);
                    }
                    determinante -= multiplicado;
                }
                return determinante;
        }

        //aqui o coisa começa a ficar interresante, usando método de Laplace
        //vou utilizar a primeira linha no cálculo do determinante
        float determinante = 0;
        for (int j = 0; j < ordem; j++) {
            System.out.printf("cofator em %d %d\n", 0, j);
            determinante += valores[0][j] * obterCofator(0, j);
        }

        return determinante;
    }

    public float obterCofator(int i, int j) {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para ter um cofator");
        }
        int ordem = obterAltura();
        if (ordem == 1) {
            throw new IllegalStateException("a matriz deve ser de pelo menos ordem 2 para ter um cofator");
        }

        return sinalCofator(i, j) * obterMenorComplemento(i, j);
    }

    public float obterMenorComplemento(int i, int j) {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para ter um menor complemento");
        }

        int ordem = obterAltura();
        if (ordem == 1) {
            throw new IllegalStateException("a matriz deve ser de pelo menos ordem 2 para ter um menor complemento");
        }

        Matriz menor = new Matriz(ordem - 1, ordem - 1);
        for (int k = 0, y = 0; k < ordem; k++) {
            if (k != i) {
                for (int l = 0, x = 0; l < ordem; l++) {
                    if (l != j) {
                        menor.definirValor(valores[k][l], x, y);
                        x++;
                    }
                }
                y++;
            }
        }

        return menor.obterDeterminante();
    }

    /**
     * Cria uma nova matriz de tamanho diferente, e copia os valores dessa
     * matriz para a nova
     *
     * @param m a altura da nova matriz
     * @param n a largura da nova matriz
     * @return a nova matriz
     */
    public Matriz redimensionar(int m, int n) {
        Matriz nova = new Matriz(m, n);
        int ml = Math.min(m, obterAltura());
        int nl = Math.min(n, obterLargura());

        for (int i = 0; i < ml; i++) {
            for (int j = 0; j < nl; j++) {
                nova.definirValor(obterValor(i, j), i, j);
            }
        }
        return nova;
    }

    /**
     * transpôe essa matriz em si mesma
     */
    public void transpor() {
        int m = obterAltura();
        int n = obterLargura();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                float t = valores[i][j];
                valores[i][j] = valores[j][i];
                valores[j][i] = t;
            }
        }
    }

    /**
     *
     * @return Uma representação textual da matriz
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (float[] linhas : valores) {
            for (float coluna : linhas) {
                sb.append(coluna);
                sb.append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     *
     * @param ordem a ordem da matriz, levando em conta que toda matriz
     * identidade é uma matriz quadrada
     * @return uma nova matriz identidade
     */
    public static Matriz gerarIdentidade(int ordem) {
        Matriz identidade = new Matriz(ordem, ordem);
        for (int k = 0; k < ordem; k++) {
            identidade.definirValor(1, k, k);
        }
        return identidade;
    }

    /**
     * O sinal cofator definido como (-1)^(i + j)
     *
     * @param i a linha
     * @param j a coluna
     * @return 1 ou -1
     */
    public static float sinalCofator(int i, int j) {
        return ((i + j) % 2 == 0) ? 1f : -1f;
    }
}
