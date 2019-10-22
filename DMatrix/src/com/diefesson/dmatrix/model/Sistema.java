package com.diefesson.dmatrix.model;

import java.util.Arrays;

/**
 * Classe desnecessária, já começei a adcionar novos métodos na classe Matriz
 * dessa forma é mais flexivel de trabalhar com Gauss, fatoração LU e eliminação
 * por linhas
 *
 * @author Diefesson de Sousa Silva
 */
@Deprecated()//Se eu não marcar eu não lembro
public class Sistema {

    private final Matriz dependentes, independentes;
    private final Double[] solucao;
    private TipoSistema tipoSistema = null;

    /**
     * OBS: essa operação clona as matrizes dadas
     *
     * @param dependentes a matriz com os termos dependentes
     * @param independentes a matriz com os termos independentes
     */
    public Sistema(Matriz dependentes, Matriz independentes) {
        if (dependentes.obterAltura() != independentes.obterAltura()) {
            throw new IllegalArgumentException("as matrizes devem ter a mesma altura");
        }
        if (independentes.obterLargura() != 1) {
            throw new IllegalArgumentException("a matriz dos termos independetes deve ter largura 1");
        }

        this.dependentes = new Matriz(dependentes);
        this.independentes = new Matriz(independentes);
        solucao = new Double[dependentes.obterLargura()];
    }

    /**
     *
     * @return Uma cópia da matriz dos termos dependentes
     */
    public Matriz obterDependentes() {
        return new Matriz(dependentes);
    }

    /**
     *
     * @return Uma cópia dos termos independentes da matriz
     */
    public Matriz obterIndependentes() {
        return new Matriz(independentes);
    }

    /**
     *
     * @return a cópia do vetor de solução, valores não solucionados serão null
     */
    public Double[] obterSolucao() {
        return Arrays.copyOf(solucao, solucao.length);
    }

    /**
     * Tenta solucionar o sistema
     *
     * @return O tipo do sistema
     */
    public TipoSistema solucionar() {
        if (tipoSistema == null) {//Caso o sistema ainda não tenha sido solucionado, tenta solucionalo
            gauss();
            substituicaoParaTras();
        }
        return tipoSistema;
    }

    /**
     *
     * @return o indice da primeira equação degenerada ou -1 caso não encontrar
     */
    public int procurarDegenerada() {
        int m = dependentes.obterAltura();
        int n = dependentes.obterLargura();
        for (int i = 0; i < m; i++) {
            if (verificarEquacao(i) == TipoEquacao.DEGENERADA) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Verifica se a equação de uma dada linha é normal, degenerada ou nula
     *
     * @param i a linha equação a ser verificada
     * @return o tipo da equaçao
     */
    public TipoEquacao verificarEquacao(int i) {
        for (int j = 0, n = dependentes.obterLargura(); j < n; j++) {
            if (dependentes.obterValor(i, j) != 0) {
                return TipoEquacao.NORMAL;
            }
        }
        //Se chegou até aqui então todos os termos dependentes são zero
        if (independentes.obterValor(i, 0) != 0) {
            return TipoEquacao.DEGENERADA;
        } else {
            return TipoEquacao.NULA;
        }
    }

    /**
     *
     * @param linha a linha a ser analisada
     * @return a quantidade de zeros consecutivos no inicio da linha
     */
    public int obterNZeros(int linha) {
        int m = dependentes.obterAltura();
        int j = 0;
        for (; j < m; j++) {
            if (dependentes.obterValor(linha, j) != 0) {
                break;
            }
        }
        return j;
    }

    private void gauss() {
        int m = dependentes.obterAltura();
        int n = dependentes.obterLargura();
        for (int i = 0, j = 0; i < m && j < n; j++) {
            int pivo = obterPivo(j);//A linha do pivô
            if (pivo != -1) {
                dependentes.trocarLinha(i, pivo);//Traz esses valores até a linha correta
                independentes.trocarLinha(i, pivo);
                aplicarGauss(i, j);
                i++;//avança para a próxima linha
            }
        }
    }

    /**
     * Aplica gauss decendo uma coluna Talvez sea movido para a classe Matriz
     *
     * @param i a linha do pivo
     * @param j a coluna do pivo
     */
    private void aplicarGauss(int i, int j) {
        int m = dependentes.obterAltura();
        for (int ii = i + 1; ii < m; ii++) {//ii é a linha de destinho da soma de linhas
            double razao = -(dependentes.obterValor(ii, j) / dependentes.obterValor(i, j));
            dependentes.somarLinha(i, ii, razao);
            independentes.somarLinha(i, ii, razao);
        }
    }

    /**
     *
     * @param nZeros a quantidade de zeros que a linha deve ter
     * @return a linha com o determinado número de zeros, -1 caso não encontre
     */
    private int obterPivo(int nZeros) {
        int m = dependentes.obterLargura();
        for (int i = 0; i < m; i++) {
            if (obterNZeros(i) == nZeros) {
                return i;
            }
        }
        return -1;
    }

    public int obterPivoParcial(int coluna) {
        int m = dependentes.obterAltura();
        double maior = 0;
        int linha = -1;
        for (int i = 0; i < m; i++) {
            double valor = Math.abs(dependentes.obterValor(i, coluna));
            if (valor > maior) {
                linha = i;
                maior = valor;
            }
        }
        return linha;
    }

    private void substituicaoParaTras() {
        boolean indeterminado = false;
        boolean degenerado = false;

        int m = dependentes.obterAltura();
        for (int i = m - 1; i >= 0; i--) {//Não sai do loop ao encontrar degeneradas e indenterminações para tentar resolver o máximo de equações póssiveis
            TipoEquacao t = verificarEquacao(i);
            if (t == TipoEquacao.NORMAL) {
                if (!solucionarEquacao(i)) {
                    indeterminado = true;
                }
            } else if (t == TipoEquacao.DEGENERADA) {
                degenerado = true;
            }
        }

        if (degenerado) {
            tipoSistema = TipoSistema.IMPOSSIVEL;
        } else if (indeterminado) {
            tipoSistema = TipoSistema.POSSIVEL_INDERMINADO;
        } else {
            tipoSistema = TipoSistema.POSSIVEL_DETERMINADO;
        }
    }

    /**
     * OBS: esse método confia que a equação não é nula, nem degenerada
     *
     * @param i a linha a ser solucionada
     * @return true caso consiga solucionar, false caso contrário
     */
    private boolean solucionarEquacao(int i) {
        int jPivo = obterNZeros(i);//A coluna do termo a ser solucionado
        int n = dependentes.obterLargura();

        //Os valores do termo dependente e do termo indenpendente
        double dependente = dependentes.obterValor(i, jPivo);
        double independente = independentes.obterValor(i, 0);

        for (int j = jPivo + 1; j < n; j++) {
            double d = dependentes.obterValor(i, j);
            Double s = solucao[j];

            if (d != 0) {
                if (s != null) {
                    independente += d * s;//Equivale a passar os dependentes e suas soluções já calculadas para o outro lado
                } else {
                    return false;//Não a como resolver essa equação sem s
                }
            }
        }

        double s = independente / dependente;
        solucao[jPivo] = s;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("dependentes:\n");
        sb.append(dependentes.toString());

        sb.append("indepentes:\n");
        sb.append(independentes.toString());

        sb.append("solução:\n");
        for (Double s : solucao) {
            sb.append(s);
            sb.append('\n');
        }

        return sb.toString();
    }

}
